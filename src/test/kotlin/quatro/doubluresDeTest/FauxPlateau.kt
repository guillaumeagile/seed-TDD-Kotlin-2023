package quatro.doubluresDeTest

import quatro.Piece
import quatro.PieceAPlacer
import quatro.Plateau

class FauxPlateau(val dernierCoupEstValide: Boolean, val dernierePieceConnue: Piece = PiecePourLesTests(0))  : Plateau {
    override fun placer(piece: Piece): PieceAPlacer {
        TODO("Not yet implemented")
    }

    override fun estEn(x: Int, y: Int): Piece {
        return dernierePieceConnue
    }

    override fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        TODO("Not yet implemented")
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        TODO("Not yet implemented")
    }

    override fun dernierCoupEstValide(): Boolean {
        return dernierCoupEstValide
    }

}
