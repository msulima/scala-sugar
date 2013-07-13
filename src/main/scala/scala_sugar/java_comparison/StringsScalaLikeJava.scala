package scala_sugar.java_comparison

object StringsScalaLikeJava {

    def padStart(string: String, minLength: Int, padChar: Char): String = {
        if (string.length >= minLength) {
            return string
        }
        val sb: StringBuilder = new StringBuilder(minLength)
        for (i <- string.length until minLength) {
            sb.append(padChar)
        }
        sb.append(string)
        return sb.toString()
    }
}