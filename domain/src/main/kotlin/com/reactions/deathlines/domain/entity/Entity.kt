package com.reactions.deathlines.domain.entity

import com.reactions.deathlines.domain.entity.satates.GoalState
import com.reactions.deathlines.domain.entity.satates.TaskState

/**
 * Album entity
 */
sealed class Entity {

    data class Album(
            val id: Long,
            val title: String,
            val userId: Long
    ) : Entity()

    data class Goal(
            val id: Long,
            val name: String,
            val description: String,
            val tasks: List<Task>,
            val limitDate: String,
            val percentCompleted : Int,
            val workDays : Int,
            val status : GoalState,
            val userId: Long
    ) : Entity()

    data class Task(
            val id: Long,
            val name: String,
            val description: String,
            val limitDate: String,
            val percentCompleted : Int,
            val workHours : Int,
            val status : TaskState,
            val userId: Long
    ) : Entity()
}