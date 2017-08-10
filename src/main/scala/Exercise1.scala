object Exercise1 extends App {

  // Type class
  trait Printable[A] {
    def format(value: A): String
  }

  // Instances
  object PrintableInstances {
    implicit val stringPrintable = new Printable[String] {
      def format(input: String): String = input
    }

    implicit val intPrintable = new Printable[Int] {
      def format(input: Int): String = input.toString
    }

    implicit val catPrintable = new Printable[Cat] {
      def format(value: Cat): String = {
        val name  = Printable.format(cat.name)
        val age   = Printable.format(cat.age)
        val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat."
      }
    }
  }

  // Interface methods in Interface object
  object Printable {
    def format[A](input: A)(implicit p: Printable[A]): String =
      p.format(input)

    def print[A](input: A)(implicit p: Printable[A]): Unit =
      println(format(input))
  }

  // Interface methods in Interface syntax
  object PrintableSyntax {

    implicit class PrintOps[A](value: A) {
      def format(implicit p: Printable[A]): String =
        p.format(value)

      def print(implicit p: Printable[A]): Unit =
        println(p.format(value))
    }

  }

  // Cat
  final case class Cat(name: String, age: Int, color: String)

  val cat = Cat("Boris", 40, "black")

  import PrintableInstances._
  import PrintableSyntax._

  Printable.print(cat)
  cat.print

}
