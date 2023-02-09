package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class PlateauTest : ShouldSpec({
    xcontext("un plateau est formé")
    {
        val sut = Plateau4x4()

        should("ne pas retrouver une pièce qui n'a pas été placé ") {

            val actual = sut.EstEn(0,0)

            actual shouldBe PasDePiece()

            //TODO: écrire le value object FaussePiece (plus simple que la pièce avec des caractéristiques)
        }

        should("placer et retrouver une pièce ") {
           val result = sut.Place(FaussePiece(1)).En(0,0)  //d'abord testons ceci

            val actual = result.EstEn(0,0)

            actual shouldBe FaussePiece(1)
        }
    }

})
