package controller;

import model.Board;
import view.ChessView;
import model.PersistenceManager;
import model.Ranking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessController {
    private Board board;
    private ChessView view;
    private Ranking ranking;
    private int selectedRow = -1, selectedCol = -1;
    private final String GAME_FILE = "game.ser";
    private final String RANKING_FILE = "ranking.ser"; 

    public ChessController(Board board, ChessView view) {
        this.board = board;
        this.view = view;
        this.ranking = PersistenceManager.loadRanking(RANKING_FILE);
        if (this.ranking == null) {
            this.ranking = new Ranking();
        }
        initController();
        view.updateBoard(this.board);
    }

    private void initController() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int row = i, col = j;
                view.addButtonListener(i, j, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleClick(row, col);
                    }
                });
            }
        }

        view.addNewGameListener(e -> newGame());
        view.addLoadGameListener(e -> loadGame());
        view.addShowRankingListener(e -> showRanking());
    }

    private void handleClick(int row, int col) {
        if (board.isGameOver()) {
            view.showMessage("O jogo acabou! Vencedor: " + board.getWinner());
            return;
        }

        if (selectedRow == -1) {
            if (board.getBoard()[row][col] != null && board.getBoard()[row][col].isWhite() == board.isWhiteTurn()) {
                selectedRow = row;
                selectedCol = col;
                view.highlightSquare(selectedRow, selectedCol);
            } else {
                view.showMessage("Selecione uma peça válida do seu turno.");
            }
        } else {
            if (board.movePiece(selectedRow, selectedCol, row, col)) {
                view.updateBoard(board);
                view.clearHighlights();
                if (board.isGameOver()) {
                    String winnerName = board.getWinner();
                    ranking.addVictory(winnerName);
                    PersistenceManager.saveRanking(ranking, RANKING_FILE);
                    view.showMessage("Fim de Jogo! Vencedor: " + winnerName + "!");
                }
            } else {
                view.showMessage("Movimento inválido.");
                view.clearHighlights();
            }
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    private void newGame() {
        board = new Board(); 
        view.updateBoard(board);
        view.clearHighlights();
        selectedRow = -1;
        selectedCol = -1;
        PersistenceManager.saveGame(board, GAME_FILE); 
        view.showMessage("Novo jogo iniciado!");
    }

    private void loadGame() {
        Board loadedBoard = PersistenceManager.loadGame(GAME_FILE);
        if (loadedBoard != null) {
            this.board.loadGameState(loadedBoard);
            view.updateBoard(board);
            view.clearHighlights();
            selectedRow = -1;
            selectedCol = -1;
            view.showMessage("Jogo carregado com sucesso!");
        } else {
            view.showMessage("Nenhum jogo salvo encontrado.");
        }
    }

    private void showRanking() {
        StringBuilder rankingText = new StringBuilder("Ranking de Jogadores:\n");
        if (ranking.getRanking().isEmpty()) {
            rankingText.append("Nenhum jogador no ranking ainda.");
        } else {
            ranking.getRanking().entrySet().stream()
                    .sorted(java.util.Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> rankingText.append(entry.getKey()).append(": ").append(entry.getValue())
                            .append(" vitórias\n"));
        }
        view.showMessage(rankingText.toString());
    }
}