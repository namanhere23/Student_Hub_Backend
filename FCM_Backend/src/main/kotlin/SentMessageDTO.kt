package com.namangulati.studenthub.models

import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import kotlinx.serialization.Serializable

@Serializable
data class SentMessageDTO(
    val to:String?,
    val notification:NotificationBody
)

@Serializable
data class NotificationBody(
    val title:String,
    val body:String
)

fun SentMessageDTO.toMessage():Message{
    return Message.builder()
        .setNotification(
            Notification.builder()
                .setTitle(notification.title)
                .setBody(notification.body)
                .build()
        ).apply {
            if(to==null){
                setTopic("Chat")
            } else{
                setToken(to)
            }
        }.build()
}