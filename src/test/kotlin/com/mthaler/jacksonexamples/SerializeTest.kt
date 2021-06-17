package com.mthaler.jacksonexamples

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.text.SimpleDateFormat
import java.util.*


class SerializeTest: StringSpec({

    "serializeUser" {
        val user = User("adams", 42)
        user.toJson() shouldBe """{"id":"adams","age":42}"""
    }

    "serializeUsing@JsonAnyGetter" {
        val bean = ExtendableBean("My bean")
        bean.add("attr1", "val1")
        bean.add("attr2", "val2")
        bean.toJson() shouldBe """{"name":"My bean","attr2":"val2","attr1":"val1"}"""
    }

    "serializeUsing@JsonGetter" {
        val bean = MyBean(1, "My bean")
        bean.toJson() shouldBe """{"id":1,"name":"My bean"}"""
    }

    "serializeUsing@JsonPropertyOrder" {
        val bean = MyBean2(1, "My bean")
        bean.toJson() shouldBe """{"name":"My bean","id":1}"""
    }

    "serializeUsing@JsonRawValue" {
        val bean = RawBean("My bean", """{"attr":false}""")
        bean.toJson() shouldBe """{"name":"My bean","json":{"attr":false}}"""
    }

    "serializeUsing@JsonRootName" {
        val user = UserWithRoot(1, "John")
        user.toJson() shouldBe  """{"user":{"id":1,"name":"John"}}"""
    }

    "serializeUsing@JsonSerialize" {
        val df = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        val toParse = "20-12-2014 02:30:00"
        val date = df.parse(toParse)
        EventWithSerializer("party", date).toJson() shouldBe """{"name":"party","eventDate":"20-12-2014 02:30:00"}"""
    }

    "serializeUsing@JsonAlias" {
        val bean = AliasBean("John", "Green")
        bean.toJson() shouldBe """{"firstName":"John","lastName":"Green"}"""
    }

    "serializeUsing@JsonIgnoreProperties" {
        val bean = BeanWithIgnoreProperties(1, "test")
        bean.toJson() shouldBe """{"name":"test"}"""
    }

    "serializeUsing@JsonIgnore" {
        val bean = BeanWithIgnore(1, "test")
        bean.toJson() shouldBe """{"name":"test"}"""
    }

    "serializeUser@JsonIgnoreType" {
        val user = User2(42, User2.Name("John", "Doe"))
        user.toJson() shouldBe """{"id":42}"""
    }

    "serializeMyBeanUsing@JsonInclude" {
        val bean = MyBean(1, null)
        bean.toJson() shouldBe """{"id":1}"""
    }

    "serializeMyBeanUsing@JsonAutoDetect" {
        val bean = PrivateBean(1, "john")
        bean.toJson() shouldBe """{"id":1,"name":"john"}"""
    }

    "serializePolymorphic" {
        val dog = Zoo.Dog("lacy", 2.5)
        val zoo = Zoo(dog)
        zoo.toJson() shouldBe """{"animal":{"type":"dog","name":"lacy","barkVolume":2.5}}"""
    }

    "serializeUsing@JsonProperty" {
        val bean = MyBean3(1, "My bean")
        bean.toJson() shouldBe """{"id":1,"name":"My bean"}"""

    }

    "serializeUsing@JsonFormat" {
        val df = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        df.timeZone = TimeZone.getTimeZone("UTC")

        val toParse = "20-12-2014 02:30:00"
        val date    = df.parse(toParse)
        val event = EventWithFormat("party", date)

        event.toJson() shouldBe """{"name":"party","eventDate":"20-12-2014 02:30:00"}"""
    }

})