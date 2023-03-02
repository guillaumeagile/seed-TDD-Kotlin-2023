package quatro

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class JoueurTest  : ShouldSpec({
    context("le joueur opposé de aucun joueur ")
    {
        val noJoueur = Joueur.AUCUN
        should("est aucun joueur ") {
            noJoueur.choisiLautreJoueur() shouldBe Joueur.AUCUN
        }
    }
    context("le joueur opposé de UN ")
    {
        val noJoueur = Joueur.UN
        should("est le joueur DEUX ") {
            noJoueur.choisiLautreJoueur() shouldBe Joueur.DEUX
        }
    }
})