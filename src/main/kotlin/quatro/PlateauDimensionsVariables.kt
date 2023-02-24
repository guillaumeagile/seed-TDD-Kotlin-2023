package quatro

typealias Coordonees = Pair<Int, Int>

class PlateauDimensionsVariables(
    val maxX: Int,
    val maxY: Int,
    private val listeDesPieces: Map<Coordonees, Piece> = mapOf(),
    val dernierCoupEstValide: Boolean = true
) : Plateau {

    override fun placer(piece: Piece): PieceAPlacer {
        return TempPieceAPlacer(this, piece)
    }

    override fun estEn(x: Int, y: Int): Piece {
        val coord = Coordonees(x, y)
        return listeDesPieces.getOrDefault(coord, PasDePiece())
    }

    //TODO: could be an idea to introduce type Coordonnées!
    override fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        val coordonees = Coordonees(x, y)
        val placementEstLibre = this.estEn(x,y) == PasDePiece()
        if (placementEstLibre) {
            val nouvelleListeDesPieces = this.listeDesPieces + (coordonees to piece)
            return PlateauDimensionsVariables(this.maxX, this.maxY, nouvelleListeDesPieces, true) //immutability
        }
        return PlateauDimensionsVariables(this.maxX, this.maxY, listeDesPieces, dernierCoupEstValide = false)
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        return listeDesPieces
            .filter { p -> p.key.first == x }
            .values.toList()
    }

    override fun dernierCoupEstValide(): Boolean {
        return this.dernierCoupEstValide
    }


}
