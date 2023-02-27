# choses_apprises

Ce code sert pour deux choses.
D'abord pour la these DDD UL que je co rédige avec Hervé Leblanc et Isabelle Blasquez.
Pour démontrer certaines choses, nous avons eu recours à l'énoncé du jeu de Quatro, pour ensuite le faire développer par différentes équipes.


Ici vous trouverez la version qu'Anthony Cassaigne et moi même avons développé en [Coding Kata/Randori](https://codingdojo.org/practices/RandoriKata/)
dans notre Dojo d'[Open Agile Toulouse](https://discord.gg/BFE5W8g3).
Vous pouvez nous suivre sur Discord souvent le lundi et vendredi soir vers 18/19h.

Lors de ce Kata nous rappelons sans cesse les même règles: TDD, KISS, YAGNI.
Always Keep It Simple.
Pour autant, la simplicité est une discipline pas simple. Exigeante.

Nous cherchons à appliquer les principes anti compléxité accidentelle que nous propose la programmation fonctionnelle. Venant de l'objet nous apprécions
Kotlin qui nous pousse à de l'immutabilité, du style fonctionnel, de typage fort pour chasser les primitives obessesions, etc.

Je vais détailler ici ce que nous apprenons à chaque fois que nous commitons du code sur cet exercice.


## Mikado méthode et Carte à la Wardley

## Test First, révélateur d'une bonne raison

## Rouge pour les bonnes raisons

## Construire son code dans les tests comme si c'était une API

## Axes de tests comme des axes de liberté

## immutabilité

## plus fonctionnel

## fonctions honnetes

## primitive obsession

## refactoring: uniquement si tout est au vert

## refactoring: paralell change

## fluent API

## Loi de Demeter et fluent API

Attention, malgré les apparentes, écrire une "fluent API" ne casse pas la loi de Demeter.
En effet, l'encapsulation n'est pas brisé, car après chaque point, ce ne sont pas des détails internes de la classe (des propriétés) qui sont exposés
mais bien des fonctions publiques, qui sont volontairement écrites pour être utilisées. Et elles sont documentées. C'est à dire que leur comportement est
vérifié ET documenté par les tests unitaires.


## Entités

## Agrégats

## SRP

## CUPID

## Tests unitaires

## Boites blanches ou boites noires

## Tests sociaux

## Tests d'intégration: définition et limites

## Tests de consolidation
un cas non passant (bug) se présente mais on pourrait le passer (YAGNI???)
Le YAGNI ne s'applique pas aux bugs. Les bugs sont de la perte de valeur.
Poser le test nous coute 30 secondes. Allons y.
Ici, on a une notion de complétude, de couverture de cas liées à un type.

De toutes façons, le mutation testing aurait de suite levé le loup et nous aurait forcé à écrire le test qui manque.

TODO: integrer mutation testing dans le projet.







## Tests de documentation


