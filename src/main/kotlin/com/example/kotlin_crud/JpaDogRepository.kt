package com.example.kotlin_crud

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaDogRepository: JpaRepository<JpaDog, String> {
    fun findByName(name: String): JpaDog?
    @Query("SELECT COALESCE(MIN(d.primary_key), 0) FROM dogrepository d WHERE NOT EXISTS (SELECT 1 FROM dogrepository d2 WHERE d2.primary_key = d.primary_key + 1)")
    fun findLastIdNumber(): Int
}