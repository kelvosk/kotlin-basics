package com.kotlin.study.api

import com.kotlin.study.request.PersonRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RequestMapping(value = ["/person"], produces = [MediaType.APPLICATION_JSON_VALUE])
interface PersonControllerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePerson(@RequestBody personRequest: PersonRequest);
}

