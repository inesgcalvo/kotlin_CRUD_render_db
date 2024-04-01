package com.example.kotlin_crud

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DogRepository: JpaRepository<Dog, UUID> {
}