package quatro

class TempPieceAPlacer
constructor(
    private val plateau: PlateauDimensionsVariables,
    private val piece: Piece
) : PieceAPlacer {

    override fun En(x: Int, y: Int): Plateau {
        return plateau.NouvellePieceEn(piece, x, y)
    }

}
