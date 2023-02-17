package quatro

class Partie(val plateau: Plateau, public val dernierJoueur: Joueur = Joueur.AUCUN) {

    private var derniereCoordonnees = Coordonees(0, 0)
    private var dernierePieceAPlacer: Piece = PasDePiece()
    private var joueurEnCours: Joueur = Joueur.AUCUN

    fun joueurEnCours(): Joueur = joueurEnCours


    fun joueur(joueur: Joueur): Partie {
        this.joueurEnCours = joueur
        return this
    }

    fun pose(piece: Piece): Partie {
        this.dernierePieceAPlacer = piece
        return this
    }

    fun estEn(x: Int, y: Int): Piece =
        plateau.estEn(x, y)

    fun en(x: Int, y: Int): Partie {
        this.derniereCoordonnees = Coordonees(x, y)
        return this
    }

    fun joue(): Partie {
        return Partie(plateau.placer(this.dernierePieceAPlacer).En(this.derniereCoordonnees), this.joueurEnCours)
    }

}
