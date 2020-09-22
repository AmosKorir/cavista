
import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.amoskorir.data.BuildConfig
import com.amoskorir.domain.CovistaConstants
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

class ApiModule {
    companion object : KoinComponent {
        val apiModule = module {
            @SuppressLint("ApplySharedPref")
            fun sendErrorBody(body: String) {
                val sharedPreferences: SharedPreferences by inject()
                sharedPreferences.edit().putString(CovistaConstants.ERROR_RESPONSE, body).apply()
            }

            fun getAccessToken(): String? {
                val sharedPreferences: SharedPreferences by inject()
                return sharedPreferences.getString(CovistaConstants.ACCESS_TOKEN, "")
            }

            fun provideHttClientWithToken(): OkHttpClient {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClientBuilder = OkHttpClient.Builder()
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val original: Request = chain.request()
                            val request: Request = original.newBuilder()
                                .header("Authorization", "Bearer  " + getAccessToken()!!)
                                .build()
                            return chain.proceed(request)
                        }

                    })
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val request = chain.request()
                            val response = chain.proceed(request)

                            val responseBody = response.body
                            val source = responseBody?.source();
                            source?.request(Long.MAX_VALUE); // request the entire body.
                            val buffer = source?.buffer();
                            val responseBodyString =
                                buffer?.clone()?.readString(Charset.forName("UTF-8"))
                            if (response.code in 400..500) {
                                if (responseBodyString != null) {
                                    sendErrorBody(responseBodyString)
                                }
                                return response
                            }

                            return response
                        }

                    })
                    .addInterceptor(httpLoggingInterceptor)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)

                return okHttpClientBuilder.build()
            }

            fun provideHttpClient(): OkHttpClient {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClientBuilder = OkHttpClient.Builder()
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val original: Request = chain.request()
                            val request: Request = original.newBuilder()
                                .build()
                            return chain.proceed(request)
                        }

                    })
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val request = chain.request()
                            val response = chain.proceed(request)

                            val responseBody = response.body
                            val source = responseBody?.source();
                            source?.request(Long.MAX_VALUE); // request the entire body.
                            val buffer = source?.buffer();
                            val responseBodyString =
                                buffer?.clone()?.readString(Charset.forName("UTF-8"))
                            if (response.code in 400..500) {
                                if (responseBodyString != null) {
                                    sendErrorBody(responseBodyString)
                                }
                                return response
                            }

                            return response
                        }

                    })
                    .addInterceptor(httpLoggingInterceptor)

                return okHttpClientBuilder.build()
            }

            fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
                return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(factory))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            }

            fun provideGson(): Gson {
                return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
            }

            // api services



            single { provideGson() }
            single(named("default_okhttp")) { provideHttpClient() }
            single(named("access_Okhttp")) { provideHttClientWithToken() }
            single(named("withoutToken_retrofit")) {
                provideRetrofit(
                    get(),
                    get(named("default_okhttp"))
                )
            }
            single { provideRetrofit(get(), get(named("access_Okhttp"))) }


        }
    }
}