# ArchiJEEWSRestTP - Dockerized Version

## Description

Cette version de l'application ArchiJEEWSRestTP a été **complètement dockerisée**.

- Le backend est packagé dans un container Docker.
- Nginx est utilisé pour exposer l'application via un reverse proxy sur le port **8082** de l'hôte.
- `docker-compose` est utilisé pour simplifier le lancement des containers et la gestion du réseau.

---

## Usage

1. **Construire et lancer l'application avec Docker Compose :**

```bash
docker compose up -d
```


2.  **Accéder à l'application:** http://localhost:8082/
