object Exercise9 extends App {

  import scala.language.higherKinds

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]

    def map[A, B](value: F[A])(func: A => B): F[B] =
      flatMap(value)(a => pure(func(a)))
//      pure(func(flatMap(value)))

    def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]
  }

}
