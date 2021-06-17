package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.text.SimpleDateFormat

class SerializeTest: StringSpec({

    "serializeUsing@JsonAnyGetter" {
        val bean = ExtendableBean("My bean")
        bean.add("attr1", "val1")
        bean.add("attr2", "val2")

        val result = ObjectMapper().writeValueAsString(bean)

        result shouldBe """{"name":"My bean","attr2":"val2","attr1":"val1"}"""
    }

    "serializeUsing@JsonGetter" {
        val bean = MyBean(1, "My bean")

        val result = ObjectMapper().writeValueAsString(bean)

        result shouldBe """{"id":1,"name":"My bean"}"""
    }

    "serializeUsing@JsonPropertyOrder" {
        val bean = MyBean2(1, "My bean")

        val result = ObjectMapper().writeValueAsString(bean)

        result shouldBe """{"name":"My bean","id":1}"""
    }

    "serializeUsing@JsonRawValue" {
        val bean = RawBean("My bean", """{"attr":false}""")

        val result = ObjectMapper().writeValueAsString(bean)

        result shouldBe """{"name":"My bean","json":{"attr":false}}"""
    }

    "serializeUsing@JsonRootName" {
        val user = UserWithRoot(1, "John")

        val mapper = ObjectMapper()
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
        val result = mapper.writeValueAsString(user)

        result shouldBe """{"user":{"id":1,"name":"John"}}"""
    }

//    "serializeUsing@JsonSerialize" {
//        val df = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
//
//        val toParse = "20-12-2014 02:30:00"
//        val date = df.parse(toParse)
//        val event = EventWithSerializer("party", date)
//
//        val result = ObjectMapper().writeValueAsString(event)
//
//        println(result)
//    }
})