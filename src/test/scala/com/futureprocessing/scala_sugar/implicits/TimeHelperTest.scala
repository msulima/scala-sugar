package com.futureprocessing.scala_sugar.implicits

import org.scalatest.{OneInstancePerTest, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.util.{Calendar, GregorianCalendar}

@RunWith(classOf[JUnitRunner])
class TimeHelperTest extends FunSuite with ShouldMatchers with OneInstancePerTest {

    import TimeHelper._

    test("clears time") {
        val nineEleven = new GregorianCalendar(2001, Calendar.SEPTEMBER, 11, 0, 0)
        val firstTower = new GregorianCalendar(2001, Calendar.SEPTEMBER, 11, 8, 46)

        firstTower.clearTime() should be(nineEleven)
    }

    val firstOfDecember = new GregorianCalendar(2010, Calendar.DECEMBER, 1)
    val firstOfJanuary  = new GregorianCalendar(2011, Calendar.JANUARY, 1)

    test("adds days") {
        firstOfDecember.addDays(31) should be(firstOfJanuary)
    }

    test("formats Calendar with explicit format") {
        formatTime(firstOfDecember)("yyyy-MM-dd HH:mm") should be("2010-12-01 00:00")
    }

    test("formats Calendar with implicit format") {
        formatTime(firstOfDecember) should be("Wed, 01 Dec 2010 00:00:00 +0100")
    }
}
