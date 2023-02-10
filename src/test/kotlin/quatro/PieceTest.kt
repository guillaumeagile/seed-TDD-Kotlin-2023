package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import quatro.doubluresDeTest.FaussePiece

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
            PasDePiece() shouldBe PasDePiece()
        }

    }

    context("une piece quatro")
    {
        val observe = QuatroPiece(
            hauteur = Hauteur.BASSE,
            forme = Forme.RONDE,
            couleur = Couleur.SOMBRE,
            cavite = Cavite.CREUSE
        )



        should("égalite pour 4 caractéristiques identique") {
            val attendu = QuatroPiece(
                hauteur = Hauteur.BASSE,
                forme = Forme.RONDE,
                couleur = Couleur.SOMBRE,
                cavite = Cavite.CREUSE
            )
            observe shouldBe attendu
        }

        should("inégalite de deux pièces lorsqu'elles diffèrent d'une caractéristique") {
            val attendu = QuatroPiece(
                hauteur = Hauteur.HAUT,
                forme = Forme.RONDE,
                couleur = Couleur.SOMBRE,
                cavite = Cavite.CREUSE
            )
            observe shouldNotBe attendu
        }
    }


})

