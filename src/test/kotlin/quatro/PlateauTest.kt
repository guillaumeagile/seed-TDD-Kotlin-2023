package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class PlateauTest : ShouldSpec({
    context("un plateau a dimension variable est formé")
    {
        val sut = PlateauDimensionsVariables()

        should("ne pas retrouver une pièce qui n'a pas été placé ") {

            val actual = sut.EstEn(0,0)

            actual shouldBe PasDePiece()
        }

        should("placer et retrouver une pièce ") {
           val result = sut.Place(FaussePiece(1)).En(0,0)

            val actual = result.EstEn(0,0)

            actual shouldBe FaussePiece(1)
        }

        should("placer et retrouver une 2e pièce ") {
            val result = sut
                .Place(FaussePiece(1)).En(0,0)
                .Place(FaussePiece(2)).En(4000,3000)

            result.EstEn(0,0) shouldBe FaussePiece(1)
            result.EstEn(4000,3000) shouldBe FaussePiece(2)
            result.EstEn(1,1) shouldBe PasDePiece()
        }
    }

})
