package com.kotlin.study.repository

import com.kotlin.study.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

}