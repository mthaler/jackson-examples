package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.InjectableValues
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DeserializeTest: StringSpec({

    "deserializeUser" {
        val json = """{"id":"adams","age":42}"""
        json.toUser() shouldBe User("adams", 42)
    }

    "deserializeUsing@JsonCreator" {
        val json = """{"id":1, "theName":"My Bean"}"""

        val bean = ObjectMapper()
            .readerFor(BeanWithCreator::class.java)
            .readValue<BeanWithCreator>(json)

        bean shouldBe BeanWithCreator(1, "My Bean")
    }

    "deserializeUsing@Inject" {
        val json = """{"name":"My bean"}"""
        val inject = InjectableValues.Std().addValue(Int::class.javaPrimitiveType, 1)
        val bean = jacksonObjectMapper().reader(inject).forType(BeanWithInject::class.java).readValue<BeanWithInject>(json)
        bean.id shouldBe 1
        bean.name shouldBe "My bean"
    }
})