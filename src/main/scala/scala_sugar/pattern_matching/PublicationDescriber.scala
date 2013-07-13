package scala_sugar.pattern_matching

import java.net.URL

object PublicationDescriber {

    def describe(publication: Publication) =
        publication match {
            case book: Book if book.title.contains("Twilight") =>
                throw new UnsupportedOperationException
            case Book("J.R.R. Tolkien", _) =>
                "Tolkien is the best"
            case Book(author, title) =>
                s"$title by $author"
            case entry: BlogEntry =>
                s"${entry.title} by ${entry.author} published at ${entry.url}"
            case _ =>
                throw new IllegalArgumentException
        }
}

sealed trait Publication

case class Book(author: String, title: String) extends Publication

case class BlogEntry(author: String, title: String, url: URL) extends Publication
    