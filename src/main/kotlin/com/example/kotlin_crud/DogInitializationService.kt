package com.example.kotlin_crud

import org.springframework.stereotype.Service
import jakarta.annotation.PostConstruct
import java.util.UUID

@Service
class DogInitializationService(
    private val dogRepository: DogRepository
) {
    @PostConstruct
    fun init() {
        val uuid: String = "d52a4216-0acc-43d7-ba00-d3ffdeecc59b"
        val uuid2: String = "e511a884-399c-40a2-81ce-7a0225f37274"
        val uuid3: String = "7dd9758c-44cc-42de-9545-edd0ee2aa3ce"
        val uuid4: String = "2a61d082-7021-4e73-9434-08b708b6b548"
        val uuid5: String = "3baf7d0a-35ea-41e9-8156-98aab2d67b28"

        val dog = Dog(
            id = UUID.fromString(uuid),
            name = "Gauss",
            breed = "German Shorthaired Pointer",
            birthdate = "2020-11-06",
            mother = "Yara",
            father = null)

        val dog2 = Dog(
            UUID.fromString(uuid2),
            "Manhattan",
            null,
            "2012-06-15",
            null,
            null)

        val dog3 = Dog(
            UUID.fromString(uuid3),
            "Max",
            "Labrador Retriever",
            "2019-05-15",
            null,
            "Buddy")

        val dog4 = Dog(
            UUID.fromString(uuid4),
            name = "Buddy",
            breed = "Golden Retriever",
            birthdate = "2020-07-20",
            mother = null,
            father = null)

        val dog5 = Dog(
            UUID.fromString(uuid5),
            "Bailey",
            "Beagle",
            "2018-10-25",
            null,
            null)

        dogRepository.save(dog)
        dogRepository.save(dog2)
        dogRepository.save(dog3)
        dogRepository.save(dog4)
        dogRepository.save(dog5)
        }
    }
