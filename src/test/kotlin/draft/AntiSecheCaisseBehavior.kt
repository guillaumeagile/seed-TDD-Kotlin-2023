package draft

import draft.caisseAntiSeche.Caisse
import draft.caisseAntiSeche.Encaisseur
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class AntiSecheCaisseBehavior : BehaviorSpec({
    xgiven("3 articles à 1,3") {
        var ligne1 = Encaisseur.UnArticle().auPrixUnitaireDe(BigDecimal( 1.3)).enQuantité(3)

        then("font un sous total de 3,9") {
         //   ligne1.total shouldBe BigDecimal(3.9)
          //  ligne1.total shouldBeEqualComparingTo  BigDecimal(3.9)
            ligne1.totalAffiché shouldBe "3,9 €"
        }
    }

    xgiven("pour 1 articles à 1,3") {
        var ligne1 = Encaisseur.UnArticle().auPrixUnitaireDe(BigDecimal(1.3)).enQuantité(1)

        then("je paye un sous total de 1,3") {
            ligne1.totalAffiché shouldBe "1,3"
        }
    }

    xgiven("j'ai pris 3 articles à 1,3") {
        var ligne1 = Encaisseur.UnArticle().auPrixUnitaireDe(BigDecimal(1.3)).enQuantité(3)
        `when`("je passe à la caisse") {
            var caisse = Caisse()
            caisse.scanner(ligne1)
            then("je paye un total avec une remise de 5%") {
                caisse.totalAffiche shouldBe "3.9"
            }
        }
    }

})