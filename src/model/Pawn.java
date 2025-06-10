package model;

public class Pawn extends ChessPiece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int direction = white ? -1 : 1;

        if (fromCol == toCol && toRow - fromRow == direction) {
            return board[toRow][toCol] == null;
        }

        if (fromCol == toCol && (white && fromRow == 6 || !white && fromRow == 1) && toRow - fromRow == 2 * direction) {
            return board[toRow][toCol] == null && board[fromRow + direction][fromCol] == null;
        }

        if (Math.abs(toCol - fromCol) == 1 && toRow - fromRow == direction) {
            ChessPiece targetPiece = board[toRow][toCol];
            return targetPiece != null && targetPiece.isWhite() != this.isWhite();
        }

        return false;
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-pawn.png" : "/resources/images/black-pawn.png";
    }
}