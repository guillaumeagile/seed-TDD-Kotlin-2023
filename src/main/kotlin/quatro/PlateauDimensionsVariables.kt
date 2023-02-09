package quatro

class PlateauDimensionsVariables(
    val maxX: Int,
    val maxY: Int,
    private val listeDesPieces: Map<Pair<Int, Int>, Piece> = mapOf()
) : Plateau {

    override fun Place(piece: Piece): PieceAPlacer {
        return TempPieceAPlacer(this, piece)
    }

    override fun EstEn(x: Int, y: Int): Piece {
        val coord = Pair(x, y)
        return listeDesPieces.getOrDefault(coord, PasDePiece())
    }

    override fun NouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        val coordonees = Pair(x, y)
        val nouvelleListeDesPieces = this.listeDesPieces + (coordonees to piece)
        return PlateauDimensionsVariables(this.maxX, this.maxY, nouvelleListeDesPieces) //immutability
    }

    override fun TouteLesPiecesALaVerticale(x: Int): List<Piece> {
        return listeDesPieces.values.toList()
    }


}
