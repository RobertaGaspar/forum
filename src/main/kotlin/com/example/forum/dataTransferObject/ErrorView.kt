package com.example.forum.dataTransferObject

import java.time.LocalDateTime

data class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val messageError: String?,
    val path: String
)
