package pricer

import java.math.BigDecimal

class ArticleAvecQtte(val quantité: Int) {
    fun auPrixUnitaireDe(prixUnitaire: BigDecimal): ArticleAvecQtteEtPrix = ArticleAvecQtteEtPrix(
        quantité = quantité,
        prixUnitaire = prixUnitaire
    )

}
