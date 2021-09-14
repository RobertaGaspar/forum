package com.example.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,
    var message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: User,

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopic = StatusTopic.NO_RESPONDED,

    @OneToMany(mappedBy = "topic")
    val answer: List<Answer> = ArrayList(),
)