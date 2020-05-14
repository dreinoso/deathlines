package com.reactions.deathlines.data.mapper

import com.reactions.deathlines.data.db.album.AlbumData
import com.reactions.deathlines.domain.entity.Entity

/**
 * Extension class to map album data to album entity
 */
fun AlbumData.Album.map() = Entity.Album(
        id = id,
        userId = userId,
        title = title
)