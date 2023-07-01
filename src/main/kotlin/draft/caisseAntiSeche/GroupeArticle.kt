package draft.caisseAntiSeche

import java.math.RoundingMode
import java.text.DecimalFormat

data class GroupeArticle(val article: Article, val quantite: Int) {

    val total = 0 // article.prixUnitaire.times(quantite.toBigDecimal())
    val totalAffiché: String
        get() {
            val df = DecimalFormat("#.00 €")
            df.roundingMode = RoundingMode.HALF_UP
            return df.format(total)
        }

}
