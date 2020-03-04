# PSI - API 

L’API qui sert de lien entre les données en base et le front-end a été développée en langage Java grâce au framework Spring. Nous avons utilisé les modules Spring initialzr fournis par Spring afin de partir d’une base fonctionnelle pour créer notre API REST

# Prérequis

IDE : Intellij de preference
- JDK 1.8+
- Maven 3.2


## Configuration du projet

Vous pouvez vous situer dans le reperoire de votre choix et ensuite vous faite : 

```
git clone https://github.com/Kadjoassohoun/PSI.git

```
configuration dans le fichier application.properties

### Installation de toutes les dépendences

Pour compiler le code source en un jar exécutable il faut utilise la commande suivante à la racine du projet
```
mvn install ou le faire manuellement dans l'IDE  
```
### Lancement du projet

Pour executer le projet dans le background:

Lancer le run sur la class ApiApplication

L’API est consommable sur le port 3000. La documentation générée avec Swagger est disponible à l’URL suivante : ​http://[ip]:8080/swagger-ui.html​. Elle contient la liste des contrôleurs et de leurs routes, ainsi que les différents modèles métier

### Auteurs

- Kadjo ASSOHOUN
- Yanis NAIT CHERIF
- Sami BOULHAZAIZ
- Soukaina ASLIMI

