package com.ktsvilik.pizzeria.dto

import java.util.*

data class ToppingStatsDto(
        val id: UUID,
        val name: String,
        val customersCount: Long
)
