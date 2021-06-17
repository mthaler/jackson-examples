package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DeserializeTest: StringSpec({

    "deserializeUsing@JsonCreator" {
        val json = """{"id":1, "theName":"My Bean"}"""

        val bean = ObjectMapper()
            .readerFor(BeanWithCreator::class.java)
            .readValue<BeanWithCreator>(json)

        bean shouldBe BeanWithCreator(1, "My Bean")
    }
})