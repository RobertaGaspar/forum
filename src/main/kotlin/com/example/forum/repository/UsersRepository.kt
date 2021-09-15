package com.example.forum.repository

import com.example.forum.model.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Long> {
}