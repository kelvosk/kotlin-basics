package com.kotlin.study.impl

import com.kotlin.study.domain.Person
import com.kotlin.study.repository.PersonRepository
import com.kotlin.study.service.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl (
    private val personRepository: PersonRepository
        ) : PersonService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun savePerson(person: Person) {
        logger.info("L=I C=PersonServiceImpl M=savePerson D=Register a new person in the bank")
        personRepository.save(person)
    }

}