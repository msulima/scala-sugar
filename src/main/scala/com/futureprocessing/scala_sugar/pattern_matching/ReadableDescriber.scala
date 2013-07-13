package com.futureprocessing.scala_sugar.pattern_matching

import java.net.URL

object ReadableDescriber {

    def describe(readable: Readable) =
        readable match {
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

sealed trait Readable

case class Book(author: String, title: String) extends Readable

case class BlogEntry(author: String, title: String, url: URL) extends Readable
    