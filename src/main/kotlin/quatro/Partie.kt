package quatro

class Partie(val plateau: Plateau,  val dernierJoueur: Joueur = Joueur.AUCUN) {

    private var derniereCoordonnees = Coordonees(0, 0)
    private var dernierePieceAPlacer: Piece = PasDePiece()

    fun joueur2(joueur: Joueur): PartieEnCours {
        return PartieEnCours(joueur)
    }

    fun estEn(x: Int, y: Int): Piece =
        plateau.estEn(x, y)


    fun joue(): Partie {
        TODO()
       // return Partie(plateau.placer(this.dernierePieceAPlacer).En(this.derniereCoordonnees), this.joueurEnCours)
    }
}
