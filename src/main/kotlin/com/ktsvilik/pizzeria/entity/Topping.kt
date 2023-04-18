package com.ktsvilik.pizzeria.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.util.*

@Entity
class Topping(
        @Id
        @GeneratedValue
        var id: UUID? = null,

        @field:NotEmpty
        @field:Size(max = 255)
        @Column(name = "name", unique = true)
        var name: String? = null,

        @ManyToMany(mappedBy = "toppings")
        var customers: MutableSet<Customer> = mutableSetOf()
)
