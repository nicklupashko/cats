object Exercise2 extends App {

  import cats.Show
  import cats.instances.int._
  import cats.instances.string._
  import cats.syntax.show._

  // Cat
  final case class Cat(name: String, age: Int, color: String)

  // Show
  implicit val catShow: Show[Cat] =
    Show.show { cat =>
      val name  = cat.name.show
      val age   = cat.age.show
      val color = cat.color.show
      s"$name is a $age year-old $color cat."
    }

  println(Cat("Boris", 40, "black").show)

}
