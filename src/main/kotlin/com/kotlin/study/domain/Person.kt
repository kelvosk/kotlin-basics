package com.kotlin.study.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerson")
    val idPerson: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "cpf")
    val cpf: String,

    @Column(name = "birth_of_date")
    val birthOfDate: LocalDate,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_account")
    val account: Account
)