package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class PartieTest : ShouldSpec({
    context("une nouvelle partie est démarée")
    {
        val plateau = PlateauDimensionsVariables(4000, 3000)
        var partie = Partie( plateau)
        val piece1 = QuatroPiece(
            hauteur = Hauteur.HAUT,
            forme = Forme.CARRE,
            couleur = Couleur.CLAIRE,
            cavite = Cavite.PLEINE
        )


        xshould("test haut niveau idéal") {
          //  partie =  partie.joueur(Joueur.UN).placer(piece1).En(0, 0)
            //TODO: renommer placer en place

            //val observé = partie.estGagnée()

           // observé shouldBe false
        }

        should("personne n'a joué") {
            val observé = partie.dernierCoupJouéPar()

            observé shouldBe Joueur.AUCUN
        }


        should("un joueur joue une coup") {
             partie =  partie.joueur(Joueur.UN)

            val observé = partie.dernierCoupJouéPar()

             observé shouldBe Joueur.UN
        }

        should("un autre joueur joue une coup") {
            partie =  partie.joueur(Joueur.UN)
            partie =  partie.joueur(Joueur.DEUX)

            val observé = partie.dernierCoupJouéPar()

            observé shouldBe Joueur.DEUX
        }

        should("un joueur joue deux coups de suite") {
            partie =  partie.joueur(Joueur.UN)
            partie =  partie.joueur(Joueur.UN)

            val observé = partie.dernierCoupJouéPar()

            observé shouldBe Joueur.UN
        }
    }

})
