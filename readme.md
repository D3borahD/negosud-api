# Pré-requis :

- JDK ^19
- NodeJS >= 16.10.0

# Installation :

- ```git clone {repo_url} && cd NegoSud-Shop```
- ```./mvnw clean install && ./mvnw spring-boot:run```
- ```cd src/main/ui && yarn && yarn dev```

# Structure :

- ```src/main/java``` : code Java
- ```src/main/java/{package}/controllers``` : controllers & routes
- ```src/main/resources``` : ressources Java / Front compilé
- ```src/main/ui``` : code Front (SPA VueJS)

# Fonctionnement : 

SpringBoot charge le fichier index.html de ```src/main/resources/static``` qui va charger le fichier ```main.ts``` qui va charger le fichier ```App.vue``` qui va charger la SPA VueJS.  
Possibilité de faire des requêtes vers l'API REST SpringBoot depuis la SPA VueJS.