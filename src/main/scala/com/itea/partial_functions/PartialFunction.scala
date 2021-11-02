package com.itea.partial_functions

// Упрощенная версия трейта PartialFunction из 'A' в 'B'
trait PartialFunction[-A, +B] extends (A => B) { // это значит что мы наследуем функцию типа 'Function1' из 'A' в 'B'

  // narrowed return type of (возвращает суженный тип) Function1.andThen
  override def andThen[C](k: B => C): PartialFunction[A, C] = ???

  // abstract, by implicitly defined by compiler (абстрактный, неявно определенный компилятором)
  def isDefinedAt(x: A): Boolean // самый интересный здесь метод - присвоить область допустимых значений
  /*
   * метод 'isDefinedAt' - это метод который компилятор понимает, сам его создает, его подставляет и сам создает для него область видимости
   */

  // Chaining (Цепочка) - еще парочка функций чтобы слепливать несколько функций в одну, например: orElse и andThen
  def orElse[A1 <: A, B1 >: B](that: PartialFunction[A1, B1]): PartialFunction[A1, B1] = ???
  def andThen[C](k: PartialFunction[B, C]): PartialFunction[A, C] = ???

  /*
   * Making total function from partial (Создание общей функции из частичной) как же из частичной функции можно сделать полную функцию
   * нужно сделать lift, то есть поднять нашу обычную функцию в частичную функцию
   * тогда если функция не обозначена isDefinedAt у нас будет Option[B]
   */
  def lift: A => Option[B] = ???
}
