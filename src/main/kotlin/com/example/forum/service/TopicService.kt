package com.example.forum.service

import com.example.forum.dataTransferObject.TopicForm
import com.example.forum.dataTransferObject.TopicView
import com.example.forum.dataTransferObject.UpdateTopicForm
import com.example.forum.exception.NotFoundException
import com.example.forum.mapper.TopicFormMapper
import com.example.forum.mapper.TopicViewMapper
import com.example.forum.model.Topic
import com.example.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun list(): List<TopicView> {
        return repository.findAll().stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun searchId(id: Long): TopicView {
        val topic = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicViewMapper.map(topic)
    }

    fun register(form: TopicForm): TopicView  {
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}