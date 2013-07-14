package scala_sugar

import scala.beans.BeanProperty

object TypeLessDoMore {

    val name = "James" // name: String

    @BeanProperty
    val age = 30 // age: Int

    // weapons: List[String]
    val weapons = List("WaltherPPK", "Laser Watch")

    // drinks: Map[String, Boolean]
    val drinks = Map(
        "martini" -> true,
        "harnaś" -> false
    )

    def introduceYourself(surname: String) = // def introduceYourself(surname: String): String
        s"My name is $surname, $name $surname"

    def getFavouriteWeapons(howMany: Int) =
        weapons take howMany
}