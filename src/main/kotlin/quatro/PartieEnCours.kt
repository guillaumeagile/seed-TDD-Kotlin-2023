package quatro

class PartieEnCours(val joueurEnCours: Joueur) {
    private var derniereCoordonnees = Coordonees(0, 0)
    private var dernierePieceAPlacer: Piece = PasDePiece()

    fun dernierJoueur(): Joueur = joueurEnCours

    fun en(x: Int, y: Int): PartieEnCours {
        this.derniereCoordonnees = Coordonees(x, y)
        return this
    }

    fun pose(piece: Piece): PartieEnCours {
        this.dernierePieceAPlacer = piece
        return this
    }

    fun joue(): Partie {
        return Partie( PlateauDimensionsVariables(0, 0), )
    }
}
