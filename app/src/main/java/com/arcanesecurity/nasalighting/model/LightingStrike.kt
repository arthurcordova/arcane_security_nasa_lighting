package com.arcanesecurity.nasalighting.model

import java.util.*

/**
 * Models for results
 */
data class LightingStrike(
    val id: String,
    val date: Calendar,
    val power: LightingPower,
    val location: LightingLocation,
)

data class LightingPower(
    val force: Double,
)

data class LightingLocation(
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val country: String,
)