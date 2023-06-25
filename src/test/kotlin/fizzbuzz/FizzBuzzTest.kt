package fizzbuzz

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FizzBuzzTest : FunSpec({
    test("si on passe 6, on retourne fizz") {
        //arrange
        var resultat = FizzBuzz.eval(6)

        //assert
        resultat shouldBe "Fizz"
    }

    test("si on passe 5, on retourne 5") {
        //arrange
        var resultat = FizzBuzz.eval(5)

        //assert
        resultat shouldBe "5"
    }

    test("si on passe 3, on retourne fizz") {
        //arrange
        var resultat = FizzBuzz.eval(3)

        //assert
        resultat shouldBe "Fizz"
    }

})