package org.example

import org.example.domain.Book

object Example6_UnusedNames {

  given Ordering[Book] = new Ordering[Book] {
    override def compare(x: Book, y: Book): Int = x.title.compareTo(y.title)
  }
  val byLength: Ordering[Book] = (x: Book, y: Book) => -1 * x.pages.compareTo(y.pages)

  def main(args: Array[String]): Unit = {
    val myBooks = List(Book("Dune", 600), Book("Some", 100), Book("Other", 250))

    printSorted(myBooks)
    printSortedByLength(myBooks)
  }


  def printSorted(myBooks: List[Book]): Unit = {
    println("My books:")
    println(myBooks.sorted)
  }

  def printSortedByLength(myBooks: List[Book]): Unit = {
    println("My books:")
    println(myBooks.sorted(byLength))
  }
}
