## Faire fonctionner tous les tests
Pré-requis : Avoir Maven

Télécharger le projet en format zip depuis Github
Extraire le fichier zip
Ouvrir l’invit de commande Windows et se situer dans le projet.
Effectuer la commande “cd GestionEtablissement” pour se rendre dans le dossier GestionEtablissement
Éxecuter la commande “mvn test” pour effectuer tous les tests de l’appli

## Exécuter les tests de la couche service
Depuis le dossier GestionEtablissement, effectuer la commande “ cd GestionEtablissement-service” pour se rendre dans le dossier GestionEtablissement-service
Éxecuter la commande “mvn test” pour effectuer tous les tests de la partie service de l’application



# GestionEtablissement

## Fonctionalités
Ce logiciel permet de gérer un etablissement scolaire. Il est actuellement possible de :

* Gérer les cours de l'école;
* Gérer les étudiants;
* Associer un cours à un étudiant;
* Accéder à la liste des étudiants (pour le directeur uniquement)

## Installation

Pré-requis: avoir installé Java en local sur son ordinateur

* Aller dans le projet Github : https://github.com/DaviJam/GestionEtablissement.
* Cliquer sur le bouton vert "code" puis télécharger le fichier zip.
* Dans Windows extraire le fichier zip.
* Se rendre dans le dossier "GestionEtablissement".
* Double-cliquer le fichier GestionEtablissement.jar.
* L'application s'ouvre. 

Deux choix sont alors possibles.
* Accéder à l'application avec le compte Directeur :
   > Identifiant : e.chaumont@ensup.eu
    <br/>Mot de passe : e.chaumont
* Accéder à l'application avec le compte Responsable :
   > Identifiant : m.demaison@ensup.eu
    <br/>Mot de passe : m.demaison
    
## Localisation du répertoire des Logs 
* Le répertoire des logs est situé dans le même répertoire que le .jar.

## Release V3
* Possibilité de renseigner la moyenne générale d'un étudiant,
* Possibilité d'afficher la moyenne des étudiants sous forme d'histogramme et camembert

## Release V2
Amélioration de la gestion des erreurs

## Release V1
Amélioration de la robustesse

## Release V0
Création du projet 

## Convention de nommage
1. <b/>Package:</b>
    <br/>Utiliser la convention <u/>dotcase</u>. 
    <br/>Examples: 
    * com.sun.eng
    * com.apple.quicktime.v2
    * edu.cmu.cs.bovik.cheese
    <br/>
2. <b/>Attribut:</b>
    <br/>Utiliser la convention <u/>camelCase</u>.
    <br/>Examples:
    * int     iDea;
    * char     n;
    * float    myWidth;
3. <b/>Méthode:</b> 
    <br/>Utiliser la convention <u/>camelCase</u>.
    <br/>Examples:
    * run();
    * runFast();
    * getBackground();
4. <b/>Class:</b>
    <br/>Utiliser la convention <u/>PascalCase</u>.
    <br/>Examples:
    * class Raster;
    * class ImageSprite;
5. <b/>Interface:</b>
    <br/>Utiliser la convention <u/>IPascalCase</u>.
    <br/>Examples:
    * interface IRasterDelegate;
    * interface IStoring;




