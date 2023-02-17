package quatro

class TempPieceAPlacer
constructor(
    private val plateau: PlateauDimensionsVariables,
    private val piece: Piece
) : PieceAPlacer {

    override fun En(x: Int, y: Int): Plateau {
        //TODO: introduire coordonnees
        return plateau.nouvellePieceEn(piece, x, y)
    }

    override fun En(c: Coordonees): Plateau {
        return plateau.nouvellePieceEn(piece, c.first, c.second)  //ne pas déconstruire coordonnées (primitif)
    }

}
