package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.*

class EventWithSerializer(val name: String, @JsonSerialize(using = CustomDateSerializer::class) @JsonDeserialize(using = CustomDateDeserializer::class) val eventDate: Date)

fun EventWithSerializer.toJson(): String = jacksonObjectMapper().writeValueAsString(this)
fun String.toEventWithSerializer(): EventWithSerializer = jacksonObjectMapper().readerFor(EventWithSerializer::class.java).readValue(this)