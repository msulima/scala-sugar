package scala_sugar.standard_library

import scala_sugar.pattern_matching.Book

object BooksOrganizer {

    def authorsWithMoreBooksThan(books: List[Book], limit: Int) = {
        for {
            (author, books) <- books.groupBy(_.author)
            size = books.size if size >= limit
        } yield author
    }

    def authorsWithMoreBooksThan2(books: List[Book], limit: Int) = {
        val byAuthor: Map[String, List[Book]] = books.groupBy(_.author)
        val byAuthorWithCount: Map[String, Int] = byAuthor.mapValues(_.size)
        byAuthorWithCount.filter(_._2 >= limit).keys
    }
}
