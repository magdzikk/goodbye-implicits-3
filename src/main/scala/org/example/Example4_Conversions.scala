package org.example

import org.example.OtherPackage.{*, given}
import org.example.domain.Book

import scala.concurrent.ExecutionContext.Implicits.*
import scala.concurrent.{ExecutionContext, Future}

object Example4_Conversions {
  def printItem(item: Item): Unit = println(s"*** ${item.value} ***")

  def main(args: Array[String]): Unit = {
    val book = Book("Dune", 600)
    printItem(book)
    val future = Future(42)
    future.foreach(println)
  }
}

object OtherPackage {
  given Conversion[Book, Item] with
    def apply(book: Book): Item = Item(book.title)

  given Conversion[Book, String] = _.title

  case class Item(value: String) extends AnyVal
//  import scala.concurrent.ExecutionContext.Implicits
//  given ec: ExecutionContext = Implicits.global
}
