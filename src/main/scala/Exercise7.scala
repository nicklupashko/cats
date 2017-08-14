object Exercise7 extends App {

  trait Printable[A] {
    def format(value: A): String

    def contramap[B](func: B => A): Printable[B] = {
      val self = this
      (value: B) => self.format(func(value))
    }
  }

  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  implicit val stringPrintable =
    new Printable[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }

  implicit val booleanPrintable =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if (value) "yes" else "no"
    }

  println(format("hello"))
  println(format(true))

  final case class Box[A](value: A)

  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] =
    p.contramap[Box[A]](_.value)

  println(format(Box("hello world")))
  println(format(Box(true)))

}
