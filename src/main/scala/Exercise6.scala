object Exercise6 extends App {

  sealed trait Tree[+A]

  final case class Branch[A](Left: Tree[A], right: Tree[A])
    extends Tree[A]

  final case class Leaf[A](value: A) extends Tree[A]


}
