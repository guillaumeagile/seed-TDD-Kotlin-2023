package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class PartieTest : ShouldSpec({
    context("une nouvelle partie est démarée")
    {
        val plateau = PlateauDimensionsVariables(4000, 3000)
        var partie = Partie(plateau)
        val piece1 = QuatroPiece(
            hauteur = Hauteur.HAUT,
            forme = Forme.CARRE,
            couleur = Couleur.CLAIRE,
            cavite = Cavite.PLEINE
        )
        val piece2 = QuatroPiece(
            hauteur = Hauteur.BASSE,
            forme = Forme.CARRE,
            couleur = Couleur.CLAIRE,
            cavite = Cavite.PLEINE
        )
        |

        should("personne n'a joué") {
            partie.dernierJoueur shouldBe Joueur.AUCUN
        }


        should("un joueur joue une coup") {
            val partieEnCours = partie.joueur2(Joueur.UN)

            val observé2 = partieEnCours.dernierJoueur()

            observé2 shouldBe Joueur.UN
        }


        should("un autre joueur joue ensuite") {//TODO: ca va se déplacer naturellement vers PartieEntreDeuxCoups
            val coupEnCours = partie.joueur2(Joueur.UN)
            val coupSuivant = coupEnCours.en(0, 0).pose(piece1).joue()
            val coupEnCoursSuivant = coupSuivant.joueur2(Joueur.DEUX)

            val observé = coupEnCoursSuivant.dernierJoueur()

            observé shouldBe Joueur.DEUX
        }

        should("test haut niveau idéal, deux joueurs joue coup sur coup") {
            val coup1 = partie.joueur2(Joueur.UN).pose(piece1).en(6, 5).joue()
            val coup2 = coup1.joueur2(Joueur.DEUX).en(1, 0).pose(piece2).joue()

            val pieceObservéeEn65 = coup2.estEn(6, 5)
            val pieceObservéeEn10 = coup2.estEn(1, 0)
            val pieceObservéeEn0 = coup2.estEn(1, 0)

            pieceObservéeEn65 shouldBe piece1
            pieceObservéeEn10 shouldBe piece2
            pieceObservéeEn0 shouldBe PasDePiece()
            //vérifier que les pieces posées coup après coup sont bien inscrites sur le plateau

            coup2.dernierJoueur shouldBe Joueur.DEUX
        }

        // on experimentera 2 écoles de tests "d'intégration": faut il dans la partie injecter un faux plateau, ou bien tester socialement avec le bon plateau?


        // test à écrire:
    }

})
