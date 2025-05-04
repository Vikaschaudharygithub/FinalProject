# Daily Task Organizer

##  Problem Solved
This program solves the problem of managing daily tasks effectively. Users can add, view, complete, and remove tasks from a to-do list. Completed tasks are moved to an array-based archive, and all data is saved between sessions using files.

## Technologies Used
- Java
- GitHub Codespaces
- Arrays & ArrayLists
- Recursion for input validation
- Exception Handling (try-catch)
- File I/O for data persistence

## Features Implemented
- Menu-driven interface
- ArrayList for current (pending) tasks
- Array for archived (completed) tasks
- Recursive methods for robust input validation
- Try-catch blocks to handle invalid input and indexing errors
- Automatic save/load of tasks on program exit/start

## How to Run
1. Clone the repository: `git clone <repo_url>`
2. Open the project in GitHub Codespaces.
3. Compile: `javac *.java`
4. Run: `java Main`
5. Follow on-screen prompts to manage your tasks.

## File Descriptions
- `Main.java`: Entry point and program orchestration
- `TaskManager.java`: Core logic for task management
- `InputValidator.java`: Recursive input validation utility
- `FileHandler.java`: File persistence utility
- `tasks.txt`: Stores pending tasks
- `completed.txt`: Stores completed tasks
