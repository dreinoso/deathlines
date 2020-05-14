package com.reactions.deathlines.data.datasource.album

import androidx.paging.DataSource
import io.reactivex.Single
import com.reactions.deathlines.data.datasource.BaseDataSource
import com.reactions.deathlines.domain.entity.Entity

/**
 * Album database data source
 */
interface AlbumsDatabaseDataSource : BaseDataSource {

    /**
     * Get all of albums from database implementation
     */
    fun getAlbums(): DataSource.Factory<Int, Entity.Album>

    /**
     * Persist all of albums in local database
     */
    fun persist(albums: List<Entity.Album>, insertFinished: () -> Unit)

    fun deleteAlbum(album: Entity.Album): Single<Int>
}