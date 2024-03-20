package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

// http://127.0.0.1:8080/get/{NAME}

@RestController
class GetDogByNameController(
    private val jpaDogRepository: JpaDogRepository
) {
    @GetMapping("/get/{name}")
    fun getDogByName(@PathVariable name: String): JpaDog? {
        return jpaDogRepository.findByName(name)
    }
}