package com.reactions.deathlines.presentation.ui.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import io.reactivex.disposables.Disposable
import com.reactions.deathlines.domain.common.ResultState
import com.reactions.deathlines.domain.entity.Entity
import com.reactions.deathlines.domain.usecase.album.GetAlbumsUseCase
import com.reactions.deathlines.presentation.common.OperationLiveData
import com.reactions.deathlines.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : BaseViewModel() {

    private var tempDispossable: Disposable? = null
    //var page = 1
    private val albumToBeDeleted = MutableLiveData<Entity.Album>()
    //private val pageLiveData by lazy { MutableLiveData<String>()/*.defaultValue(1)*/ }
    //val pageNumberLiveData by lazy { MutableLiveData<Int>().defaultValue(1) }
    private val fetch = MutableLiveData<String>()

    val deletedAlbumLiveData: LiveData<ResultState<Int>> = Transformations.switchMap(albumToBeDeleted) {
        OperationLiveData<ResultState<Int>> {
            getAlbumsUseCase.deleteAlbum(it).toFlowable().subscribe { resultState ->
                postValue(resultState)
            }
        }
    }

    fun deleteAlbum(album: Entity.Album) {
        albumToBeDeleted.postValue(album)
    }

    //val networkErrors: LiveData<String> = Transformations.switchMap(repoResult) { it -> it.networkErrors }

    val albumsLiveData: LiveData<ResultState<PagedList<Entity.Album>>> = Transformations.switchMap(fetch) {
        OperationLiveData<ResultState<PagedList<Entity.Album>>> {

            if (tempDispossable?.isDisposed != true)
            //if (tempDispossable != null && !tempDispossable!!.isDisposed)
                tempDispossable?.dispose()
            tempDispossable = getAlbumsUseCase.getAlbums().subscribe { resultState ->
                postValue((resultState))
                /*when (resultState) {
                    is ResultState.Success ->
                        pageNumberLiveData.postValue(resultState.data.size)
                }*/
            }
            tempDispossable?.track()
        }
    }

    fun getAlbums() {
        fetch.postValue("")
        //page++
    }
}