

object FizzBuzz {
  def translate(input: Int): String = (input % 3, input % 5) match {
    case (0, 0) =>  "FizzBuzz"
    case (0, _) =>  "Fizz"
    case (_, 0) =>  "Buzz"
    case (_, _) =>  input.toString
  }
} 
