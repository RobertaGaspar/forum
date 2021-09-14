package com.example.forum.dataTransferObject

import com.example.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val creationDate: LocalDateTime,
    val status: StatusTopic,
)
