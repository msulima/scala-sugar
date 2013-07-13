package com.futureprocessing.scala_sugar.for_comprehension

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.futureprocessing.scala_sugar.pattern_matching.Book

@RunWith(classOf[JUnitRunner])
class ForComprehensionTest extends FunSuite with ShouldMatchers {

    test("should return good books") {
        val casualVacancy = Book("J.K. Rowling", "The Casual Vacancy")
        val hobbit = Book("J.R.R. Tolkien", "The Hobbit")
        val patriotGames = Book("Tom Clancy", "Patriot Games")

        ForComprehension.getBooks should be(List(casualVacancy, hobbit, patriotGames))
    }
}
