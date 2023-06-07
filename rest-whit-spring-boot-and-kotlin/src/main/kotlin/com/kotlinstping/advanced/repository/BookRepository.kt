package com.kotlinstping.advanced.repository


import com.kotlinstping.advanced.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long?>