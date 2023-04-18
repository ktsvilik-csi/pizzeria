package com.ktsvilik.pizzeria.repository

import com.ktsvilik.pizzeria.dto.ToppingStatsDto
import com.ktsvilik.pizzeria.entity.Topping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ToppingRepository : JpaRepository<Topping, UUID> {

    @Query("""
            select new com.ktsvilik.pizzeria.dto.ToppingStatsDto(t.id, t.name, count(c))
            from Topping as t
            join t.customers as c
            group by t.id, t.name
            order by upper(t.name)""")
    fun findAllToppingsWithCustomersCount(): List<ToppingStatsDto>

    fun findByName(name: String): Topping?

}
