package pricer

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class en15mnSpecs : BehaviorSpec({
    given("un article") {
        var article = Article()
        `when`("acheté en quantité ") {
            var article3 =  article.acheté(3)
            then("qtté est ok") {
                article3.quantité shouldBe 3
            }
        }

        `when`("acheté en quantité avec un prix de 2,5 ") {
            var articleEn3QuiCoute25 =  article.acheté(3).auPrixUnitaireDe( BigDecimal( 2.5))
            then("qtté est ok") {
                articleEn3QuiCoute25.prixTotal shouldBeEqualComparingTo BigDecimal(7.5)
            }
        }

        `when`("acheté en quantité 2 avec un prix de 2,5 ") {
            var articleEn3QuiCoute25 =  article.acheté(2).auPrixUnitaireDe( BigDecimal( 2.5))
            then("prix est ok") {
                articleEn3QuiCoute25.prixTotal shouldBeEqualComparingTo   BigDecimal(5.0)
            }
            then("prix est affiché") {
                articleEn3QuiCoute25.prixAffiché shouldBe   ("5,0 €")
            }
        }
    }
})