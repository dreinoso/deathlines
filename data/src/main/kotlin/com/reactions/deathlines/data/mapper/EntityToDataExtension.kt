package com.reactions.deathlines.data.mapper

import com.reactions.deathlines.data.db.album.AlbumData
import com.reactions.deathlines.domain.entity.Entity

/**
 * Extension class to map album entity to album data
 */
fun Entity.Album.map() = AlbumData.Album(
        id = id,
        userId = userId,
        title = title
)