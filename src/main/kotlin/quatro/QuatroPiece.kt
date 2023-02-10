package quatro

data class QuatroPiece(
    val hauteur: Hauteur,
    val forme: Forme,
    val couleur: Couleur,
    val cavite: Cavite
) {
    infix fun possedeUneCaracteristiqueCommuneAvec(autre: QuatroPiece): Boolean {
        if (hauteur == autre.hauteur) return true
        if (forme == autre.forme) return true
        return false
    }

    fun differentPour(hauteur: Hauteur): QuatroPiece {
        return QuatroPiece(
            hauteur,
            this.forme,
            this.couleur,
            this.cavite
        )
    }
}

enum class Couleur {
    SOMBRE,
    CLAIRE

}

enum class Cavite {
    CREUSE,
    PLEINE

}

enum class Forme {
    RONDE,
    CARRE

}

enum class Hauteur {
    BASSE,
    HAUT

}