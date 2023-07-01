package pricer

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class ArticleAchetéEnQuantitéAuPrixUnitaire(
    val prixUnitaire: BigDecimal,
    val quantité: Int,
    val taxe: BigDecimal = BigDecimal.ZERO
) {
    fun avecTaxe(taxe: BigDecimal): ArticleAchetéEnQuantitéAuPrixUnitaire {
        return ArticleAchetéEnQuantitéAuPrixUnitaire(prixUnitaire, quantité = quantité, taxe = taxe)
    }

    val prixSansRemise: BigDecimal = prixUnitaire.multiply(BigDecimal(quantité))
        .multiply(taxe.divide(BigDecimal(100)).add(BigDecimal.ONE))
    val remise: BigDecimal
        get()  {
            if (prixSansRemise< BigDecimal(1000))
                return  BigDecimal.ZERO
            val ristourne = BigDecimal (3)
            return prixSansRemise  .multiply(ristourne.divide(BigDecimal(100)))
        }
    val prixTotal = prixSansRemise.subtract(remise)
    val prixTotalAffiché: String
        get() {
            val df = DecimalFormat("#.00 €")
            df.roundingMode = RoundingMode.UP
            return df.format(prixTotal)
        }


}
