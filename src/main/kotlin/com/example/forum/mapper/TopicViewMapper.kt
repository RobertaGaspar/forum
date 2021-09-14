package com.example.forum.mapper

import com.example.forum.dataTransferObject.TopicView
import com.example.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.creationDate,
            status = t.status
        )
    }

}