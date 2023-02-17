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
            partie.joueurEnCours() shouldBe Joueur.AUCUN
            partie.dernierJoueur shouldBe Joueur.AUCUN
        }


        should("un joueur joue une coup") {
             partie =  partie.joueur(Joueur.UN)

            val observé = partie.joueurEnCours()

             observé shouldBe Joueur.UN
        }

        should("un autre joueur joue une coup") {
            partie =  partie.joueur(Joueur.UN)
            partie =  partie.joueur(Joueur.DEUX)

            val observé = partie.joueurEnCours()

            observé shouldBe Joueur.DEUX
        }

        should("un joueur joue deux coups de suite") {//TODO: ca va se déplacer naturellement vers PartieEntreDeuxCoups
            partie =  partie.joueur(Joueur.UN)
            partie =  partie.joueur(Joueur.UN)

            val observé = partie.joueurEnCours()

            observé shouldBe Joueur.UN
        }

        should("test haut niveau idéal") {
            partie =  partie.joueur(Joueur.UN).pose(piece1).en( 65, 0).joue()
           /// partie.joueur(Joueur.UN).en( 0, 0).pose(piece1).joue()

           // partie = partie.en( 0, 0).pose(piece1).joue()   ->  TODO: rendre ceci impossible

            val pieceObservéeEn65 = partie.estEn(65,0)
            val pieceObservéeEn0 = partie.estEn(0,0)

           pieceObservéeEn65 shouldBe piece1
           pieceObservéeEn0 shouldBe PasDePiece()

            partie.dernierJoueur shouldBe Joueur.UN
        }

        // on experimentera 2 écoles de tests "d'intégration": faut il dans la partie injecter un faux plateau, ou bien tester socialement avec le bon plateau?

    }

})
