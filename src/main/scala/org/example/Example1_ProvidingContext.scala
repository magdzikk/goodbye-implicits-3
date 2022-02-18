package org.example

import scala.concurrent.{ExecutionContext, Future}

object Example1_ProvidingContext {
  given ec: ExecutionContext = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    val myFuture: Future[Int] = Future {
      println("Finding the answer...")
      42
    }
    myFuture.foreach(answer => println(answer))
  }
}
