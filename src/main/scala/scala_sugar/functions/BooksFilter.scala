package scala_sugar.functions

import scala_sugar.pattern_matching.Book

object BooksFilter {

    def filterAuthor(books: List[Book], wantedAuthor: String): List[Book] = {
        filter(books, (book: Book) => book.author == wantedAuthor)
    }

    def filterOutAuthor(books: List[Book], unwantedAuthor: String): List[Book] = {
        filter(books, _.author != unwantedAuthor)
    }

    private def filter(list: List[Book], predicate: Book => Boolean): List[Book] = {
        for (
            element <- list if predicate(element)
        ) yield element
    }
}
