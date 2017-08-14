object Exercise5 extends App {

  import cats.Monoid
  import cats.syntax.semigroup._
  import cats.instances.int._
  import cats.instances.option._

  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

  println(add(List(1, 2, 3)))
  println(add(List(Some(1), None, Some(2), None)))

}
