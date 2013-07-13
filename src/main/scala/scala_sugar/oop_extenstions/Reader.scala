package scala_sugar.oop_extenstions

import scala_sugar.pattern_matching.{Book, Publication}


trait Reader {

    type PublicationsSeq = Seq[_ <: Publication]

    def publicationsRead: PublicationsSeq
}

trait PolishReader extends Reader {

    private val defaultBooks = List(Book("Henryk Sienkiewicz", "Krzyżacy"))

    def publicationsRead: PublicationsSeq =
        defaultBooks
}

trait JavaProgrammer extends Reader {

    abstract override def publicationsRead: PublicationsSeq =
        super.publicationsRead :+ Book("Joshua Bloch", "Effective Java")
}
