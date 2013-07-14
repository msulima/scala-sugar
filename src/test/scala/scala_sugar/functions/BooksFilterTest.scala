package scala_sugar.functions

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala_sugar.pattern_matching.Book

@RunWith(classOf[JUnitRunner])
class BooksFilterTest extends FunSuite with ShouldMatchers {

    val StephanieMeyer = "Stephanie Meyer"
    val Tolkien        = "J.R.R. Tolkien"

    val Twilight      = Book(StephanieMeyer, "Twilight")
    val Hobbit        = Book(Tolkien, "The Hobbit")
    val CasualVacancy = Book("J.K. Rowling", "The Casual Vacancy")

    val books = List(CasualVacancy, Twilight, Hobbit)

    test("leave only books of given author") {
        BooksFilter.filterAuthor(books, Tolkien) should be(List(Hobbit))
    }

    test("filters out books of given author") {
        BooksFilter.filterOutAuthor(books, StephanieMeyer) should be(List(CasualVacancy, Hobbit))
    }
}
