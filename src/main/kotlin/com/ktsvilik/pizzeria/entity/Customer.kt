package com.ktsvilik.pizzeria.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.util.*

@Entity
class Customer(
        @Id
        @GeneratedValue
        var id: UUID? = null,

        @field:NotEmpty
        @field:Email
        @field:Size(max = 255)
        @Column(name = "email", unique = true)
        var email: String? = null,

        @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
        @JoinTable(name = "customer_topping",
                joinColumns = [JoinColumn(name = "customer_id")],
                inverseJoinColumns = [JoinColumn(name = "topping_id")])
        var toppings: MutableSet<Topping> = mutableSetOf()
)
