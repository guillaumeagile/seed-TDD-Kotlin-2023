package quatro

enum class Joueur {
    UN,
    DEUX,
    AUCUN;

    fun choisiLautreJoueur(): Joueur =
        when (this) {
            UN -> DEUX
            DEUX -> UN
            else -> AUCUN
        }
}
