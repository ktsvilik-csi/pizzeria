package com.ktsvilik.pizzeria.service

import com.ktsvilik.pizzeria.dto.ToppingStatsDto
import com.ktsvilik.pizzeria.repository.ToppingRepository
import org.springframework.stereotype.Service

@Service
class ToppingService(val toppingRepository: ToppingRepository) {

    fun getAllToppingsWithStats(): List<ToppingStatsDto> {
        return toppingRepository.findAllToppingsWithCustomersCount()
    }

    fun getMyFavoriteTopping(): Array<String> {
        return arrayOf("Cheese", "Ham", "Olives", "Jalapeno", "Tomatoes")
    }

}
