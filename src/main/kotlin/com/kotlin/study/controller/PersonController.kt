package com.kotlin.study.controller

import com.kotlin.study.impl.PersonServiceImpl
import com.kotlin.study.api.PersonControllerApi
import com.kotlin.study.mapper.personRequestToPerson
import com.kotlin.study.request.PersonRequest
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
    private val personServiceImpl: PersonServiceImpl
) : PersonControllerApi {

    override fun savePerson(personRequest: PersonRequest) {
        personServiceImpl.savePerson(personRequestToPerson(personRequest))
    }
}
