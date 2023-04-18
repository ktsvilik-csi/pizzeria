package com.ktsvilik.pizzeria.dto

import com.ktsvilik.pizzeria.validation.NoBlankValues
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CustomerToppingsDto(
        @field:Email
        @field:NotEmpty
        val email: String,

        @field:NotEmpty
        @field:NoBlankValues
        val toppings: Set<String>
)
