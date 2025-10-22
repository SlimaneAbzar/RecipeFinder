# RecipeFinder

A full-stack web application that lets users enter ingredients and find recipes containing them. It uses the Spoonacular API to fetch recipes and recipe details.

---

## Project Overview

### Backend (Spring Boot)

- Built with **Spring Boot**.
- Uses REST API endpoints to:
  - Search recipes by ingredients.
  - Get recipe information by recipe ID.
- Integrates with Spoonacular API(https://spoonacular.com/food-api) for recipe data.
- Sorts recipes by prioritising those with the most provided ingredients and requiring the fewest extra ingredients.
- Handles CORS for frontend-backend communication.

### Frontend (Vanilla HTML/CSS/JS)

- User inputs comma-separated ingredients.
- Fetches recipe data from the backend API.
- Displays recipe cards with images and titles.
- Clicking a recipe card opens and shows ingredients and cooking steps.

---


## How to Set Up and Run

### Prerequisites

- Java 17+ installed  
- Maven installed   
- Spoonacular API key from https://spoonacular.com/food-api

---

### Setup

1. Clone the repository
2. Configure your API key: In src/main/resources/application.properties add: spoonacular.api.key=(your key)
3. Build and run Spring Boot: 1 - mvn clean install 2 -  mvn spring-boot:run
4. Open http://localhost:8080 on your browser.
5. You're now ready to go

