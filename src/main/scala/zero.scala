object zero extends App {

  def flatMap[A, B](fa: () => A)(f: A => () => B): () => B =
    () => f(fa())()

  def flatMap[T1, R1, R2](fa: T1 => R1)(f: R1 => T1 => R2): T1 => R2 =
    t => f(fa(t))(t)

}
