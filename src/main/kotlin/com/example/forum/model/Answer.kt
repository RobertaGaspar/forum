package com.example.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val messageAnswer: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val author: User,

    @ManyToOne
    val topic: Topic,
    val solution: Boolean,
)
