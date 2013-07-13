package com.futureprocessing.scala_sugar.java_comparison

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.google.common.base.Strings
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringsTest extends FunSuite with ShouldMatchers {

    test("007") {
        Strings.padStart("7", 3, '0') should be("007")
        StringsScalaLikeJava.padStart("7", 3, '0') should be("007")
        StringsScala.padStart("7", 3, '0') should be("007")
    }

    test("2010") {
        Strings.padStart("2010", 3, '0') should be("2010")
        StringsScalaLikeJava.padStart("2010", 3, '0') should be("2010")
        StringsScala.padStart("2010", 3, '0') should be("2010")
    }
}