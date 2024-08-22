# VANILLA  

Vanilla est un project de test technique sous forme d'une application monolithque incluant :  
- Back-end : API Rest en Java / Spring Boot
- Front-end : Application TypeScript / Angular  

On se place dans le contexte de la gestion d'une flotte virtuelle d'objet IOT composée de :
- Capteur (Sensor) de different modèle (Model)
- Relais (Relay)

## TODO

1) En tant qu'utilisateur, je souhaite pouvoir consulter dans le dashboard le constructeur de chaque capteur : 
   - Cette information est présente dans la table de l'entitée Model (clé primaire id, colonne constructor). La table 
   de l'entitée Sensor référence le modèle de capteur via la colonne model_id. Corrigez le back-end afin de récupérer 
   le constructeur dans la réponse API
   - Modifiez le front-end pour afficher l'information sur la page dashboard.
2) En tant qu'utilisateur, je souhaite pouvoir superviser le niveau de batterie : 
   - Le pourcentage de batterie des capteurs  est toujours de 0%. Corrigez le back-end pour implémenter le bon calcul :  
   PourcentageBattery = Voltage du capteur / Voltage Max de ce modèle de capteur * 100
   - Retournez la liste des capteurs triée par ordre de pourcentage de batterie croissant en ajoutant au préalable un 
   test unitaire pour vérifier le tri.
3) La fonctionnalité de désactivation des appareils sous le seuil de batterie limite n'est pas fonctionelle :
   - Identifiez et corrigez la raison pour laquelle l'état des capteurs n'est pas mis à jour
   - Le seuil de batterie est fixé en dur dans le code, rendez le configurable via le fichier application.properties
   - Etendre cette logique pour traiter à la fois les capteurs et les relais (on pourra exploiter les similaritées des 
   objets via le polymorphisme)
4) Dans la partie front-end, sur la page dashboard, à coté des titres Capteurs et Relais, indiquez pour chacun le nombre
d'éléments actifs (state = true) sur le nombre total en se basant sur les données déjà récupérées de l'API. (Pas d'appel 
supplémentaire au Back-end)   
Exemple : Capteurs (2 / 3) 
5) La méthode update du service DeviceService est très lente. Optimisez cette méthode en parallélisant les opérations  
selon la méthode de votre choix.

 
## Usage
### Install
> ./mvnw clean install -DskipTests

### Development
> cd service  
> ../mvnw spring-boot:run
> 
> cd web  
> npm run start

API Back-end : [http://localhost:8080](http://localhost:8080)  
Front-end :  [http://localhost:4200](http://localhost:4200)

### Crédit
Basé sur le projet de [Tomasz Wojewódka](https://github.com/tomaszwojewodka)