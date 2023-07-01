package pricer

import java.math.BigDecimal

class ArticleAvecQuantité(val quantité: Int) {
    fun auPrixUnitaireDe(prixUnitaire: BigDecimal): ArticleAchetéEnQuantitéAuPrixUnitaire =
        ArticleAchetéEnQuantitéAuPrixUnitaire(prixUnitaire, quantité)
}
