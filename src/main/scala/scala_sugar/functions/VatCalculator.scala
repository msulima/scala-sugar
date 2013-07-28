package scala_sugar.functions

object VatCalculator {

    private val defaultVat: (Int) => Int =
        createCalculator(23)

    private val booksVat: (Int) => Int =
        createCalculator(5)

    private def createCalculator(taxValue: Int)(price: Int) =
        price * taxValue / 100

    private def mailVat(price: Int) =
        0

    val vatCalculatorPerProductType: Map[String, (Int) => Int] = Map(
        "bumblebee" -> {
            (price: Int) => price * 8 / 100
        },
        "book" -> booksVat,
        "mail" -> mailVat _
    ).withDefaultValue(defaultVat)
}