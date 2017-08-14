object Exercise6 extends App {

  sealed trait Tree[+A]

  final case class Branch[A](Left: Tree[A], right: Tree[A])
    extends Tree[A]

  final case class Leaf[A](value: A) extends Tree[A]

  import cats.Functor
  import cats.syntax.functor._

  implicit val treeFunctor = new Functor[Tree] {
    def map[A, B](tree: Tree[A])(func: (A) => B): Tree[B] =
      tree match {
        case Branch(left, right) =>
          Branch(map(left)(func), map(right)(func))
        case Leaf(value) =>
          Leaf(func(value))
      }
  }

  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
    Branch(left, right)

  def leaf[A](value: A): Tree[A] =
    Leaf(value)

  println(branch(leaf(10), leaf(20)).map(_ * 2))

}
