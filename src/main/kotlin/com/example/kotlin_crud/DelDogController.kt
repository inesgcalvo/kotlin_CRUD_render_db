package com.example.kotlin_crud

import org.springframework.web.bind.annotation.*

// http://127.0.0.1:8080/del/{NAME}

@RestController
class DelDogController(
    private val jpaDogRepository: JpaDogRepository
) {

    @DeleteMapping("/del/{name}")
    fun deleteDogByName(@PathVariable name: String): String {
        val dog = jpaDogRepository.findByName(name)
        return if (dog != null) {
            jpaDogRepository.delete(dog)
            "Dog with name $name deleted successfully."
        } else {
            throw NoSuchElementException("Dog with name $name not found")
            "Dog with name $name not found"
        }
    }
}