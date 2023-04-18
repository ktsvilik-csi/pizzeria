package com.ktsvilik.pizzeria.controller

import com.ktsvilik.pizzeria.dto.ToppingStatsDto
import com.ktsvilik.pizzeria.service.ToppingService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/toppings")
class ToppingController(val toppingService: ToppingService) {

    @Operation(summary = "Get the list of submitted toppings with statistics")
    @GetMapping("/stats")
    fun getAllToppingsWithStats(): List<ToppingStatsDto> {
        return toppingService.getAllToppingsWithStats()
    }

    @Operation(summary = "My personal toppings choice")
    @GetMapping("/personal")
    fun getMyFavoriteTopping(): Array<String> {
        return toppingService.getMyFavoriteTopping()
    }

}
