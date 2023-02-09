package quatro

class PasDePiece : Piece {
    override fun equals(other: Any?): Boolean {
         return (other is PasDePiece)
    }
    override fun hashCode(): Int {
        return 0.hashCode()
    }
}
