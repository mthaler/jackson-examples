package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("name", "id")
class MyBean2(val id: Int, val name: String)