
// ChessGame/src/Main.java
import model.Board;
import view.ChessView;
import controller.ChessController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Board board = new Board(); // Create board instance
            ChessView view = new ChessView(); // Create view instance
            view.setVisible(true); // Make view visible
            new ChessController(board, view); // Pass both to controller
        });
    }
}