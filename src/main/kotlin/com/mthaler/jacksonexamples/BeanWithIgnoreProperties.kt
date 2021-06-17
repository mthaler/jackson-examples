package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@JsonIgnoreProperties("id")
class BeanWithIgnoreProperties(val id: Int, val name: String)

fun BeanWithIgnoreProperties.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toBeanWithIgnoreProperties(): BeanWithIgnoreProperties = jacksonObjectMapper().readValue(this, BeanWithIgnoreProperties::class.java)