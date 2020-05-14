package com.reactions.deathlines.data.datasource.album

import io.reactivex.Single
import com.com.reactions.deathlines.data.api.AlbumApi
import com.reactions.deathlines.data.common.extension.applyIoScheduler
import com.reactions.deathlines.data.mapper.map
import com.reactions.deathlines.domain.entity.Entity

/**
 * Album network data source implementation
 */
class AlbumsApiDataSourceImpl(private val api: AlbumApi) : AlbumsApiDataSource {

    /**
     * Get all of albums from network implementation
     */
    override fun getAlbums(page: Int, pageSize: Int): Single<List<Entity.Album>> =
            api.getAlbums(page, pageSize)
                    .applyIoScheduler()
                    .map { item -> item.map { it.map() } }
}