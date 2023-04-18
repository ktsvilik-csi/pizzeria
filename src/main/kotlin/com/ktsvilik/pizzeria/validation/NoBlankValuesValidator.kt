package com.ktsvilik.pizzeria.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NoBlankValuesValidator : ConstraintValidator<NoBlankValues, Iterable<CharSequence>> {
    override fun isValid(value: Iterable<CharSequence>?, context: ConstraintValidatorContext?): Boolean {
        return value?.none(CharSequence::isBlank) ?: false
    }
}
