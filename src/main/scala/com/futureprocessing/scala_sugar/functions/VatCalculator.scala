package com.futureprocessing.scala_sugar.functions

object VatCalculator {

    def mailVat(price: Int) = 0

    val defaultVat: (Int) => Int = createCalculator(23)

    val booksVat: (Int) => Int = createCalculator(5)

    private def createCalculator(taxValue: Int)(price: Int) =
        price * taxValue / 100

    val vatCalculatorPerProductType: Map[String, (Int) => Int] = Map(
        "mail" -> mailVat _,
        "book" -> booksVat,
        "bumblebee" -> {
            (price: Int) => price * 8 / 100
        }
    ).withDefaultValue(defaultVat)
}