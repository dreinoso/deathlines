package com.reactions.deathlines.domain.usecase.album

import androidx.paging.PagedList
import io.reactivex.Flowable
import io.reactivex.Single
import com.reactions.deathlines.domain.common.ResultState
import com.reactions.deathlines.domain.entity.Entity
import com.reactions.deathlines.domain.usecase.BaseUseCase

/**
 * Album use case
 */
interface GetAlbumsUseCase : BaseUseCase {

    /**
     * Get all of albums use case
     */
    fun getAlbums(): Flowable<ResultState<PagedList<Entity.Album>>>

    fun deleteAlbum(album: Entity.Album): Single<ResultState<Int>>

    //fun loadAlbums(pageNumber: Int): Single<ResultState<List<Entity.Album>>>
}