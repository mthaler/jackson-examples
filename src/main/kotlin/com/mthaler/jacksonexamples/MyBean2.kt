package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.ObjectMapper

@JsonPropertyOrder("name", "id")
class MyBean2(val id: Int, val name: String)

fun MyBean2.toJson(): String = ObjectMapper().writeValueAsString(this)