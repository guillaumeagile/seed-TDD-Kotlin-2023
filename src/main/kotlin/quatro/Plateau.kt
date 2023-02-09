package quatro

interface Plateau {
    fun Place(piece: Piece): PieceAPlacer
    fun EstEn(x: Int, y: Int): Piece
    fun NouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau
     fun TouteLesPiecesALaVerticale(x: Int):  List<Piece>

}
