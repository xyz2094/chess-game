import model.Board;
import view.ChessView;
import controller.ChessController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Board board = new Board(); 
            ChessView view = new ChessView(); 
            view.setVisible(true); 
            new ChessController(board, view);
        });
    }
}