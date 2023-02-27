package quatro

typealias Coordonees = Pair<Int, Int>

class PlateauDimensionsVariables(
    val maxX: Int,
    val maxY: Int,
    private val listeDesPieces: Map<Coordonees, Piece> = mapOf(),
    val dernierCoupEstValide: Boolean = true   //  pour éviter un argument de plus dans le constructeur, on peut introduire
// un type PlateauDimensionsVariablesDernierCoupInvalide qui a comme propriété dernierCoupEstValide: Boolean = true
) : Plateau {

    override fun placer(piece: Piece): PieceAPlacer {
        return TempPieceAPlacer(this, piece)
    }

    override fun estEn(x: Int, y: Int): Piece = estEn( Coordonees(x, y))

    fun estEn(coord : Coordonees): Piece = listeDesPieces.getOrDefault(coord, PasDePiece())

    // IDEE POUR PLUS TARD: faire émerger un type "Coup" qui pourra rentrer dans une Monad Sucess/Failure (sans toucher au plateau)
    override fun nouvellePieceEn(piece: Piece, x: Int, y: Int): Plateau { //TODO: could be an idea to introduce type Coordonnées!
        val coordonees = Coordonees(x, y)

        if (this.listeDesPieces.containsValue(piece))
            return PlateauDimensionsVariables(
                this.maxX,
                this.maxY,
                listeDesPieces,
                dernierCoupEstValide = false
            )

        return posePieceSiCoordoneesLibre(coordonees, piece)
    }

    private fun posePieceSiCoordoneesLibre(
        coordonees: Coordonees,
        piece: Piece
    ): PlateauDimensionsVariables {
        if (estEn(coordonees) == PasDePiece()) {
            val nouvelleListeDesPieces = this.listeDesPieces + (coordonees to piece)
            return PlateauDimensionsVariables(
                this.maxX,
                this.maxY,
                nouvelleListeDesPieces,
                true
            ) //immutability
        }
        return PlateauDimensionsVariables(
            this.maxX,
            this.maxY,
            listeDesPieces,
            dernierCoupEstValide = false
        )
    }

    override fun touteLesPiecesALaVerticale(x: Int): List<Piece> {
        return listeDesPieces
            .filter { p -> p.key.first == x }
            .values.toList()
    }

    override fun dernierCoupEstValide(): Boolean {
        return this.dernierCoupEstValide
    }


}
