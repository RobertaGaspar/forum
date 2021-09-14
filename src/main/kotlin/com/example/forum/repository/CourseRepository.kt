package com.example.forum.repository

import com.example.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository <Course, Long> {
}