package com.example.mygame.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Records (val score : Int, val level : Int):Serializable