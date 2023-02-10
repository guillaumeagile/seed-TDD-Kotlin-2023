package quatro

class PlateauDimensionsVariables(
    val maxX: Int,
    val maxY: Int,
    private val listeDesPieces: Map<Pair<Int, Int>, Piece> = mapOf()
) : Plateau {

    override fun placer(piece: Piece): PieceAPlacer {
        return TempPieceAPlacer(this, piece)
    }

    override fun estEn(x: Int, y: Int): Piece {
        val coord = Pair(x, y)
        return listeDesPieces.getOrDefault(coord, PasDePiece())
    }

    override fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        val coordonees = Pair(x, y)
        val nouvelleListeDesPieces = this.listeDesPieces + (coordonees to piece)
        return PlateauDimensionsVariables(this.maxX, this.maxY, nouvelleListeDesPieces) //immutability
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        return listeDesPieces
            .filter { p -> p.key.first == x }
            .values.toList()
    }


}
