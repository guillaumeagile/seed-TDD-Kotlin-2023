package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import quatro.doubluresDeTest.FaussePiece

@Suppress("unused")
class PlateauTest : ShouldSpec({
    context("un plateau a dimension variable est formé")
    {
        val sut = PlateauDimensionsVariables(4000, 3000)

        should("ne pas retrouver une pièce qui n'a pas été placé ") {

            val actual = sut.estEn(0,0)

            actual shouldBe PasDePiece()

            //sut.lisgnesHorizontale(1).piecesDuMemeJoueur().ayantAuMoinsUneCaracteristiqueEncommmun().estDeMemeTaillqueLaDiagonale()
        }

        should("placer et retrouver une pièce ") {
           val result = sut.placer(FaussePiece(1)).En(0,0)

            val actual = result.estEn(0,0)

            actual shouldBe FaussePiece(1)
        }

        should("placer et retrouver une 2e pièce ") {
            val result = sut
                .placer(FaussePiece(1)).En(0,0)
                .placer(FaussePiece(2)).En(4000,3000)

            result.estEn(4000,3000) shouldBe FaussePiece(2)
            result.estEn(1,1) shouldBe PasDePiece()
            result.estEn(0,0) shouldBe FaussePiece(1)
        }
    }

})
