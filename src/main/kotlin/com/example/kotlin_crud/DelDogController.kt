package com.example.kotlin_crud

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID
import kotlin.NoSuchElementException

@RestController
class DelDogController(
    private val jpaDogRepository: JpaDogRepository
) {
    @DeleteMapping("/dogs/{id}")
    fun deleteDogById(@PathVariable id: UUID): String {
        val dogOptional = jpaDogRepository.findById(id.toString())
        return if (dogOptional.isPresent) {
            jpaDogRepository.deleteById(id.toString())
            "Dog with ID $id deleted successfully."
        } else {
            throw NoSuchElementException("Dog with ID $id not found")
        }
    }
}