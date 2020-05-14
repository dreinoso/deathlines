package com.reactions.deathlines.domain.repository.album

import androidx.paging.PagedList
import io.reactivex.Flowable
import io.reactivex.Single
import com.reactions.deathlines.domain.common.ResultState
import com.reactions.deathlines.domain.entity.Entity
import com.reactions.deathlines.domain.repository.BaseRepository

/**
 * Album repository
 */
interface AlbumsRepository : BaseRepository {

    /**
     * Perform
     */
    fun getAlbums(): Flowable<ResultState<PagedList<Entity.Album>>>

    fun deleteAlbum(album: Entity.Album): Single<ResultState<Int>>

    //fun loadAlbums(pageNumber: Int): Single<ResultState<List<Entity.Album>>>
}