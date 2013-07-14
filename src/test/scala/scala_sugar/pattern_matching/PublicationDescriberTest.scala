package scala_sugar.pattern_matching

import PublicationDescriber.describe
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.net.URL

@RunWith(classOf[JUnitRunner])
class PublicationDescriberTest extends FunSuite with ShouldMatchers {

    test("Should dislike Twilight series") {
        evaluating(describe(Book("Stephanie Meyer", "Twilight"))) should produce[UnsupportedOperationException]
    }

    test("Should like J.R.R Tolkien's books") {
        describe(Book("J.R.R. Tolkien", "The Hobbit")) should be("Tolkien is the best")
    }

    test("Should describe books") {
        describe(Book("J.K. Rowling", "The Casual Vacancy")) should be("The Casual Vacancy by J.K. Rowling")
    }

    test("Should describe blog entries") {
        val readable = BlogEntry("Sebastián Ortega", "Language terseness: comparing Java and Scala",
            new URL("http://sortega.github.io/development/2013/06/22/terseness/"))
        val description = "Language terseness: comparing Java and Scala by Sebastián Ortega " +
            "published at http://sortega.github.io/development/2013/06/22/terseness/"
        describe(readable) should be(description)
    }
}