package quatro

data class QuatroPiece(
    val hauteur: Hauteur,
    val forme: Forme,
    val couleur: Couleur,
    val cavite: Cavite
) {
}

enum class Couleur {
    SOMBRE

}

enum class Cavite {
    CREUSE

}

enum class Forme {
    RONDE

}

enum class Hauteur {
    BASSE,
    HAUT

}