package com.arcanesecurity.nasalightning.model

import java.util.*

/**
 * Models for results
 */
data class LightningStrike(
    val id: String,
    val date: Calendar,
    val power: LightningPower,
    val location: LightningLocation,
)

data class LightningPower(
    val force: Double,
)

data class LightningLocation(
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val country: String,
)