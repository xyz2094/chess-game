// ChessGame/src/model/Knight.java
package model;

public class Knight extends ChessPiece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        // Movimento em "L": duas casas em uma direção e uma na perpendicular
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-knight.png" : "/resources/images/black-knight.png";
    }
}