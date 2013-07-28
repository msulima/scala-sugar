package scala_sugar.standard_library

import scala_sugar.pattern_matching.Book

object BooksOrganizer {

    def authorsWithMoreBooksThan(books: List[Book], limit: Int) =
        for {
            (author, books) <- books.groupBy(_.author) if books.size >= limit
        } yield author

    def authorsWithMoreBooksThan_versionB(books: List[Book], limit: Int) = {
        val byAuthor: Map[String, List[Book]] = books.groupBy(book => book.author)
        val byAuthorWithCount: Map[String, Int] = byAuthor.mapValues(book => book.size)
        byAuthorWithCount.filter(tuple => tuple._2 >= limit).keys
    }

    def findAuthorOfBook(books: List[Book], searchedTitle: String) =
        books.find(book => book.title == searchedTitle).map(book => book.author)

    def separateBooksOfAuthor(books: List[Book], searchedAuthor: String): (List[Book], List[Book]) =
        books.partition(_.author == searchedAuthor)
}
