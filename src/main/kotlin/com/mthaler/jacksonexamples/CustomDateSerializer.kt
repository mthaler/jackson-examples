package com.mthaler.jacksonexamples

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.text.SimpleDateFormat
import java.util.*


class CustomDateSerializer(t: Class<Date>): StdSerializer<Date>(t) {

    constructor() : this(Date::class.java)

    override fun serialize(value: Date, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeString(formatter.format(value));
    }

    companion object {
        private val formatter = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
    }
}
