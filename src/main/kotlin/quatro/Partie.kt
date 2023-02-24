package quatro

class Partie(val plateau: Plateau,  val dernierJoueur: Joueur = Joueur.AUCUN) {

    fun joueur(joueur: Joueur): PartieEnCours {
        return PartieEnCours(joueurEnCours = joueur, plateau = plateau)
    }

    fun estEn(x: Int, y: Int): Piece =
        plateau.estEn(x, y)

    fun dernierCoupEstValide(): Boolean {
        return plateau.dernierCoupEstValide()
    }
}
