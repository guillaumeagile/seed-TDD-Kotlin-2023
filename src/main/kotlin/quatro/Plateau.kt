package quatro

interface Plateau {
    fun placer(piece: Piece): PieceAPlacer
    fun estEn(x: Int, y: Int): Piece
    fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau
     fun touteLesPiecesALaVerticale(x: Int):  List<Piece>
    fun dernierCoupEstValide(): Boolean

}
