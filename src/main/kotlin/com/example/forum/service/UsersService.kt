package com.example.forum.service

import com.example.forum.model.Users
import com.example.forum.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersService(private val repository: UsersRepository) {

    fun searchId(id: Long): Users {
        return repository.getOne(id)
    }
}
