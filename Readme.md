# GestionEtablissement

## Release V4
###Version web de l'app

####Spécification
Ce projet est la version web de l'application swing de gestion d'établissement scolaire. 
Toutes les fonctionnalités et la robustesse de l'application swing sont retrouvés dans cette version web (JSP)

####Librairies css et javascript utilisés : 
* Boostrap 5 beta 3 (La version stable de bootstrap 5 est sortie très récemment la modification n'a pas été apporté au projet à ce jour)
* AnimateCSS - Pour la création simplifier des animations
* Google font - Intégration de police 
* ChartJS - Pour la génération des graphiques 

####Attention !

Pour le moment suite à une soucis de livraison, il faut lancer l'app à partir d'intelij

####Installation : 
* Dézipper le fichier GestionEtablissement.zip
* Ouvrir le projet GestionEtablissement dans InteliJ
* (Optionnel) - Configurer le projet en temps que projet maven (si InteliJ ne le reconnait pas par défaut)
* Créer une configuration tomcat pour run le projet dans InteliJ

  
    1.Cliquez sur 'edit configuration'
  
    2.'Add new configuration'
  
    3.'Maven'
  
    4.Dans 'directory' choisir la couche présentation (exemple : C:/Users/promo/Desktop/Java/GestionEtablissement/GestionEtablissement/GestionEtablissement-presentation)
    
    5.Dans command line : 'clean package tomcat7:run'
  

* Il ne reste plus qu'à run le projet, votre navigateur par défaut vous affiche la page de connection de l'app

####Connexion :
* Login : root
* Mot de passe : root

####Attention !
La base de donnée est installé sur un serveur distant (gratuit) pour facilité le livraison, ce qui implique un ralentissement lors de l'affichage des pages de l'app


## Release V3
* Possibilité de renseigner la moyenne générale d'un étudiant,
* Possibilité d'afficher la moyenne des étudiants sous forme d'histogramme et camembert

## Release V2
Amélioration de la gestion des erreurs

## Release V1
Amélioration de la robustesse

## Release V0
Création du projet 

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




