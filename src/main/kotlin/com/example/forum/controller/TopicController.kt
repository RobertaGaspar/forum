package com.example.forum.controller

import com.example.forum.dataTransferObject.TopicForCategoryDto
import com.example.forum.dataTransferObject.TopicForm
import com.example.forum.dataTransferObject.TopicView
import com.example.forum.dataTransferObject.UpdateTopicForm
import com.example.forum.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    @Cacheable("allTopics")
    fun list(
        @RequestParam(required = false) nameCourse: String?,
        @PageableDefault(size = 5, sort = ["creationDate"], direction = Sort.Direction.DESC) pageable: Pageable,
    ): Page<TopicView> {
        return service.list(nameCourse, pageable)
    }

    @GetMapping("/{id}")
    @Cacheable("idTopics")
    fun searchId(@PathVariable id: Long): TopicView {
        return service.searchId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["allTopics", "idTopics"], allEntries = true)
    fun register(
        @RequestBody @Valid form: TopicForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<TopicView> {
        val topicView = service.register(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["allTopics", "idTopics"], allEntries = true)
    fun update(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["allTopics", "idTopics"], allEntries = true)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

    @GetMapping("/document")
    fun document(): List<TopicForCategoryDto>{
        return service.document()
    }
}