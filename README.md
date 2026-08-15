# RecipeFinder

A full-stack web app that lets you type in whatever ingredients you have and find recipes you can make with them. Uses the Spoonacular API to fetch recipes and cooking instructions.

**Live demo:** https://recipefinder-i02w.onrender.com

---

## Features

- Add ingredients one at a time with Enter, shown as tags you can remove
- Backspace removes the last ingredient
- Recipes ranked by fewest missing ingredients so the closest matches appear first
- Recipe cards show ingredient match ratio and cook time
- Click a card to see the full ingredient list and step-by-step instructions
- Backend proxies all API calls so the API key stays on the server

---

## Tech Stack

- **Java 17 / Spring Boot** for the backend REST API
- **Vanilla HTML/CSS/JS** for the frontend (served as a static file by Spring Boot)
- **Spoonacular API** for recipe data (complexSearch endpoint with ingredient matching)
- **Maven** for build and dependency management
- **Docker** for deployment

---

## How it works

The frontend sends requests to `/api/recipes?ingredients=chicken,rice` which the Spring Boot backend proxies to the Spoonacular API. This keeps the API key server-side. Results are sorted client-side by fewest missing ingredients. Clicking a recipe card fetches `/api/recipes/{id}` for the full details (ingredients + steps) and shows them in a modal.

---

## Run locally

1. Clone the repo
2. Get a free API key from https://spoonacular.com/food-api
3. Set the environment variable: `export SPOONACULAR_API_KEY=your_key_here`
4. Build and run: `./mvnw spring-boot:run`
5. Open http://localhost:8080
