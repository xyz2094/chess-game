// ChessGame/src/model/Bishop.java
package model;

public class Bishop extends ChessPiece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        if (Math.abs(toRow - fromRow) == Math.abs(toCol - fromCol)) {
            if (!hasObstacle(fromRow, fromCol, toRow, toCol, board)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasObstacle(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);
        int r = fromRow + rowStep, c = fromCol + colStep;

        while (r != toRow && c != toCol) {
            if (board[r][c] != null)
                return true;
            r += rowStep;
            c += colStep;
        }
        return false;
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-bishop.png" : "/resources/images/black-bishop.png";
    }
}