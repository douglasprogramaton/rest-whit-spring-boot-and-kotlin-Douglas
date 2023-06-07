package com.advanced.integrationtests.repository

import com.advanced.integrationtests.testcontainers.AbstractIntegrationTest
import com.kotlinstping.advanced.RestWhitSpringBootAndKotlinApplication
import com.kotlinstping.advanced.model.Person
import com.kotlinstping.advanced.repository.PersonRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

@SpringBootTest(classes = [RestWhitSpringBootAndKotlinApplication::class])
class PersonRepositoryTest : AbstractIntegrationTest() {

    @Autowired
    private lateinit var repository: PersonRepository

    private lateinit var person: Person

    @BeforeEach
    fun setup() {
        person = Person()
    }

    @Test
    @Order(1)
    fun testFindByName() {
        val pageable: Pageable = PageRequest.of(0, 12, Sort.by(Sort.Direction.ASC, "firstName"))

        person = repository.findPersonByName("ayr", pageable).content[0]

        assertNotNull(person)
        assertNotNull(person.id)
        assertNotNull(person.firstName)
        assertNotNull(person.lastName)
        assertNotNull(person.address)
        assertNotNull(person.gender)
        assertEquals("Ayrton", person.firstName)
        assertEquals("Senna", person.lastName)
        assertEquals("São Paulo", person.address)
        assertEquals("Male", person.gender)
        assertEquals(true, person.enabled)
    }


}
