package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

@Suppress("unused")
class PieceTest : ShouldSpec({
    context("un piece est déclarée")
    {
        val sut = FaussePiece(1)

        should("égalite et inégalité") {
            sut shouldBe FaussePiece(1)
            sut shouldNotBe FaussePiece(2)
            sut shouldNotBe PasDePiece()
        }

        should("rien c'est rien") {
            PasDePiece() shouldBe  PasDePiece()
        }

    }
})
