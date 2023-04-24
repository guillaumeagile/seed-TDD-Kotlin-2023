package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class ListeDePiecesTest : ShouldSpec({

    context("test unitaire sur des listes de pièces"){

        val piece1 = QuatroPiece(
            hauteur = Hauteur.HAUT,
            forme = Forme.CARRE,
            couleur = Couleur.CLAIRE,
            cavite = Cavite.PLEINE
        )
        
        should("liste videe"){
            val sut =    emptyList<QuatroPiece>()
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe false
        }

        should("trouver que toutes les pieces ont toutes au moins en commun une caractéristique"){
            val piece2 = piece1.differentPour(hauteur = Hauteur.BASSE)
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }

        should(" trouver que toutes les pieces ont toutes au moins en commun une caractéristique quand la couleur diffère"){
            val piece2 = piece1.differentPour(couleur = Couleur.SOMBRE)
            // TODO:  revoir API differentPour,  ne pas avoir à spécifier la couleur mais prendre la couleur opposée
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }

        should(" trouver que toutes les pieces ont toutes au moins en commun une caractéristique quand la couleur et la hauter diffèrent"){
            val piece2 = piece1.differentPour(couleur = Couleur.SOMBRE).differentPour(hauteur = Hauteur.BASSE)
            // TODO:  revoir API differentPour,  ne pas avoir à spécifier la couleur mais prendre la couleur opposée
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }

        should(" trouver que toutes les pieces ont toutes au moins en commun une caractéristique quand la couleur et la hauteur et la cavité diffèrent"){
            val piece2 = piece1.differentPour(couleur = Couleur.SOMBRE).differentPour(hauteur = Hauteur.BASSE).differentPour(cavite = Cavite.CREUSE)
            // TODO:  revoir API differentPour,  ne pas avoir à spécifier la couleur mais prendre la couleur opposée
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe true
        }

        should(" trouver que toutes les pieces n'ont rien en commun comme caractéristique "){
            val piece2 = piece1.differentPour(couleur = Couleur.SOMBRE)
                .differentPour(hauteur = Hauteur.BASSE)
                .differentPour(cavite = Cavite.CREUSE)
                .differentPour(forme = Forme.RONDE)
            // test de documentation
            val sut =    listOf(piece1, piece2)
            val actual = sut.ontToutesUneCaracteristiqueCommune()

            actual shouldBe false
        }
    }

})
