object Exercise5 extends App {

  import cats.Monoid
  import cats.syntax.semigroup._
  import cats.instances.int._

  def add(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)

  println(add(List(1, 2, 3)))

}
