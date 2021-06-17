package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.text.SimpleDateFormat
import java.util.*

class CustomDateDeserializer(vc: Class<*>): StdDeserializer<Date>(vc) {

    constructor(): this(Date::class.java)

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Date {
        val date = p.getText()
        return formatter.parse(date)
    }

    companion object {
        private val formatter = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
    }
}