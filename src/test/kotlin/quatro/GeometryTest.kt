package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import quatro.doubluresDeTest.FaussePiece

@Suppress("unused")
class GeometryTest : ShouldSpec({
    context("un plateau est formé")
    {
        val sut = PlateauDimensionsVariables(3, 3, dernierCoupEstValide = false)
            .placer(FaussePiece(1)).En(0,0)
            .placer(FaussePiece(2)).En(0,1)

        should("retourner toutes les pièces à la verticale") {
            val actual = sut.touteLesPiecesALaVerticale(0)

            val expected =
                listOf(FaussePiece(1), FaussePiece(2))
            actual shouldContainAll expected
        }
    }
    context("un autre plateau est formé")
    {
        val sut = PlateauDimensionsVariables(3, 3, dernierCoupEstValide = false)
            .placer(FaussePiece(1)).En(0,0)
            .placer(FaussePiece(2)).En(0,1)
            .placer(FaussePiece(3)).En(1,1)

        should("retourner toutes les pièces à la verticale") {
            val actual = sut.touteLesPiecesALaVerticale(0)

            val expected =
                listOf(FaussePiece(1), FaussePiece(2))
            actual shouldContainExactly expected
            actual.size shouldBe  2
        }
    }
    context("un autre plateau avec plus de pièces")
    {
        val sut = PlateauDimensionsVariables(3, 3, dernierCoupEstValide = false)
            .placer(FaussePiece(1)).En(0,0)
            .placer(FaussePiece(2)).En(0,1)
            .placer(FaussePiece(3)).En(1,1)
            .placer(FaussePiece(4)).En(1,0)

        should("retourner toutes les pièces à la verticale") {
            val actual = sut.touteLesPiecesALaVerticale(1)

            val expected =
                listOf(FaussePiece(3), FaussePiece(4))
            actual shouldContainAll expected
            actual.size shouldBe  2
        }
    }
})
