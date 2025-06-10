package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.ChessPiece;
import model.Board;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;

public class ChessView extends JFrame {
    private JButton[][] buttons = new JButton[8][8];
    private JLabel statusLabel;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton showRankingButton;

    private Map<String, ImageIcon> pieceIcons = new HashMap<>();

    public ChessView() {
        setTitle("Jogo de Xadrez");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPieceImages();
        initComponents();
    }

    private void loadPieceImages() {
        String[] pieceTypes = { "pawn", "rook", "knight", "bishop", "queen", "king" };
        String[] colors = { "white", "black" };
        int iconSize = 40; 

        for (String color : colors) {
            for (String type : pieceTypes) {
                String path = "/resources/images/" + color + "-" + type + ".png";
                try {
                    ImageIcon originalIcon = new ImageIcon(getClass().getResource(path));
                    Image originalImage = originalIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
                    pieceIcons.put(path, new ImageIcon(resizedImage));
                } catch (NullPointerException e) {
                    System.err.println(
                            "Erro ao carregar imagem: " + path + ". Verifique o caminho e a existência do arquivo.");
                    pieceIcons.put(path,
                            new ImageIcon(new BufferedImage(iconSize, iconSize, BufferedImage.TYPE_INT_ARGB)));
                                                                                                            
                }
            }
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                // Removendo a configuração de fonte para texto, pois usaremos ícones
                // buttons[i][j].setFont(pieceFont);
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(new Color(238, 238, 210)); // Light square
                } else {
                    buttons[i][j].setBackground(new Color(118, 150, 86)); // Dark square
                }
                buttons[i][j].setOpaque(true); // Garante que a cor de fundo seja exibida
                buttons[i][j].setBorderPainted(false); // Remove a borda padrão do botão
                boardPanel.add(buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Turno: Branco", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 18));
        add(statusLabel, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        newGameButton = new JButton("Novo Jogo");
        loadGameButton = new JButton("Carregar Jogo");
        showRankingButton = new JButton("Ranking");

        controlPanel.add(newGameButton);
        controlPanel.add(loadGameButton);
        controlPanel.add(showRankingButton);
        add(controlPanel, BorderLayout.NORTH);
    }

    public void updateBoard(Board boardModel) {
        ChessPiece[][] board = boardModel.getBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null) {
                    // Define o ícone da peça
                    buttons[i][j].setIcon(pieceIcons.get(piece.getImagePath()));
                    buttons[i][j].setText(""); // Garante que não haja texto (como os "...")
                } else {
                    buttons[i][j].setIcon(null); // Remove o ícone se não houver peça
                    buttons[i][j].setText(""); // Garante que não haja texto
                }
                // Reset background color
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(new Color(238, 238, 210));
                } else {
                    buttons[i][j].setBackground(new Color(118, 150, 86));
                }
            }
        }

        if (boardModel.isGameOver()) {
            statusLabel.setText("Fim de Jogo! Vencedor: " + boardModel.getWinner());
        } else {
            statusLabel.setText(boardModel.isWhiteTurn() ? "Turno: Branco" : "Turno: Preto");
        }
    }

    public void addButtonListener(int row, int col, ActionListener al) {
        buttons[row][col].addActionListener(al);
    }

    public void addNewGameListener(ActionListener al) {
        newGameButton.addActionListener(al);
    }

    public void addLoadGameListener(ActionListener al) {
        loadGameButton.addActionListener(al);
    }

    public void addShowRankingListener(ActionListener al) {
        showRankingButton.addActionListener(al);
    }

    public void highlightSquare(int row, int col) {
        buttons[row][col].setBackground(Color.YELLOW);
    }

    public void clearHighlights() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(new Color(238, 238, 210));
                } else {
                    buttons[i][j].setBackground(new Color(118, 150, 86));
                }
            }
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getPlayerName(String title, String message) {
        return JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}