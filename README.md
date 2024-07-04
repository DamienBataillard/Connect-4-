# Connect 4

Ce projet est une implémentation du jeu Connect 4 en Java. Deux joueurs peuvent jouer l'un contre l'autre, choisir leurs noms et leurs couleurs avant de commencer le jeu.

## Prérequis

Avant de commencer, assurez-vous d'avoir les logiciels suivants installés sur votre machine :

- [Java JDK 8 ou supérieur](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Installation

1. Clonez le dépôt GitHub :

   ```sh
   git clone https://github.com/votre-utilisateur/connect-4.git

2. Accédez au répertoire du projet :

    ```sh
    cd connect-4

3. Accédez au répertoire du projet :

    ```sh
    cd connect-4

4. Exécution
    
    Pour exécuter le jeu, utilisez la commande suivante :

    ```sh
    mvn exec:java

5. Instructions de Jeu
    
    Vous serez invité à entrer les noms des deux joueurs.
    Chaque joueur choisira une couleur parmi les options disponibles.
    Le jeu commencera avec le premier joueur choisi aléatoirement.
    Les joueurs entreront alternativement le numéro de la colonne (0-6) dans laquelle ils souhaitent déposer leur pièce.
    Le jeu se termine lorsqu'un joueur aligne quatre pièces de la même couleur horizontalement, verticalement ou en diagonale, ou lorsque le plateau est plein (match nul).

6. Exemple d'exécution

    Entrez le nom du Joueur 1 :
    Sarah
    Entrez le nom du Joueur 2 :
    Kenza
    Sarah, choisissez votre couleur (RED, YELLOW, BLUE, GREEN, ORANGE, PURPLE, PINK, CYAN, MAGENTA, LIME, TEAL, BROWN, BLACK, WHITE) :
    red
    Kenza, choisissez votre couleur (RED, YELLOW, BLUE, GREEN, ORANGE, PURPLE, PINK, CYAN, MAGENTA, LIME, TEAL, BROWN, BLACK, WHITE) :
    blue

    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .

    Sarah, c'est votre tour. Choisissez une colonne (0-6):

7. Auteur

    BATAILLARD Damien
    ELMESTARI Karim
    DE MENIBUS Olivier
    BENKIRANE Kamilia

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.