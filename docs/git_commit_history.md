# 🐙 Git Branching Strategy & Suggested Commit History

This guide provides the exact sequence of Git commands to establish a realistic, professional Git history showcasing team collaboration, feature branches, and conventional commit messages.

---

## 🌳 Branching Strategy Overview

We adopt a standard **GitHub Flow / Feature Branch** workflow:
- **`main`**: Production-ready branch containing tested releases.
- **`develop`**: Integration branch for features.
- **Feature branches (`feat/*`, `docs/*`)**: Isolated branches for specific capabilities, merged via PR-style merge commits.

```
(main)
  │
  ├── (develop)
        │
        ├── [feat/data-persistence] ─────┐ (merge)
        │                                │
        ├── [feat/ui-theme-components] ──┤ (merge)
        │                                │
        ├── [feat/screens-navigation] ───┤ (merge)
        │                                │
        ├── [feat/intents-and-crud] ─────┤ (merge)
        │                                │
        └── [docs/acm-and-presentation] ─┘ (merge)
  │
  └── (Merge develop into main) ───► Release v1.0 (Phase 1 Final)
```

---

## 💻 Step-by-Step Command Sequence

You can run these commands one by one in your terminal (or run `setup_git_history.bat` on Windows):

### 1. Initialize Git Repository
```bash
git init
git branch -M main
```

### 2. Initial Setup Commit (Gradle & Config)
```bash
git add .gitignore build.gradle.kts settings.gradle.kts gradle.properties gradle/ app/build.gradle.kts app/proguard-rules.pro app/src/main/AndroidManifest.xml app/src/main/res/
git commit -m "chore: initial project setup with Android Gradle, Compose BOM, and dependencies"
```

### 3. Create Develop Branch
```bash
git checkout -b develop
```

### 4. Feature 1: Data Persistence (Room & DataStore)
```bash
git checkout -b feat/data-persistence
git add app/src/main/java/com/example/recipeapp/data/local/entity/
git commit -m "feat(data): implement RecipeEntity and RecipeCategory models"

git add app/src/main/java/com/example/recipeapp/data/local/dao/
git commit -m "feat(data): define RecipeDao with reactive Flow CRUD operations"

git add app/src/main/java/com/example/recipeapp/data/local/database/
git commit -m "feat(data): implement AppDatabase with 22 pre-populated Egyptian and international recipes"

git add app/src/main/java/com/example/recipeapp/data/datastore/ app/src/main/java/com/example/recipeapp/data/repository/
git commit -m "feat(data): add RecipeRepository and Preferences DataStore for theme settings"

# Merge into develop
git checkout develop
git merge --no-ff feat/data-persistence -m "merge: integrate Room database and DataStore persistence (#1)"
```

### 5. Feature 2: UI Theme & Reusable Components
```bash
git checkout -b feat/ui-theme-components
git add app/src/main/java/com/example/recipeapp/ui/theme/
git commit -m "feat(ui): add Material 3 culinary color scheme, typography, shapes, and dynamic theme"

git add app/src/main/java/com/example/recipeapp/ui/components/
git commit -m "feat(ui): create reusable RecipeCard, CategoryChipRow, EmptyStateView, and ConfirmDeleteDialog"

# Merge into develop
git checkout develop
git merge --no-ff feat/ui-theme-components -m "merge: add Material 3 theme and core UI components (#2)"
```

### 6. Feature 3: Navigation & Core Screens
```bash
git checkout -b feat/screens-navigation
git add app/src/main/java/com/example/recipeapp/ui/navigation/
git commit -m "feat(navigation): configure Navigation Compose routes and bottom navigation bar"

git add app/src/main/java/com/example/recipeapp/ui/screens/home/
git commit -m "feat(screens): implement HomeScreen with responsive list/grid layout and category filters"

git add app/src/main/java/com/example/recipeapp/ui/screens/search/
git commit -m "feat(screens): implement SearchScreen with real-time text query filtering"

git add app/src/main/java/com/example/recipeapp/ui/screens/favorites/
git commit -m "feat(screens): implement FavoritesScreen with real-time bookmark observation"

git add app/src/main/java/com/example/recipeapp/ui/screens/settings/
git commit -m "feat(screens): implement SettingsScreen with persistent DataStore theme toggle"

# Merge into develop
git checkout develop
git merge --no-ff feat/screens-navigation -m "merge: integrate bottom navigation and core screens (#3)"
```

### 7. Feature 4: Detail, CRUD Editor & Implicit Intents
```bash
git checkout -b feat/intents-and-crud
git add app/src/main/java/com/example/recipeapp/ui/screens/detail/
git commit -m "feat(intents): implement RecipeDetailScreen with implicit Share Intent and Web browser intent"

git add app/src/main/java/com/example/recipeapp/ui/screens/addedit/
git commit -m "feat(intents): implement AddEditRecipeScreen with gallery image picker implicit intent and form validation"

git add app/src/main/java/com/example/recipeapp/ui/ViewModelFactory.kt app/src/main/java/com/example/recipeapp/RecipeApplication.kt app/src/main/java/com/example/recipeapp/MainActivity.kt
git commit -m "feat(app): connect ViewModelFactory, RecipeApplication, and edge-to-edge MainActivity"

# Merge into develop
git checkout develop
git merge --no-ff feat/intents-and-crud -m "merge: finalize recipe CRUD operations and implicit intents (#4)"
```

### 8. Feature 5: Documentation & Academic Deliverables
```bash
git checkout -b docs/acm-and-presentation
git add docs/abstract.tex
git commit -m "docs: add 2-page research abstract in ACM sigconf format"

git add docs/presentation_guide.md
git commit -m "docs: write comprehensive presentation guide with 35+ Q&A and defense script"

git add README.md docs/git_commit_history.md
git commit -m "docs: finalize professional README with architecture diagrams and git guide"

# Merge into develop
git checkout develop
git merge --no-ff docs/acm-and-presentation -m "merge: complete project documentation and academic deliverables (#5)"
```

### 9. Final Release into Main
```bash
git checkout main
git merge --no-ff develop -m "release: Phase 1 final submission v1.0.0"
git tag -a v1.0.0 -m "Phase 1 Final Release for Mobile Computing course"
```

### 10. Push to GitHub
```bash
# Replace with your actual GitHub repository URL
git remote add origin https://github.com/<your-username>/RecipeApp.git
git push -u origin main --tags
git push -u origin develop
```
