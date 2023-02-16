package quatro

class Partie( val plateau: Plateau) {

    private var dernierJoueur: Joueur = Joueur.AUCUN

    fun dernierCoupJouéPar(): Joueur {
        return dernierJoueur
    }

    fun joueur(joueur: Joueur): Partie {
        this.dernierJoueur = joueur
       return this
    }

}
