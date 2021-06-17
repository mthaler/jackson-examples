package com.mthaler.jacksonexamples.annotation

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class BeanWithCreator(var id: Int, var name: String) {

    companion object {

        @JvmStatic
        @JsonCreator
        fun create( @JsonProperty("id") id: Int,
                    @JsonProperty("theName") name: String): BeanWithCreator = BeanWithCreator(id, name)
    }
}