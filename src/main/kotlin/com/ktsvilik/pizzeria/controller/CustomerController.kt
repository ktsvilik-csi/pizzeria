package com.ktsvilik.pizzeria.controller

import com.ktsvilik.pizzeria.dto.CustomerToppingsDto
import com.ktsvilik.pizzeria.service.CustomerService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService) {

    @Operation(summary = "Save a customer's list of toppings. Toppings' names are forced into lower case and capital first letter format.")
    @PostMapping
    fun saveCustomerToppings(@ParameterObject @Valid @RequestBody customerToppingsDto: CustomerToppingsDto) {
        customerService.saveCustomerToppings(customerToppingsDto.email, customerToppingsDto.toppings)
    }

}
