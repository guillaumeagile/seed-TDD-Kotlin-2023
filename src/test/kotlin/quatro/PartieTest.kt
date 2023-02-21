package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class PartieTest : ShouldSpec({
    context("une nouvelle partie est démarée")
    {
        val plateau = PlateauDimensionsVariables(4000, 3000)
        var partieInitiale = Partie(plateau)
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

        should("personne n'a joué") {
            partieInitiale.dernierJoueur shouldBe Joueur.AUCUN
        }


        should("un joueur joue une coup") {
            val partieEnCours = partieInitiale.joueur(Joueur.UN)

            val observé2 = partieEnCours.joueurEnCours

            observé2 shouldBe Joueur.UN
        }


        should("un autre joueur joue ensuite") {//TODO: ca va se déplacer naturellement vers PartieEntreDeuxCoups
            val coupEnCours = partieInitiale.joueur(Joueur.UN)
            val coupSuivant = coupEnCours.en(0, 0).pose(piece1).joue()
            val coupEnCoursSuivant = coupSuivant.joueur(Joueur.DEUX)

            val observé = coupEnCoursSuivant.joueurEnCours

            observé shouldBe Joueur.DEUX
        }

        should("test haut niveau idéal, deux joueurs joue coup sur coup, on doit retrouver les pieces en bonne position") {
            val partieApresTourDuJoueur1 = partieInitiale.joueur(Joueur.UN).pose(piece1).en(6, 5).joue()
            val partieApresTourDuJoueur2 = partieApresTourDuJoueur1.joueur(Joueur.DEUX).en(1, 0).pose(piece2).joue()

            partieApresTourDuJoueur2.estEn(6, 5) shouldBe piece1
            partieApresTourDuJoueur2.estEn(1, 0) shouldBe piece2
            partieApresTourDuJoueur2.estEn(0, 0) shouldBe PasDePiece()
        }

        should("test haut niveau idéal, deux joueurs joue coup sur coup, on doit retrouver le dernier joueur") {
            val partieApresTourDuJoueur1 = partieInitiale.joueur(Joueur.UN).pose(piece1).en(6, 5).joue()
            val partieApresTourDuJoueur2 = partieApresTourDuJoueur1.joueur(Joueur.DEUX).en(1, 0).pose(piece2).joue()

            partieApresTourDuJoueur2.dernierJoueur shouldBe Joueur.DEUX
        }


        // on experimentera 2 écoles de tests "d'intégration": faut il dans la partie injecter un faux plateau, ou bien tester socialement avec le bon plateau?


        // test à écrire:
    }

})
