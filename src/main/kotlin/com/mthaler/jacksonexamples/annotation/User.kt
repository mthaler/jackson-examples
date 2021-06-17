package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

data class User(val id: String, val age: Int)

fun User.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toUser(): User = jacksonObjectMapper().readValue(this, User::class.java)