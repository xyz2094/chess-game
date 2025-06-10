
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

1. Clone the repository:
   ```bash
   git clone https://github.com/vittordallacqua/ChessGameMVC.git
   cd ChessGameMVC
   ```

2. Compile the project:
   ```bash
   javac -d bin src/**/*.java
   ```

3. Run the game:
   ```bash
   java -cp bin Main
   ```

Or, if using an IDE (like IntelliJ or Eclipse), simply import the project as a Java Project and run the `Main` class.

## 💾 Persistence

Matches and player rankings are saved locally via object serialization. When restarting the game, you can continue where you left off or start a new game.

## 📌 TODOs

- [ ] Implement AI opponent mode
- [ ] Improve GUI with custom components
- [ ] Support special moves (castling, en passant, promotion)
- [ ] Export matches in PGN format

## 🤝 Contributions

Contributions are welcome! Feel free to open an issue or submit a pull request.

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
