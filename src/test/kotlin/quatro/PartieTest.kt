package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import quatro.doubluresDeTest.FauxPlateau

@Suppress("unused")
class PartieTest : ShouldSpec({
    context("une nouvelle partie est démarée")
    {
        val plateau = PlateauDimensionsVariables(4000, 3000, dernierCoupEstValide = false)
        val partieInitiale = Partie(plateau)
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

        should("test haut niveau idéal, deux joueurs joue coup sur coup, on doit retrouver le dernier joueur") {
            val partieApresTourDuJoueur1 = partieInitiale.joueur(Joueur.UN).pose(piece1).en(6, 5).joue()
            val partieApresTourDuJoueur2 = partieApresTourDuJoueur1.joueur(Joueur.DEUX).en(1, 0).pose(piece2).joue()

            partieApresTourDuJoueur2.dernierJoueur shouldBe Joueur.DEUX
        }




        // -----------------------------------------
        // AXE DE TEST  : ON CHERCHE A VALIDER LES TOURS (COUPS) SUCCESSIF

        should("test haut niveau idéal, deux joueurs joue coup sur coup, on doit retrouver les pieces en bonne position") {
            val partieApresTourDuJoueur1 = partieInitiale.joueur(Joueur.UN).pose(piece1).en(6, 5).joue()
            val partieApresTourDuJoueur2 = partieApresTourDuJoueur1.joueur(Joueur.DEUX).en(1, 0).pose(piece2).joue()

            // LES 4 LIGNES SUIVANTES SONT DEJA VERIFIEES PAR LES TESTS DU PLATEAU
            /*
            partieApresTourDuJoueur2.estEn(6, 5) shouldBe piece1
            partieApresTourDuJoueur2.estEn(1, 0) shouldBe piece2
            partieApresTourDuJoueur2.estEn(0, 0) shouldBe PasDePiece()
            partieApresTourDuJoueur2.dernierCoupEstValide() shouldBe true  // LIGNE SOUS ATTENTION:  ici du test social utile
            VOIR TEST SOCIAL PLUS BAS
            */

            // PARTIE UTILE ICI:
            partieApresTourDuJoueur2.dernierJoueur shouldBe Joueur.DEUX
        }

        // -----------------------------------------
        // UN NOUVEL AXE DE TEST  : ON CHERCHE A VALIDER LES POSITIONS SUCCESSIVES DES PIECES
        should("test haut niveau idéal, deux joueurs joue coup sur coup, un joueur pose la piece sur une case occupée") {
            val partieApresTourDuJoueur1 = partieInitiale.joueur(Joueur.UN).pose(piece1).en(6, 5).joue()
            val partieApresTourDuJoueur2 = partieApresTourDuJoueur1.joueur(Joueur.DEUX).en(6, 5).pose(piece2).joue()
            // pour éviter de faire du test trop "social", un spy de plateau serait largement suffisant
            // et surtout nous éviterai trop de ARRANGE dans ce test (pas la peine de placer autant de pièces)

            // LES DEUX LIGNES SUIVANTES SONT DEJA VERIFIEES PAR AILLEURS
            // partieApresTourDuJoueur2.dernierCoupEstValide() shouldBe false
            // partieApresTourDuJoueur2.estEn(6, 5) shouldBe piece1
            // VOIR TEST SOCIAL PLUS BAS

            // PARTIE UTILE ICI:
            partieApresTourDuJoueur2.dernierJoueur shouldBe Joueur.UN
        }

    }

    context("test social avec doublure"){
        val piece1 = QuatroPiece(
            hauteur = Hauteur.HAUT,
            forme = Forme.CARRE,
            couleur = Couleur.CLAIRE,
            cavite = Cavite.PLEINE
        )

        

        should("le dernier coup valide est celui donné par le plateau") {
            val plateau = FauxPlateau(dernierCoupEstValide = true)
            val partieInitiale = Partie(plateau)

            partieInitiale.dernierCoupEstValide() shouldBe true  // ici du test social utile
        }

        should("le dernier coup invalide est celui donné par le plateau") {
            val plateau = FauxPlateau(dernierCoupEstValide = false)
            val partieInitiale = Partie(plateau)

            partieInitiale.dernierCoupEstValide() shouldBe false  // ici du test social utile
        }

        should("la partie demande au plateau la position de chaque pièce") {
            val plateau = FauxPlateau(dernierCoupEstValide = false, piece1)
            val partieInitiale = Partie(plateau)

            partieInitiale.estEn(6, 5) shouldBe piece1  // ici du test social utile
        }

        should("la partie demande au plateau si on a un vainqueur") {
            val plateau = FauxPlateau(dernierCoupEstValide = false, piece1)
            val partieInitiale = Partie(plateau)

            partieInitiale.estGagnee() shouldBe true  // ici du test social utile
        }

        xshould("la partie demande au plateau si personne n'a encore gagné") {
            val plateau = FauxPlateau(dernierCoupEstValide = false, piece1)
            val partieInitiale = Partie(plateau)

            partieInitiale.estGagnee() shouldBe false  // ici du test social utile
        }

     /*   should("trouver que toutes les pieces n'ont pas de caractéristique commune"){
            val sut =    listOf(FaussePiece(1), FaussePiece(2))
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe false
        }
*/
        should("trouver que toutes les pieces ont toutes au moins en commun une caractéristique"){
            val piece2 = piece1.differentPour(hauteur = Hauteur.BASSE)
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }

        should("liste videe"){
            val sut =    emptyList<QuatroPiece>()
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe false
        }

        should("WIP trouver que toutes les pieces ont toutes au moins en commun une  autre caractéristique"){
            val piece2 = piece1.differentPour(couleur = Couleur.SOMBRE)
            // TODO:  revoir API differentPour,  ne pas avoir à spécifier la couleur mais prendre la couleur opposée
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }
    }

})
