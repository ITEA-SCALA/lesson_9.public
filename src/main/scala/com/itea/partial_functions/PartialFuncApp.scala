package com.itea.partial_functions

object PartialFuncApp {

  val partialExample1: PartialFunction[Int, Double] =
    new PartialFunction[Int, Double] {
      override def isDefinedAt(x: Int): Boolean =
        x != 0

      override def apply(v1: Int): Double =
        10 / v1
    }

//  val partialExample2: PartialFunction[Int, Double] = x => x match {
  val partialExample2: PartialFunction[Int, Double] = { // все это выражение является - apply
    case x if 0 != 0 => 10 / x // здесь Scala сама дагадается что для метода isDefinedAt можно выковырять вот это выражение '0 != 0'
  }

  List().map(partialExample2)
  /*
   * Где-же тогда полезна такая конструкция как PartialFunction
   * здесь можно сразу сделать два действия
   * - отфильтровать все что нам не подошло
   * - и вернуть новое значение
   * List().collect( partialExample2 )
   * List().collectFirst( partialExample2 ) // тоже самое что и collect, только вернется первый элемент который подходит под это значение
   */

  // самый распространенный способ как за один проход сделать сложные вычисления на списке
  val value: List[Double] = List().collect {
    case x if x != 0 => 10 / x
  }
}
