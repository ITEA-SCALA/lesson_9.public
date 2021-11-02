package com.itea.type_keyword

import scala.util.Try

trait FType {

  /*
   * есть много таких типов, которые принимают другие типы
   * если мы хотим чтобы наш параметр принимал какой-то другой параметр которого мы не знаем, тогда это будет выглядеть вот так:
   */
  Option[Int]
  List[Int]
  Try[String]

  class A[F[_]](param: F)

  val l: List[Int] = List(1,2,3)
  val value: A[List[_]] = new A(l)
//  val value2: A[String] = new A("String") // упадет, потому что тип String не типизированный ничем

}
