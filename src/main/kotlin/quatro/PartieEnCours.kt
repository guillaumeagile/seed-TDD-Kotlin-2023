package quatro

class PartieEnCours(val joueurEnCours: Joueur, val plateau: Plateau) {
    private var derniereCoordonnees = Coordonees(0, 0)
    private var dernierePieceAPlacer: Piece = PasDePiece()

    fun en(x: Int, y: Int): PartieEnCours {
        this.derniereCoordonnees = Coordonees(x, y)
        return this
    }

    fun pose(piece: Piece): PartieEnCours {
        this.dernierePieceAPlacer = piece
        return this
    }

    fun joue(): Partie {

        return Partie( this.plateau.placer(this.dernierePieceAPlacer).En(this.derniereCoordonnees), this.joueurEnCours )
    }
}
