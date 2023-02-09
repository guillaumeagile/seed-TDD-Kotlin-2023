package quatro

class Plateau4x4(val listeDesPieces: Map<Pair<Int, Int>, Piece> = mapOf()) : Plateau {

    override fun Place(piece: Piece): PieceAPlacer {
       return TempPieceAPlacer(this, piece)
    }

    override fun EstEn(x: Int, y: Int): Piece {
        val coord = Pair(x,y)
        val filtered = listeDesPieces.filter { p -> p.key ==coord }
        return when {
            filtered.any() -> filtered.values.first()
            else -> PasDePiece()
        }
      // return  listeDesPieces.filter { p -> p.key ==coord }.getOrDefault(coord, PasDePiece())
    }

    override fun NouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau {
        val coordonees = Pair(x, y)
        val listeDesPieces = mapOf(coordonees to piece)
        return Plateau4x4(listeDesPieces)
    }

}
