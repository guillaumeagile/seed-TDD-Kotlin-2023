package quatro

data class QuatroPiece(
    val hauteur: Hauteur,
    val forme: Forme,
    val couleur: Couleur,
    val cavite: Cavite
) {
    infix fun possedeUneCaracteristiqueCommuneAvec(autre: QuatroPiece): Boolean {
        return when {
            hauteur == autre.hauteur -> true
            forme == autre.forme -> true
            couleur == autre.couleur -> true
            cavite == autre.cavite -> true
            else -> false
        }
    }

    fun differentPour(hauteur: Hauteur): QuatroPiece {
        return QuatroPiece(
            hauteur,
            this.forme,
            this.couleur,
            this.cavite
        )
    }

    fun differentPour(forme: Forme): QuatroPiece {
        return QuatroPiece(
            this.hauteur,
            forme,
            this.couleur,
            this.cavite
        )
    }
    fun differentPour(couleur: Couleur): QuatroPiece {
        return QuatroPiece(
            this.hauteur,
            this.forme,
            couleur,
            this.cavite
        )
    }
    fun differentPour(cavite: Cavite): QuatroPiece {
        return QuatroPiece(
            this.hauteur,
            this.forme,
            this.couleur,
            cavite
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