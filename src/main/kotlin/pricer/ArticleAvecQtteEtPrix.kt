package pricer

import java.math.BigDecimal

class ArticleAvecQtteEtPrix( quantité: Int,  prixUnitaire: BigDecimal ) {

    val prixAffiché: String = ""
    val prixTotal: BigDecimal = prixUnitaire.multiply(BigDecimal(quantité))
}
