<img src="https://i.goopics.net/ip4368.png" alt="drawing" width="300" heigth="300"/> 

Projet Bibliothèque
==============================================================

Description
--------------------------------------------------------------

Tout d'abord, cette application a été réalisé en binôme dans le cadre de d'un projet de base de données du deuxième semestre de DUT Informatique à l'IUT de Vélizy.
Le but de ce projet a été de développer une application servant d’intermédiaire entre des utilisateurs (bibliothécaire et étudiants) et une bibliothèque dont les données sont stockées dans une base de données. Ce projet est codé en langage Java et utilise un driver JDBC pour accéder à une base de données gérée à l'aide du PL/SQL.

Visuels
--------------------------------------------------------------

Voici des captures d'écran de l'application.

![image_connexion][connexion]
![image_recherche][recherche]
![image_reservation][reservation]
![image_ajout_livre][ajout_livre]
![image_pret_livre][pret_livre]
![image_rendu_livre][rendu_livre]
![image_retard][retard]
![image_gestion_comptes][gestion_comptes]

Installation
--------------------------------------------------------------

Voici les différentes étapes nécessaires à l'utilisation de l'application. Je tiens à préciser que pour exécuter le projet, il est nécessaire d'avoir installé Java et JDK, et d'avoir un gestionnaire de bases de données. De plus, le projet est exécutable sur n'importe quel système d'exploitation. 

##### Première étape

Vous devez télécharger le dossier de l'application. Pour cela cliquer sur le logo Github ci-dessous.

[<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/2048px-Octicons-mark-github.svg.png" alt="drawing" width="40" heigth="40"/>](https://github.com/arthurpellegrini/library)

Ensuite aller sur le bouton vert "code" et sélectionner "download zip".

##### Deuxième étape

![image1][importation_csv]

Vous devez reconstituer la base de données à l'aide des fichiers contenus dans le dossier PL/SQL. 
Puis modifier les identifiants de connexion dans le code, dans le constructeur de la classe Jdbc. 
Enfin, il faudra ajouter le driver JDBC, il se trouve dans le dossier lib, et il se nomme classe12.jar. Pour ce faire, il faut l'ajouter au "BuildPath" de votre projet.

##### Troisième étape

Il faudra exécuter l'application. Pour vous éviter de chercher, je vous précise que la méthode main se trouve dans le fichier FenetreConnexion.java. Pour cela, il faut compiler puis exécuter le projet. Si tout s'est bien déroulé, l'application doit s'être lancé, il ne vous reste plus qu'à tester notre application !

Usage
--------------------------------------------------------------

Quand vous lancer l'application, vous devez vous connecter à un compte présent dans la base de données. Ensuite, vous avez accès à différentes fonctionnalités suivant si vous vous êtes connectés avec un compte étudiant ou bibliothécaire. 

La seule fonctionnalité en commun avec ces deux types de compte est la recherche d'un livre suivant des critères de recherche.
Un compte d'étudiant peut aussi réserver un livre. 
Un compte bibliothécaire peut accepter une réservation de livre, et passer une réservation en emprunt, il peut aussi inscrire dans la base de données le rendu d'un livre. De plus, un compte bibliothécaire permet aussi l'affichage des emprunts qui ne respectent pas la date limite, l'ajout de nouveaux livres, et la gestion des comptes étudiants.

Support
--------------------------------------------------------------

Si vous avez une question ou un problème, n'hésitez pas à nous contacter à l'adresse mail suivante : arthur.pellegrini2002@gmail.com

Roadmap
--------------------------------------------------------------

* Fixer les bugs connus
* Empêcher l'emprunt d'un livre déjà emprunté
* Fixer le nombre d'exemplaires pour chaque livre
* Améliorer l'interface de l'application


Contributions
--------------------------------------------------------------

Nous sommes ouverts à tout type de contributions. Les personnes qui le souhaitent peuvent proposer des changements par l'intermédiaire de Github en proposant des "commits".

Authors and thanks
--------------------------------------------------------------

Les auteurs de ce projet sont les suivants : 

* GACHE Antoine 
* PELLEGRINI Arthur

Nous remercions aussi les personnes suivantes de nous avoir aidées lors du développement de cette application : 

* DELORME Nathan
* LENFANTIN Alexandre
* ZEITOUNI Karine

Project status 
--------------------------------------------------------------

Le développement de ce projet a été stoppé après la transmission de celui-ci au jury de notre Université. Mais il est possible que l'application soit amélioré par la suite.

[//]: # (Lien de référence utilisé dans le corps du Markdown)
[importation_csv]: https://i.goopics.net/tt83jo.png
[connexion]: https://i.goopics.net/xtb3dv.png
[recherche]: https://i.goopics.net/2l2lu1.png
[reservation]: https://i.goopics.net/ccb7zp.png
[ajout_livre]: https://i.goopics.net/jfs74v.png
[pret_livre]: https://i.goopics.net/do3i5s.png
[rendu_livre]: https://i.goopics.net/eix6au.png
[retard]: https://i.goopics.net/0m8mvy.png
[gestion_comptes]: https://i.goopics.net/vvo51b.png
