package quatro

class TempPieceAPlacer
constructor(
    private val plateau: Plateau4x4,
    private val piece: Piece
) : PieceAPlacer {

    override fun En(x: Int, y: Int): Plateau {
        return plateau.NouvellePieceEn(piece, x, y)
    }

}
