package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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
})