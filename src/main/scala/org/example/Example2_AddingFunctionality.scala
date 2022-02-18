package org.example

import org.example.domain.Book

object Example2_AddingFunctionality {
  extension (b: Book)
    def qualifiesForChallenge = b.pages > 20

  def main(args: Array[String]): Unit = {
    val paddington = Book("Paddington", 230)
    println("Qualifies: " + paddington.qualifiesForChallenge)
  }
}
