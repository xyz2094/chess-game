// ChessGame/src/model/King.java
package model;

public class King extends ChessPiece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        return rowDiff <= 1 && colDiff <= 1; // O rei se move uma casa em qualquer direção
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-king.png" : "/resources/images/black-king.png";
    }
}