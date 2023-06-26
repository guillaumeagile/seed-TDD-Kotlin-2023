package caisseAntiSeche

import java.math.RoundingMode
import java.text.DecimalFormat

data class GroupeArticle(val article: Article, val quantite: Int) {

    val total =  article.prixUnitaire.times(quantite.toBigDecimal())
    val totalAffiché: String
        get() {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.HALF_UP
            return df.format(total)
        }

}
