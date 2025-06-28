Ce projet est une API de gestion de commandes développée avec Spring Boot, GraphQL, JPA/Hibernate et MySQL. Il permet de gérer les utilisateurs, les produits, les catégories, les commandes et leurs détails via une interface GraphQL.

🔧 Fonctionnalités
🔍 Requêtes GraphQL pour :

Récupérer la liste des utilisateurs, produits, catégories, commandes, et orderItems.

Récupérer un élément spécifique par son identifiant.

✍️ Mutations GraphQL pour :

Créer un utilisateur (createUser)

Créer une catégorie (createCategory)

Ajouter un produit (createProduct)

Créer une commande associée à un utilisateur et une liste de produits (createOrder)

Ajouter un orderItem (quantité, produit, commande) (createOrderItem)

🛠 Structure relationnelle :

User ↔ Order (OneToMany)

Order ↔ OrderItem (OneToMany)

OrderItem ↔ Product (ManyToOne)

Product ↔ Category (ManyToOne)

🧪 Outils utilisés
Spring Boot 3+

Spring GraphQL

JPA/Hibernate

MySQL

Altair GraphQL Client (pour le test des requêtes)

Lombok

Jakarta Persistence API
