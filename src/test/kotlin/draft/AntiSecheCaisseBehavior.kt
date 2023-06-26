package draft

import caisseAntiSeche.Achete
import caisseAntiSeche.Caisse
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class AntiSecheCaisseBehavior : BehaviorSpec({
    given("3 articles à 1,3") {
        var ligne1 = Achete.UnArticle().auPrixUnitaireDe(BigDecimal( 1.3)).enQuantité(3)

        then("font un sous total de 3,9") {
            ligne1.total compareTo  BigDecimal(3.9)
            ligne1.totalAffiché shouldBe "3,9"
        }
    }

    given("pour 1 articles à 1,3") {
        var ligne1 = Achete.UnArticle().auPrixUnitaireDe(BigDecimal(1.3)).enQuantité(1)

        then("je paye un sous total de 1,3") {
            ligne1.totalAffiché shouldBe "1,3"
        }
    }

    given("j'ai pris 3 articles à 1,3") {
        var ligne1 = Achete.UnArticle().auPrixUnitaireDe(BigDecimal(1.3)).enQuantité(3)
        `when`("je passe à la caisse") {
            var caisse = Caisse()
            caisse.scanner(ligne1)
            then("je paye un total avec une remise de 5%") {
                caisse.totalAffiche shouldBe "3.9"
            }
        }
    }

})