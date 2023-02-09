package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll

class GeometryTest : ShouldSpec({
    context("un plateau est formé")
    {
        val plateau = Plateau4x4().Place(FaussePiece(1)).En(0,0)  //d'abord testons ceci
        val sut = Geometrie(plateau)

        should("retourner toutes les pièces à la verticale") {
            val actual = sut.TouteLesPiecesALaVerticale()

            val expected = listOf(
                listOf(FaussePiece(1), FaussePiece(2)),
                listOf(FaussePiece(3), FaussePiece(4)))
            actual shouldContainAll expected
        }
    }

})
