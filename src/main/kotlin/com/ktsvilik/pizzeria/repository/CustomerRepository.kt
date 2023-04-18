package com.ktsvilik.pizzeria.repository

import com.ktsvilik.pizzeria.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, UUID> {

    fun findCustomerByEmail(email: String): Customer?

}
