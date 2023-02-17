package quatro

interface PieceAPlacer {
     fun En(x: Int, y: Int): Plateau

     fun En(c: Coordonees): Plateau

}
