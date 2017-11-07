import org.scalacheck.Prop.{BooleanOperators, forAll}
import org.scalacheck.{Gen, Properties}


object FizzBuzzSpecifications extends Properties("FizzBuzz") {
  
  val divOnlyBy3 = Gen.choose(1, 1000000) map(_ * 3) filter(_ % 5 != 0)
  val divOnlyBy5 = Gen.choose(1, 1000000) map(_ * 5) filter(_ % 3 != 0)
  val divBy3And5 = Gen.choose(1, 1000000) map(_ * 15)

  property("only div by 3") = forAll (divOnlyBy3){ n: Int =>
    FizzBuzz.translate(n) == "Fizz"
  }

  property("only div by 5") = forAll(divOnlyBy5) { n: Int =>
    FizzBuzz.translate(n) == "Buzz"
  }

  property("div by 3 & 5") = forAll(divBy3And5) { n: Int =>
    FizzBuzz.translate(n) == "FizzBuzz"
  }

  property("regular ones") = forAll { n: Int =>
    (n % 3 != 0 && n % 5 != 0) ==> (FizzBuzz.translate(n) == n.toString)
  }
}
