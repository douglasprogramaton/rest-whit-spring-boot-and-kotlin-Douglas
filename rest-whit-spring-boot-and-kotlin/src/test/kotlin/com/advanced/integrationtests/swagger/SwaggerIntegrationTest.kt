package com.advanced.integrationtests.swagger

import com.advanced.integrationtests.TestConfigs
import com.advanced.integrationtests.testcontainers.AbstractIntegrationTest
import com.kotlinstping.advanced.RestWhitSpringBootAndKotlinApplication
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
	classes = [RestWhitSpringBootAndKotlinApplication::class],
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest() : AbstractIntegrationTest() {

	@Test
	fun shouldDisplaySwaggerUiPage() {
		val content = given()
			.basePath("/swagger-ui/index.html")
			.port(TestConfigs.SERVER_PORT)
				.`when`()
			.get()
			.then()
				.statusCode(200)
			.extract()
			.body()
				.asString()
		assertTrue(content.contains("Swagger UI"))
	}

}