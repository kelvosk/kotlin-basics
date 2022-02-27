package com.kotlin.study.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerson")
    val idPerson: Long = 0,
    val name: String,
    val cpf: String,
    val bornDate: LocalDate,
    @OneToOne
    @PrimaryKeyJoinColumn
    val account: Account
)