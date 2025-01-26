# Moviz - Top 20 Popular Movies App

**Moviz** is an Android application built using **Jetpack Compose** that displays the top 20 popular movies right now. The app fetches movie data from **The Movie Database (TMDB) API** and presents it in a clean, responsive, and user-friendly interface. The app also supports offline functionality by caching movie data in a local **Room Database**.

Inspired by the Udemy course on [**The Complete Android 15 Course [Part 2] - Jetpack Compose**](https://www.udemy.com/course/android15-developer-course-part2/) Created by [Abbass Masri - Doc. Ali Alaeddine](https://www.udemy.com/user/mahmoud-masri-7/).

# Features
- **Top 20 Popular Movies**: Displays the current top 20 popular movies fetched from the TMDB API.

- **Offline Support**: Caches movie data locally using Room Database, allowing users to view movies even without an internet connection.

- **Responsive UI**: Built with Jetpack Compose, the app provides a smooth and responsive user experience.

- **Shimmer Effect**: A loading shimmer effect is shown while the data is being fetched.

- **Error Handling**: Displays an error message if the data fails to load.

- **Infinite Scrolling**: The app uses a `LazyVerticalGrid` to display movies in a grid layout, ensuring smooth scrolling.

- **Custom Top App Bar**: A custom top app bar with a title and subtitle that collapses and expands based on scroll behavior.

# Screenshot
<p align="center">
<img src="https://github.com/user-attachments/assets/e282ca4c-7515-427f-8903-9be50f25a3d1" width="288">
</p>

# Video
https://github.com/user-attachments/assets/e38ffc84-c6ca-4b5e-b6bb-ad26110af0a1

# Tech Stack
- **Jetpack Compose**: Modern Android UI toolkit for building native UI.

- **Retrofit**: For making network requests to the TMDB API.

- **Room Database**: For local data caching and offline support.

- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.

- **Coroutines**: For asynchronous programming and background tasks.

- **Coil**: For image loading and caching.

- **Material Design 3**: For a modern and consistent UI design.

# Architecture
The app follows the **MVVM (Model-View-ViewModel)** architecture pattern:

- **Model**: Represents the data layer, including the TMDB API and Room Database.

- **View**: The UI layer built with Jetpack Compose.

- **ViewModel**: Manages the UI-related data and interacts with the repository to fetch and cache data.

# Project Structure
```
moviz/
├── repository/            # Contains the Repository class for managing data sources
├── retrofit/              # Contains Retrofit-related classes (API service, models)
├── room/                  # Contains Room Database-related classes (DAO, entities, converters)
├── screens/               # Contains Jetpack Compose screens (MovieScreen, MovieList, MovieItem)
├── ui/                    # Contains UI-related utilities (TopAppBar, ShimmerEffect, etc.)
├── viewmodel/             # Contains ViewModel classes (MovieViewModel, MovieViewModelFactory)
├── MainActivity.kt        # Main entry point of the app
```

# Getting Started
## Prerequisites
- **Android Studio**: Ensure you have Android Studio installed (preferably the latest version).

- API Key: You need an API key from [The Movie Database (TMDB)]/(https://www.themoviedb.org). Once you have the API key, add it to your `local.properties file`:
```
API_KEY="your_api_key_here"
```

## Installation
1. Clone the repository:
```bash
git clone https://github.com/CGreenP/Moviz.git
```
2. Open the project in Android Studio.

3. Add your TMDB API key to the `local.properties` file as mentioned above.

4. Build and run the app on an emulator or physical device.

# Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

# Acknowledgments
- **The Movie Database (TMDB)**: For providing the movie data API.

- **Jetpack Compose**: For making UI development faster and more enjoyable.

- **Android Developers**: For providing excellent documentation and resources.

---
Enjoy exploring the top 20 movies with **Moviz**! 🎬🍿
