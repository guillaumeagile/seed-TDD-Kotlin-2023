package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import quatro.doubluresDeTest.FaussePiece

@Suppress("unused")
class PlateauTest : ShouldSpec({
    context("un plateau a dimension variable est formé")
    {
        val sut = PlateauDimensionsVariables(4000, 3000, dernierCoupEstValide = false)

        should("ne pas retrouver une pièce qui n'a pas été placé ") {

            val actual = sut.estEn(0, 0)

            actual shouldBe PasDePiece()

            // sut.lisgnesHorizontale(i).ayantAuMoinsUneCaracteristiqueEncommmun().surLaLigneEntiere()
        }

        should("placer et retrouver une pièce ") {
            val result = sut.placer(FaussePiece(1)).En(0, 0)

            val actual = result.estEn(0, 0)

            actual shouldBe FaussePiece(1)
        }

        should("placer et retrouver une 2e pièce ") {
            val result = sut
                .placer(FaussePiece(1)).En(0, 0)
                .placer(FaussePiece(2)).En(4000, 3000)

            result.estEn(4000, 3000) shouldBe FaussePiece(2)
            result.estEn(1, 1) shouldBe PasDePiece()
            result.estEn(0, 0) shouldBe FaussePiece(1)
        }

        should("placer une pièce sur une case vide est un coup valide") {
            val result = sut.placer(FaussePiece(1)).En(0, 0)

            result.dernierCoupEstValide() shouldBe true
        }

        should("impossible de placer 2 pièces à la meme position ") {
            val result = sut
                .placer(FaussePiece(1)).En(0, 0)
                .placer(FaussePiece(2)).En(0, 0)

            result.dernierCoupEstValide() shouldBe false
        }

        should("impossible de placer 2 pièces à la meme position mais on peut la replacer ensuite ") {
            val result = sut
                .placer(FaussePiece(1)).En(0, 0)
                .placer(FaussePiece(2)).En(0, 0)
                .placer(FaussePiece(2)).En(1, 0)

            result.dernierCoupEstValide() shouldBe true
        }

        should("impossible de placer 1 pièce qui a déjà été placée") {
            val result = sut
                .placer(FaussePiece(1)).En(0, 0)
                .placer(FaussePiece(2)).En(0, 0)
                .placer(FaussePiece(1)).En(1, 0)

            result.dernierCoupEstValide() shouldBe false
        }
    }

})
