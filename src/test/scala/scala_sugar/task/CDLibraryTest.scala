package scala_sugar.task

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit.Ignore

@RunWith(classOf[JUnitRunner])
@Ignore
class CDLibraryTest extends FunSuite with ShouldMatchers {

    val TheBeatles = "The Beatles"
    val PinkFloyd  = "Pink Floyd"
    val U2         = "U2"

    val SpeakToMe   = "Speak to me"
    val Breathe     = "Breathe"
    val LSD         = "Lucy in the Sky with Diamonds"
    val Magnificent = "Magnificent"

    val albums = List(
        Album(PinkFloyd, "The Dark Side of the Moon", List(SpeakToMe, Breathe), 5),
        Album(TheBeatles, "Sgt. Pepper's Lonely Hearts Club Band", List(LSD), 5),
        Album(U2, "No Line on the Horizon", List(Magnificent), 3)
    )

    test("should calculate mean value of Albums marks") {
        CDLibrary.calculateMeanMark(albums) should be(4.33 plusOrMinus 0.01)
    }

    test("should extract Songs from Albums") {
        CDLibrary.extractSongs(albums) should be(List(Song(PinkFloyd, SpeakToMe),
            Song(PinkFloyd, Breathe), Song(TheBeatles, LSD), Song(U2, Magnificent)))
    }

    test("should extract Songs only from very good Albums") {
        CDLibrary.extractVeryGoodSongs(albums) should be(List(Song(PinkFloyd, SpeakToMe),
            Song(PinkFloyd, Breathe), Song(TheBeatles, LSD)))
    }
}
