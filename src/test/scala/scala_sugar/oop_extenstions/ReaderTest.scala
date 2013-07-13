package scala_sugar.oop_extenstions

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import scala_sugar.pattern_matching.{Publication, Book}

@RunWith(classOf[JUnitRunner])
class ReaderTest extends FunSuite with ShouldMatchers {

    val Krzyżacy     : Publication = Book("Henryk Sienkiewicz", "Krzyżacy")
    val EffectiveJava: Publication = Book("Joshua Bloch", "Effective Java")

    test("Every Polish Reader has read the Krzyżacy") {
        val person = new PolishReader {}

        person.publicationsRead should (contain(Krzyżacy) and have size 1)
    }

    class PolishJavaReader extends PolishReader with JavaProgrammer

    test("Every Polish Java programmer has read Krzyżacy and Effective Java") {
        val person = new PolishJavaReader

        person.publicationsRead should (contain(Krzyżacy) and contain(EffectiveJava) and have size 2)
    }
}
