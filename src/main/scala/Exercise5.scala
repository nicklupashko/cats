object Exercise5 extends App {

  import cats.Monoid
  import cats.syntax.semigroup._
  import cats.instances.int._
  import cats.instances.option._

  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

  println(add(List(1, 2, 3)))
  println(add(List(Some(1), None, Some(2), None)))

  case class Order(totalCost: Double, quantity: Double)

  implicit val monoid: Monoid[Order] = new Monoid[Order] {
    def empty: Order = Order(0, 0)

    def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }

  println(add(List(Order(1, 1), Order(2, 2))))

}
