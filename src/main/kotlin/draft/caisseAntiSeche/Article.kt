package draft.caisseAntiSeche

import java.math.BigDecimal

data class Article(val prixUnitaire: BigDecimal) {
    fun enQuantité(qtte: Int): GroupeArticle {
        return GroupeArticle(this, qtte)
    }

    fun auPrixUnitaireDe(fl: BigDecimal): Article {
        return Article(fl)
    }

}
