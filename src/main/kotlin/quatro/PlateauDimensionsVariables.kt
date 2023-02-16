package quatro

typealias Coordonees = Pair<Int, Int>

//TODO: the same here, could be an idea to introduce type Coordonnées!
class PlateauDimensionsVariables(
    val maxX: Int,
    val maxY: Int,
    private val listeDesPieces: Map<Coordonees, Piece> = mapOf()
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
        val nouvelleListeDesPieces = this.listeDesPieces + (coordonees to piece)
        return PlateauDimensionsVariables(this.maxX, this.maxY, nouvelleListeDesPieces) //immutability
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        return listeDesPieces
            .filter { p -> p.key.first == x }
            .values.toList()
    }


}
