package scala_sugar.task

object CDLibrary {
    
    def calculateMeanMark(albums: List[Album]): Double = 
        albums.map(_.mark).sum / albums.size.toDouble

    def extractVeryGoodSongs(albums: List[Album]): List[Song] =
        extractSongs(albums.filter(_.mark == 5))

    def extractSongs(albums: List[Album]): List[Song] =
        for {
            album <- albums
            song <- album.songs
        } yield Song(album.artist, song)
}

case class Song(artist: String, title: String)

case class Album(artist: String, title: String, songs: Seq[String], mark: Int)