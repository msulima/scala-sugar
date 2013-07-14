package scala_sugar.standard_library

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala_sugar.pattern_matching.Book

@RunWith(classOf[JUnitRunner])
class BooksOrganizerTest extends FunSuite with ShouldMatchers {

    val MartinFowler = "Martin Fowler"

    val publications = List(
        Book("Andrew Hunt", "The Pragmatic Programmer"),
        Book(MartinFowler, "Refactoring"),
        Book(MartinFowler, "Patterns of Enterprise Application Architecture"),
        Book("Joshua Bloch", "Effective Java")
    )

    test("should take only authors who written 2 or more books") {
        BooksOrganizer.authorsWithMoreBooksThan(publications, 2) should (contain(MartinFowler) and have size 1)
    }
}
