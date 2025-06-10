## ♟️ Chess Game in Java (Swing + MVC)

This project aims to develop a chess game in Java with a graphical interface using Swing, structured according to the MVC (Model-View-Controller) architecture. The game will follow simplified rules — excluding castling, check, and checkmate — and will include persistence of the game state and player rankings.

## 📝 Requirements

### 📐Model
   
1. Representation of an 8x8 board with standard chess pieces.
2. Basic logic for piece movement (no need to validate all complex rules).
3. Turn control (white and black players).
4. Methods to save and load the game state from a file.
5. Store and manage player rankings (scores, wins).

### 🔍 Graphical Interface (View)

1. Implement a graphical interface using Java Swing.
2. Display the board using an 8x8 grid of buttons.
3. Show pieces with icons or Unicode symbols (e.g., ♔, ♞).
4. Capture user clicks to select source and destination squares.
5. Visual highlight for the selected square.
6. Show messages to the user (e.g., invalid move, current turn, game over).

### 🕹️ Controller

1. Handle interface events (clicks).
2. Control the movement logic by integrating View and Model.
3. Update the game state and interface after each move.
4. Switch turns between players.
5. Validate basic moves and prevent invalid actions.
6. Automatically save the state after each move.

## 🛠️ Technical Requirements

1. Language: Java 8 or higher.
2. Graphical interface: Java Swing.
3. Strict MVC architecture, separating responsibilities.
4. Code organized into packages (model, view, controller).
5. State persistence and ranking using files (serialization or text)

## 📦 Deliverables

1. Complete and well-commented source code.
2. Clear instructions for compilation and execution.
3. Generated persistence files (e.g., game.ser, ranking.json).
4. Document explaining the implemented MVC design.

## ✍️ Notes
1. It is not necessary to implement complex rules such as castling, check, or checkmate.
2. The focus is on clear structure, functional interface, and persistence.
3. The ranking can be simple, storing the player's name and number of victories.
4. Mandatory implementation: At least one user-defined interface and inheritance.
5. **Optional** => Castling, Check, Checkmate, en passant, promotion, game mode selection by time (e.g., bullet, blitz, rapid, and classical), remote game via sockets, local game against a BOT using the minimax algorithm with optimization (alpha-beta pruning). It will be accepted only if all optional implementations have been successfully executed; the bonus value is (2.0).

**( * ) Attention!! Everything must be implemented; otherwise, the bonus will not be credited!! This applies only to evaluation A1.**


