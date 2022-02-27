package com.kotlin.study.service

import com.kotlin.study.domain.Person

interface PersonService {
    fun savePerson(person: Person)
}