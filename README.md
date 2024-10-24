
# Shopping Manager App

**Shopping Manager** is an Android application designed to help users manage and track their shopping lists efficiently. The app implements essential features like user authentication and product management, making it easy for users to keep their shopping organized.

## Components Overview

- **LoginActivity**: Handles user authentication. Users can log in to their accounts using their credentials.

- **RegisterActivity**: Allows new users to create an account by registering their details.

- **MainActivity**: The entry point of the application, serving as the launching page when the app is opened.

- **MainPageActivity**: The main dashboard where users can navigate through various features like viewing and managing shopping items.

- **Product**: A model class that represents the items a user can manage in their shopping list, including attributes like product name, price, and quantity.

- **ProductAdapter**: This adapter is used for managing the display of products in a **RecyclerView**, which implements a pattern for efficiently displaying large sets of data. This is part of the RecyclerView pattern learned in class.

- **User**: A model class representing user data such as username, email, and account-related details.

## Key Features

- **RecyclerView Pattern**: The app efficiently displays shopping items using the RecyclerView pattern, allowing for smooth scrolling and an enhanced user experience.
  
- **Authentication**: The app includes login and registration functionality, implementing basic authentication features as taught in class.
