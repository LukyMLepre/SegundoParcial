package com.example.segundoparcial

data class Cat(
    val id: String,
    val url: String,
    val breeds: List<Breed>
)

data class Breed(
    val name: String,
    val weight: Weight,
    val description: String
)

data class Weight(
    val imperial: String,
    val metric: String
)
