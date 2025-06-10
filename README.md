
# ♟️Chess Game in Java (MVC + Swing) 

A chess game developed in Java using the Swing graphical interface and the MVC (Model-View-Controller) architectural pattern. The project includes full gameplay functionality, a player ranking system, and match state persistence.

## 🛠️ Technologies Used

- **Java 17+**
- **Swing** — for GUI development
- **MVC Architecture** — separates logic, interface, and user input handling
- **Serialization** — for saving and loading game state
- **Java Collections** — for managing player rankings and match history

## 🎮 Features

- Local two-player mode
- Interactive graphical chessboard
- Move validation based on official chess rules
- Check and checkmate detection
- Save and load games
- Player ranking system based on victories
- Match reset and ranking clear functionality

## 📁 Project Structure

```
ChessGameMVC/
├── src/
│   ├── model/         # Game logic and pieces
│   ├── view/          # Swing-based GUI
│   ├── controller/    # Handles user actions
│   ├── persistence/   # Serialization and data files
│   └── Main.java      # Entry point
├── resources/         # Icons and visual assets
└── README.md
```

## 🚀 How to Run

### Using Command Line

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/vittordallacqua/ChessGameMVC.git](https://github.com/vittordallacqua/ChessGameMVC.git)
    cd ChessGameMVC
    ```
   
2.  **Compile the project:**
    ```bash
    javac -d bin src/**/*.java
    ```
   
3.  **Run the game:**
    ```bash
    java -cp bin Main
    ```
   

### Using Visual Studio Code

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/vittordallacqua/ChessGameMVC.git](https://github.com/vittordallacqua/ChessGameMVC.git)
    cd ChessGameMVC
    ```
2.  **Open the project in VS Code:**
    * Open VS Code.
    * Go to `File > Open Folder...` and select the `ChessGameMVC` directory.
3.  **Ensure Java Extensions are installed:**
    * Make sure you have the "Extension Pack for Java" by Microsoft installed. This includes Language Support for Java™, Debugger for Java, Maven for Java, Project Manager for Java, and Test Runner for Java.
4.  **Configure Project Settings (if necessary):**
    * The `.vscode/settings.json` file is already configured to set `src` as the source path and `bin` as the output path.
    ```json
    {
        "java.project.sourcePaths": ["src"],
        "java.project.outputPath": "bin",
        "java.project.referencedLibraries": [
            "lib/**/*.jar"
        ]
    }
    ```
   
    * VS Code's Project Manager for Java should automatically recognize the project structure.
5.  **Run the `Main` class:**
    * Navigate to `src/Main.java` in the VS Code Explorer.
    * Right-click on `Main.java` and select `Run Java` or click the "Run" button that appears above the `main` method within the editor.
    * Alternatively, you can open the `Main.java` file and press `F5` to start debugging, or use the "Run" view in the sidebar.

## 💾 Persistence

Matches and player rankings are saved locally via object serialization. When restarting the game, you can continue where you left off or start a new game.

## 🤝 Contributions

Contributions are welcome! Feel free to open an issue or submit a pull request.

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
