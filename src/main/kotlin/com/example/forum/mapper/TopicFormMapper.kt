package com.example.forum.mapper

import com.example.forum.dataTransferObject.TopicForm
import com.example.forum.model.Topic
import com.example.forum.service.CourseService
import com.example.forum.service.UserService
import org.springframework.stereotype.Component


@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchId(t.idCourse),
            author = userService.searchId(t.idAuthor)
        )
    }

}
