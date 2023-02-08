# Quatro-TDD-Kotlin-2023

[QUATRO, un jeu de plateau décrit en francais](https://www.trictrac.net/jeu-de-societe/quarto)

Typiquement, sur exemple aussi simple, 
si on prend le temps de lire les règles attentivements
plusieurs Bounded Contexts émergent.

 ### Mon approche: lire les règles de la fin vers le début.

BC = Bounded Context

## BC géométrie

> Le premier à aligner, verticalement, horizontalement ou en diagonale, 4 pièces ayant en commun au moins une caractéristique est le vainqueur.

Revient à définir :
Aligner  verticalement => ligne vert
Aligner  horizontalement => ligne horizon
Aligner  diagonale => ligne diagonale
Mettre en carré 4 pieces => groupe carré

-> moteur de géométrie

4 pièces (contiguës) => extraites les sous ensembles contigus de 4 pièces


## BC calcul du vainqueur (victoire)

> 4 pièces (contiguës) ayant en commun au moins une caractéristique. 

Déterminer si les 4 pièces ont au moins une caractéristique identique	(toutes les 4)

Et il faut que les pièces soient posées par le même joueur


## BC de jeu qui se joue à tour de rôle (game play)
Système qui permet de "réglementer" les tours de jeu
2 joueurs (implicite mais évident)
Jouer l’un après l’autre
votre adversaire choisie une des pièces qui n'a pas été joué et vous la donne, puis c’est à vous de la poser (selon les principes ci dessous)

## BC de l'ensemble des pièces existantes (pièces)
>	16 pièces toutes différentes ayant un point commun avec 7 autres.
8 pièces hautes , 8 claires, 8 rondes et 8 creuses.

On en déduit:
 - hauteur: haute/basse
 - Couleur: clair/foncé
 - Forme: rond/carré
 - Remplissage :  pleine/vide


## BC de vérification du placement des pions (contrôle position):

Jouer que des pièces qui existent:

> Vous devez la poser sur un emplacement libre du plateau.


## BC Plateau:  

> Composé de 16 cases, 4 sur 4, il est en début de partie vide de toutes pièces.

# Cartographie à la Wardley

https://draft.io/wmqbfrk8mvt5me8vygugq72567565kgeamjqk3uwt7mm

# Par quoi commencer?

Le plateau est presque indépendant, il connait juste la présence des pièces.
L'ensemble des pièces est indépendant.
La géométrie est dépendante du plateau

La verif des pièces a besoin de connaitre les pièces
Le calcul du vainqueur a besoin de connaitre les pieces et les joueurs

Le BC de la partie appelle la geométrie, à partir des résultats de celle ci
elle peut appeler le calcul du vainqueur pour savoir si on continue ou si on arrête


Le BC de la partie a besoin du plateau, des jeux, des joueurs,
de la verif de placement des pions, et de la regle de victoire qui dans ce cas là 
a besoin de la géométrie (comme expliqué juste avant).