package com.reactions.deathlines.domain.entity

/**
 * Album entity
 */
sealed class Entity {

    data class Album(
            val id: Long,
            val title: String,
            val userId: Long
    ) : Entity()
}