// ChessGame/src/model/Pawn.java
package model;

public class Pawn extends ChessPiece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int direction = white ? -1 : 1; // Brancos sobem, pretos descem

        // Movimento básico: uma casa à frente
        if (fromCol == toCol && toRow - fromRow == direction) {
            return board[toRow][toCol] == null; // Deve ser um quadrado vazio
        }

        // Movimento inicial de duas casas à frente
        if (fromCol == toCol && (white && fromRow == 6 || !white && fromRow == 1) && toRow - fromRow == 2 * direction) {
            // O caminho deve estar livre nas duas casas
            return board[toRow][toCol] == null && board[fromRow + direction][fromCol] == null;
        }

        // Captura diagonal
        if (Math.abs(toCol - fromCol) == 1 && toRow - fromRow == direction) {
            ChessPiece targetPiece = board[toRow][toCol];
            return targetPiece != null && targetPiece.isWhite() != this.isWhite(); // Deve capturar uma peça do oponente
        }

        return false;
    }

    @Override
    public String getImagePath() {
        return white ? "/resources/images/white-pawn.png" : "/resources/images/black-pawn.png";
    }
}