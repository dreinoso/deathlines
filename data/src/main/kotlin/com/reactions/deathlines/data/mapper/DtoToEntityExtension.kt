package com.reactions.deathlines.data.mapper

import com.com.reactions.deathlines.data.api.AlbumApi
import com.reactions.deathlines.domain.entity.Entity

/**
 * Extension class to map album dto to album entity
 */
fun AlbumApi.Dto.Album.map() = Entity.Album(
        id = id,
        userId = userId,
        title = title
)
