package scala_sugar.standard_library

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala_sugar.pattern_matching.Book

@RunWith(classOf[JUnitRunner])
class BooksOrganizerTest extends FunSuite with ShouldMatchers {

    val MartinFowler     = "Martin Fowler"
    val RefactoringTitle = "Refactoring"

    val PragmaticProgrammer = Book("Andrew Hunt", "The Pragmatic Programmer")
    val PoEAA               = Book(MartinFowler, "Patterns of Enterprise Application Architecture")
    val EffectiveJava       = Book("Joshua Bloch", "Effective Java")
    val Refactoring         = Book(MartinFowler, RefactoringTitle)

    val books = List(PragmaticProgrammer, Refactoring, PoEAA, EffectiveJava)

    test("should take only authors who written 2 or more books") {
        BooksOrganizer.authorsWithMoreBooksThan(books, 2) should (contain(MartinFowler) and have size 1)
    }

    test("find author of book") {
        BooksOrganizer.findAuthorOfBook(books, RefactoringTitle) should be(Some(MartinFowler))
    }

    test("separate Fowler's books from others") {
        val (ofFowler, others) = BooksOrganizer.separateBooksOfAuthor(books, MartinFowler)

        ofFowler should be(List(Refactoring, PoEAA))
        others should be(List(PragmaticProgrammer, EffectiveJava))
    }
}
