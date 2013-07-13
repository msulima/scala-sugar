package com.futureprocessing.scala_sugar.for_comprehension

import scala.collection.SortedMap
import com.futureprocessing.scala_sugar.pattern_matching.Book

object ForComprehension {

    val englishBooks = SortedMap(
        "J.K. Rowling" -> "The Casual Vacancy",
        "J.R.R. Tolkien" -> "The Hobbit"
    )

    val americanBooks = SortedMap(
        "Stephanie Meyer" -> "Twilight",
        "Tom Clancy" -> "Patriot Games"
    )

    val shelves = List(englishBooks, americanBooks)

    def getBooks =
        for {
            shelf <- shelves
            (authorName, title) <- shelf if title != "Twilight"
        } yield Book(authorName, title)
}