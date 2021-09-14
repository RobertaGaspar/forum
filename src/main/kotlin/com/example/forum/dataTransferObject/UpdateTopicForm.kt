package com.example.forum.dataTransferObject

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTopicForm(

    @field:NotNull
    val id: Long,

    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val title: String,

    @field:NotEmpty(message = "Mensagem nao pode ser nulo")
    val message: String,
)
