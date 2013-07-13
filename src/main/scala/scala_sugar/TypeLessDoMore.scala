package scala_sugar

import scala.beans.BeanProperty

object TypeLessDoMore {

    val name = "James" // name: String

    @BeanProperty
    val age = 30 // age: Int

    val weapons = List("WaltherPPK", "Laser Watch")
    // weapons: List[String]
    val drinks  = Map("martini" -> true, "harnaś" -> false) // drinks: Map[String, Boolean]

    def introduceYourself(surname: String) = // def introduceYourself(surname: String): String
        s"My name is $surname, $name $surname"

    def getFavouriteWeapons(howMany: Int) =
        weapons take howMany
}