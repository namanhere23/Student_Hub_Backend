package com.example

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.server.application.*
import java.io.FileInputStream

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val serviceAccount = if (System.getenv("FIREBASE_SERVICE_ACCOUNT_KEY") != null) {
        // Read from environment variable (production)
        System.getenv("FIREBASE_SERVICE_ACCOUNT_KEY").byteInputStream()
    } else {
        // Fallback to file (local development)
        this::class.java.classLoader.getResourceAsStream("service_account_key.json")
    }

    val options: FirebaseOptions? = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    FirebaseApp.initializeApp(options)

    configureSerialization()
    configureMonitoring()
    configureRouting()
}


