package com.stanislavkorneev.valute1

data class Valute(val ID: String,
                  val NumCode: String,
                  val CharCode: String,
                  val Nominal: Long,
                  val Name: String,
                  val Value: Double,
                  val Previous: Double) {

    override fun toString(): String {
        return "$NumCode $CharCode $Nominal $Name $Value"
    }
}

