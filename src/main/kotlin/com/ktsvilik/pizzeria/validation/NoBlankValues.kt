package com.ktsvilik.pizzeria.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Constraint(validatedBy = [NoBlankValuesValidator::class])
annotation class NoBlankValues(
        val message: String = "The collection should not have blank values",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)
