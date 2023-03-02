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
        val plateau1 = this.plateau.placer(this.dernierePieceAPlacer).En(this.derniereCoordonnees)
        if (plateau1.dernierCoupEstValide())
             return Partie(plateau1, this.joueurEnCours )
        return Partie(this.plateau,  this.joueurEnCours.choisiLautreJoueur() ) // TODO: à changer avec le dernier "bon" joueur connu
    }

}

