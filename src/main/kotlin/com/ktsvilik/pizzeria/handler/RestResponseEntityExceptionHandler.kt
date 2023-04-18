package com.ktsvilik.pizzeria.handler

import mu.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    private val logger = KotlinLogging.logger {}

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatusCode,
                                              request: WebRequest): ResponseEntity<Any>? {
        val errors = MethodArgumentNotValidException.errorsToStringList(ex.allErrors)
        logger.warn("Invalid request $request. Errors $errors")
        return handleExceptionInternal(ex,
                ProblemDetail.forStatusAndDetail(status, errors.toString()),
                headers, status, request)
    }
}
