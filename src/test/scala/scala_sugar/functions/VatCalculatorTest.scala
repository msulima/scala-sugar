package scala_sugar.functions

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VatCalculatorTest extends FunSuite with ShouldMatchers {

    test("calculates mail VAT") {
        val calculator = VatCalculator.vatCalculatorPerProductType("mail")
        calculator(100) should be(0)
    }

    test("calculates books VAT") {
        val calculator = VatCalculator.vatCalculatorPerProductType("book")
        calculator(100) should be(5)
    }

    test("calculates bumblebee VAT") {
        val calculator = VatCalculator.vatCalculatorPerProductType("bumblebee")
        calculator(100) should be(8)
    }

    test("calculates default VAT") {
        val calculator = VatCalculator.vatCalculatorPerProductType("shirt")
        calculator(100) should be(23)
    }
}