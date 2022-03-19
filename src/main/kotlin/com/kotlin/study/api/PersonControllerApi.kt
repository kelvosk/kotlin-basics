package com.kotlin.study.api

import com.kotlin.study.request.PersonRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping(value = ["/person"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Person")
interface PersonControllerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Save a new customer in a bank")
    fun savePerson(@RequestBody personRequest: PersonRequest);
}

