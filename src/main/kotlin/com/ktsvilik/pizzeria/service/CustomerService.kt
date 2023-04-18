package com.ktsvilik.pizzeria.service

import com.ktsvilik.pizzeria.entity.Customer
import com.ktsvilik.pizzeria.entity.Topping
import com.ktsvilik.pizzeria.repository.CustomerRepository
import com.ktsvilik.pizzeria.repository.ToppingRepository
import jakarta.transaction.Transactional
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository,
                      private val toppingRepository: ToppingRepository) {

    private val logger = KotlinLogging.logger {}

    @Transactional
    fun saveCustomerToppings(email: String, toppings: Set<String>) {
        val customer = customerRepository.findCustomerByEmail(email) ?: Customer(email = email)
        logger.debug { "Working with Customer id ${customer.id} email $email" }

        val newToppingsNames = formatToppings(toppings)
        customer.toppings.removeIf { !newToppingsNames.contains(it.name) }
        addMissingToppings(customer.toppings, newToppingsNames);

        logger.debug { "Saving $email with ${customer.toppings.size} toppings" }
        customerRepository.save(customer);
    }

    private fun formatToppings(toppings: Set<String>): Set<String> {
        return toppings.mapTo(mutableSetOf()) { it.trim().lowercase() }
    }

    private fun addMissingToppings(savedToppings: MutableSet<Topping>, newToppingsNames: Set<String>) {
        val savedToppingsNames = savedToppings.mapTo(mutableSetOf()) { it.name }

        newToppingsNames
                .filterNot { savedToppingsNames.contains(it) }
                .map { toppingRepository.findByName(it) ?: toppingRepository.save(Topping(name = it)) }
                .forEach(savedToppings::add)
    }

}
