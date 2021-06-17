package com.mthaler.jacksonexamples

import com.fasterxml.jackson.databind.InjectableValues
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.text.SimpleDateFormat

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

    "deserializeUsing@AnySetter" {
        val json = """{"name":"My bean","attr2":"val2","attr1":"val1"}"""
        json.toExtendableBean().getProperties() shouldBe  mapOf("attr1" to "val1", "attr2" to "val2")
    }

    "deserializeUsing@JsonSetter" {
        val json = """{"name":"My bean"}"""
        json.toMyBean().getTheName() shouldBe "My bean"
    }

    "deserializeUsing@JsonDeserialize" {
        val json = """{"name":"party","eventDate":"20-12-2014 02:30:00"}"""

        val df = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        val event = json.toEventWithSerializer()

        df.format(event.eventDate) shouldBe "20-12-2014 02:30:00"
    }

    "deserializeUsing@JsonAlias" {
        val json = """{"fname":"John", "lastName":"Green"}"""
        val bean = json.toAliasBean()
        bean.firstName shouldBe "John"
        bean.lastName shouldBe "Green"
    }

    "deserializeUsing@JsonIgnoreProperties" {
        val json = """{"name":"test"}"""
        val bean = json.toBeanWithIgnore()
        bean.id shouldBe 0
        bean.name shouldBe "test"
    }
})