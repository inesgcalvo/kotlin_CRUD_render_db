package com.example.kotlin_crud

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaDogRepository: JpaRepository<JpaDog, String> {
    fun findByName(name: String): JpaDog?
//    fun findById(id: UUID):JpaDog?
}