package com.kotlin.study.mapper

import com.kotlin.study.domain.Person
import com.kotlin.study.request.PersonRequest
import java.time.LocalDate
import java.time.format.DateTimeFormatter

val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy")

fun personRequestToPerson(personRequest: PersonRequest) = Person(
        name = personRequest.name,
        cpf = personRequest.cpf,
        birthOfDate = LocalDate.parse(personRequest.bornDate, dateTimeFormatter),
        account = personRequest.account
)
