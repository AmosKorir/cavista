package com.amoskorir.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amoskorir.domain.models.Comment
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.repositories.ImageRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(
    private val imageApiRepository: ImageRepository,
    private val imageDbRepository: ImageRepository
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

    val commentLiveData = MutableLiveData<List<Comment>>()
    fun comment(imageId: String, comment: String) {
        val disposable = imageDbRepository.comment(imageId, comment)
            .subscribeOn(Schedulers.io())
            .flatMap { imageDbRepository.getImageComments(imageId) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    commentLiveData.value = it
                }, { handleErrorLiveData.value = it }
            )
        compositeDisposable.add(disposable)
    }

    fun getComments(imageId: String) {
        val disposable = imageDbRepository.getImageComments(imageId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    commentLiveData.value = it
                }, { handleErrorLiveData.value = it }
            )
        compositeDisposable.add(disposable)
    }
}
