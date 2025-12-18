# ☕ Coffee Recipes

**Coffee Recipes** is an Android application that allows users to browse coffee recipes by category, view detailed preparation steps, and manage their favorite recipes.  
The app focuses on clean UI, clear user feedback, and a warm coffee-inspired design.

---

![Recipes List](screenshots/recipes_list.png)


## 📱 Features

- Browse coffee recipes by categories (Latte, Espresso, etc.)
- View detailed recipe instructions and ingredients
- Add and remove recipes from Favorites ⭐
- Visual feedback with animations and Snackbars
- Undo-friendly user experience
- History of recently viewed recipes
- Clean, coffee-themed UI (Latte & Espresso palette)

---

## ⭐ Favorites UX

- **Gray star** — recipe is not in favorites  
- **Caramel-colored star** — recipe is added to favorites  

Snackbar feedback:
- *“Added to favorites ☕”*
- *“Removed from favorites”*

This ensures users always understand the current state of their action.

---

## 🎨 UI & Design Decisions

- Latte / Espresso color palette for a warm and premium feel
- Card-based layout for better readability
- Clear visual hierarchy on the detail screen
- Button placement inside the content area for natural navigation
- Subtle animations to enhance user experience

---

## 🧠 Architecture Overview

- Fragments with **Navigation Component**
- **RecyclerView** for dynamic lists
- **Repository pattern** for managing recipe data
- **SharedPreferences** for Favorites and History
- **Material Components** (Snackbar, ripple effects)

---

## 🛠 Tech Stack

- **Kotlin**
- **Android SDK**
- **Navigation Component**
- **RecyclerView**
- **Material Design**
- **SharedPreferences**

---

## 📸 Screenshots

> *(Add screenshots here if required by the assignment)*

- Categories screen  
- Recipes list  
- Recipe detail screen  
- Favorites screen  
- Snackbar feedback  

---

## ✅ Learning Outcomes

This project demonstrates:

- Android UI best practices
- State-based UI feedback
- Clean code structure
- User-centered UX decisions
- Material Design principles

---

## 🚀 Future Improvements

- Search recipes by name
- Dark Espresso mode
- Share recipes with friends
- Cloud sync for favorites

---

## 👩‍💻 Author

**Irina S.**  
Android Application Development  
2025
