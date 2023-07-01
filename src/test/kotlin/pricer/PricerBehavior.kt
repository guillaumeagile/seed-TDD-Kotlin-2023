package pricer

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PricerBehavior : BehaviorSpec({
    given("le pricer") {
        var pricer = Pricer()
        `when`("quantité à ") {
            var actual = pricer.jeChoisiQuantité(3)
            then("qtté est ok") {
                actual.quantité shouldBe 3
            }
        }

        `when`("qte 2 et PU 3,5") {
            var actual = pricer.jeChoisiQuantité(2).auPrixUnitaireDe(BigDecimal(3.5))
            then("PU est ok") {
                actual.prixUnitaire shouldBeEqualComparingTo BigDecimal(3.5)
            }
            then("PT est ok") {
                actual.prixTotal shouldBeEqualComparingTo BigDecimal(7.0)
            }
            then("PTA est ok") {
                actual.prixTotalAffiché shouldBe "7,00 €"
            }
        }

        `when`("qte 2 et PU 3,5 et taxe 10%") {
            var actual = pricer.jeChoisiQuantité(2)
                .auPrixUnitaireDe(BigDecimal(3.5))
                .avecTaxe(BigDecimal(10.0))
            then("PU est ok") {
                actual.prixUnitaire shouldBeEqualComparingTo BigDecimal(3.5)
            }
            then("PT est ok") {
                actual.prixTotal compareTo BigDecimal(7)
            }
            then("PTA est ok") {
                actual.prixTotalAffiché shouldBe "7,70 €"
            }
        }
        `when`("qte 5 et PU 345 et taxe 10% et remise appliquée") {
            var actual = pricer.jeChoisiQuantité(5)
                .auPrixUnitaireDe(BigDecimal(200))
                .avecTaxe(BigDecimal(10.0))
            then("remise est ok") {
                actual.remise shouldBeEqualComparingTo  BigDecimal(33)
            }
            then("total est ok") {
                actual.prixTotalAffiché shouldBe "1067,00 €"
            }
        }
    }

    xgiven("---") {

        `when`("---") {

            then("----") {
            }
        }
    }

})