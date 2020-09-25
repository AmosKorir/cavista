package com.amoskorir.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.repositories.ImageRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(
    val imageApiRepository: ImageRepository,
    val imageDbRepository: ImageRepository
) : ViewModel() {

    val handleErrorLiveData = MutableLiveData<Throwable>()
    val imagesLiveData = MutableLiveData<List<Image>>()
    private val compositeDisposable = CompositeDisposable()

    fun searchImages(searchString: String) {
        val disposable = imageApiRepository.searchImages(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    imagesLiveData.value = it
                }, { handleErrorLiveData.value = it }
            )
        compositeDisposable.add(disposable)
    }

}
