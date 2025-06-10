package model;

import java.io.Serializable;

public class Board implements Serializable {
    private ChessPiece[][] board;
    private boolean whiteTurn;
    private boolean gameOver;
    private String winner;

    public Board() {
        board = new ChessPiece[8][8];
        initializeBoard();
        whiteTurn = true;
        gameOver = false;
    }

    private void initializeBoard() {
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(true); 
            board[1][col] = new Pawn(false);
        }

        board[7][0] = new Rook(true);
        board[7][7] = new Rook(true);
        board[0][0] = new Rook(false);
        board[0][7] = new Rook(false);

        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);

        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);

        board[7][3] = new Queen(true);
        board[0][3] = new Queen(false);

        board[7][4] = new King(true);
        board[0][4] = new King(false);
    }

    public ChessPiece getPiece(int row, int intcol) {
        if (row >= 0 && row < 8 && intcol >= 0 && intcol < 8) {
            return board[row][intcol];
        }
        return null;
    }

    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        if (gameOver)
            return false;

        ChessPiece piece = board[fromRow][fromCol];
        if (piece == null || piece.isWhite() != whiteTurn)
            return false;

        ChessPiece targetPiece = board[toRow][toCol];
        if (targetPiece != null && targetPiece.isWhite() == piece.isWhite()) {
            return false;
        }

        if (!piece.isValidMove(fromRow, fromCol, toRow, toCol, board))
            return false;

        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = null;

        if (targetPiece instanceof King) {
            gameOver = true;
            winner = piece.isWhite() ? "Branco" : "Preto";
        } else {
            whiteTurn = !whiteTurn;
        }

        PersistenceManager.saveGame(this, "game.ser");
        return true;
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }

    public void loadGameState(Board loadedBoard) {
        this.board = loadedBoard.getBoard();
        this.whiteTurn = loadedBoard.isWhiteTurn();
        this.gameOver = loadedBoard.isGameOver();
        this.winner = loadedBoard.getWinner();
    }
}