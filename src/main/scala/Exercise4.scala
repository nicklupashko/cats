object Exercise4 extends App {

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  object Monoid {
    def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
  }

  implicit def unionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      def combine(x: Set[A], y: Set[A]): Set[A] = x union y

      def empty: Set[A] = Set.empty[A]
    }

  implicit def intersectSemigroup[A]: Semigroup[Set[A]] =
    (x: Set[A], y: Set[A]) => x intersect y

  val intSetMonoid = Monoid[Set[Int]]
  println(intSetMonoid.combine(Set(1, 2), Set(2, 3)))

  val intSetSemigroup: Semigroup[Set[Int]] = intersectSemigroup
  println(intSetSemigroup.combine(Set(1, 2), Set(2, 3)))

}
