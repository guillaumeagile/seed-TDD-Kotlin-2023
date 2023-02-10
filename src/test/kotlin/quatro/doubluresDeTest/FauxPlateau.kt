package quatro.doubluresDeTest

import quatro.Piece
import quatro.PieceAPlacer
import quatro.Plateau

class FauxPlateau : Plateau {
    override fun placer(piece: Piece): PieceAPlacer {
        TODO("Not yet implemented")
    }

    override fun estEn(x: Int, y: Int): Piece {
        TODO("Not yet implemented")
    }

    override fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        TODO("Not yet implemented")
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        TODO("Not yet implemented")
    }

}
