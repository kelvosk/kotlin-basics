package com.kotlin.study.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPerson: Long,
    val name: String,
    val cpf: String,
    val bornDate: ZonedDateTime,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "idPerson", referencedColumnName = "idPersonFK")
    val accountId: Account
)