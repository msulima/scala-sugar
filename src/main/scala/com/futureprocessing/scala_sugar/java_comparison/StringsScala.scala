package com.futureprocessing.scala_sugar.java_comparison

object StringsScala {

    def padStart(string: String, minLength: Int, padChar: Char) =
        padChar.toString * (minLength - string.length) + string
}