// ChessGame/src/model/ChessPiece.java
package model;

import java.io.Serializable;

public abstract class ChessPiece implements Serializable {
    protected boolean white;

    public ChessPiece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    // Removendo getSymbol()
    // public abstract String getSymbol();

    // Novo método para obter o caminho da imagem da peça
    public abstract String getImagePath();

    // Método para validar movimentos básicos de cada peça
    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board);
}