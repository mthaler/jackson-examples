package com.mthaler.jacksonexamples

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.*

class EventWithFormat(
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") val eventDate: Date
)

fun EventWithFormat.toJson(): String = jacksonObjectMapper().writeValueAsString(this)