package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

data class PredictionResponse(
    val input: String,
    val prediction: String,
    val probability: Double
)

@RestController
class PredictionController {

    private val restTemplate = RestTemplate()

    @GetMapping("/predict/{variable}")
    fun predict(@PathVariable variable: String): PredictionResponse {
        val apiUrl = "https://alexandria-ml-models.onrender.com/predict/$variable"
        val response = restTemplate.getForObject(apiUrl, PredictionResponse::class.java)
            ?: throw IllegalStateException("Failed to fetch prediction")
        return response
    }
}