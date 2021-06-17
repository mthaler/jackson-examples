package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.*

class EventWithSerializer(val name: String, @JsonSerialize(using = CustomDateSerializer::class) val eventDate: Date)