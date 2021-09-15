package com.example.forum.service

import com.example.forum.model.Course
import com.example.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repostory: CourseRepository) {

    fun searchId(id: Long): Course {
        return repostory.getOne(id)
    }
}
