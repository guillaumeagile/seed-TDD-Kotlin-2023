package quatro.doubluresDeTest

import quatro.Piece
import quatro.PieceAPlacer
import quatro.Plateau

class FauxPlateau : Plateau {
    override fun Place(piece: Piece): PieceAPlacer {
        TODO("Not yet implemented")
    }

    override fun EstEn(x: Int, y: Int): Piece {
        TODO("Not yet implemented")
    }

    override fun NouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        TODO("Not yet implemented")
    }

    override fun TouteLesPiecesALaVerticale(x: Int): List<Piece> {
        TODO("Not yet implemented")
    }

}
