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
        val readable = BlogEntry("Marcin Drobik", "Auto Load Dispatcher Timer",
            new URL("http://www.future-processing.pl/blog/639/"))
        val description = "Auto Load Dispatcher Timer by Marcin Drobik published at http://www.future-processing.pl/blog/639/"
        describe(readable) should be(description)
    }
}