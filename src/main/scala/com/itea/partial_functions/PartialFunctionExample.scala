package com.itea.partial_functions

class PartialFunctionExample extends App {

  val positiveToNegativeOOPStyle: PartialFunction[Int, Int] =
    new PartialFunction[Int, Int] {
      override def apply(x: Int): Int = -1 * x
      override def isDefinedAt(x: Int): Boolean = x > 0
    }

  val positiveToNegative: PartialFunction[Int, Int] = {
    case x if 0 < x => -1 * x
  }

  // return false, IsDefinedAt implemented by compiler
  positiveToNegative.isDefinedAt(-10)
}
