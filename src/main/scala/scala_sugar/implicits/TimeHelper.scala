package scala_sugar.implicits

import java.util.{Locale, Calendar}
import java.text.SimpleDateFormat

object TimeHelper {

    implicit class TimeHelper(date: Calendar) {

        def clearTime() = {
            date.set(Calendar.HOUR, 0)
            date.set(Calendar.MINUTE, 0)
            date.set(Calendar.SECOND, 0)
            date
        }

        def addDays(days: Int) = {
            date.add(Calendar.DAY_OF_MONTH, days)
            date
        }
    }

    implicit val rfcFormat = "EEE, dd MMM yyyy HH:mm:ss Z"

    def formatTime(date: Calendar)(implicit format: String) = {
        new SimpleDateFormat(format, Locale.ENGLISH).format(date.getTime)
    }
}
