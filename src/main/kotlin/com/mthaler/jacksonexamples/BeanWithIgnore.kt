package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class BeanWithIgnore(@JsonIgnore val id: Int, val name: String)

fun BeanWithIgnore.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toBeanWithIgnore(): BeanWithIgnore = jacksonObjectMapper().readValue(this, BeanWithIgnore::class.java)