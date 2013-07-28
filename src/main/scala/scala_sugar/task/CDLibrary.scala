package scala_sugar.task

object CDLibrary {

    def calculateMeanMark(albums: List[Album]): Double =
        ???

    def extractVeryGoodSongs(albums: List[Album]): List[Song] =
        ???

    def extractSongs(albums: List[Album]): List[Song] =
        ???
}

case class Song(artist: String, title: String)

case class Album(artist: String, title: String, songs: Seq[String], mark: Int)