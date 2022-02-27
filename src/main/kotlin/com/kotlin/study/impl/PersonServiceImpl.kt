package com.kotlin.study.impl

import com.kotlin.study.domain.Person
import com.kotlin.study.repository.PersonRepository
import com.kotlin.study.service.PersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl (
    private val personRepository: PersonRepository
        ) : PersonService {

    override fun savePerson(person: Person) {
        personRepository.save(person)
    }

}