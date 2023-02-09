package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import quatro.doubluresDeTest.FaussePiece

@Suppress("unused")
class GeometryTest : ShouldSpec({
    context("un plateau est formé")
    {
        val sut = PlateauDimensionsVariables(3, 3)
            .Place(FaussePiece(1)).En(0,0)
            .Place(FaussePiece(2)).En(0,1)

        should("retourner toutes les pièces à la verticale") {
            val actual = sut.TouteLesPiecesALaVerticale(0)

            val expected =
                listOf(FaussePiece(1), FaussePiece(2))
            actual shouldContainAll expected
        }
    }

})
