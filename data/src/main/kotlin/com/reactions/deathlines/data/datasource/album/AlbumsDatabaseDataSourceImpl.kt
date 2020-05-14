package com.reactions.deathlines.data.datasource.album

import androidx.paging.DataSource
import com.reactions.deathlines.data.db.album.AlbumDao
import com.reactions.deathlines.data.mapper.map
import com.reactions.deathlines.domain.entity.Entity
import java.util.concurrent.Executor

/**
 * Album database data source implementation
 */
class AlbumsDatabaseDataSourceImpl(private val albumDao: AlbumDao,
                                   private val ioExecutor: Executor) : AlbumsDatabaseDataSource {

    /**
     * Get all of albums from database implementation
     */
    override fun getAlbums(): DataSource.Factory<Int, Entity.Album> =
            albumDao.selectAllPaged()
                    .map { it.map() }

    /**
     * Persist all of albums in local database implementation
     */
    override fun persist(albums: List<Entity.Album>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            albumDao.insert/*persist*/(albums.map { it.map() })
            insertFinished()
        }
    }

    override fun deleteAlbum(album: Entity.Album) = albumDao.delete(album.map())
}