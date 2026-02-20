package game.ui.view;

import game.model.CellType;
import game.model.GameState;
import game.model.Position;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.function.BiConsumer;

public class BoardView {
    private final Button[][] cells;
    private final GridPane node;

    public BoardView(int boardSize, int cellSize, BiConsumer<Integer, Integer> onCellClicked) {
        this.cells = new Button[boardSize][boardSize];
        this.node = new GridPane();
        this.node.setHgap(8);
        this.node.setVgap(8);
        this.node.setPadding(new Insets(8));

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                int targetRow = row;
                int targetCol = col;

                Button cell = new Button();
                cell.setMinSize(cellSize, cellSize);
                cell.setMaxSize(cellSize, cellSize);
                cell.setOnAction(event -> onCellClicked.accept(targetRow, targetCol));

                cells[row][col] = cell;
                node.add(cell, col, row);
            }
        }
    }

    public GridPane node() {
        return node;
    }

    public void render(GameState state) {
        for (int row = 0; row < GameState.BOARD_SIZE; row++) {
            for (int col = 0; col < GameState.BOARD_SIZE; col++) {
                CellType cellType = state.getCell(new Position(row, col));
                cells[row][col].setText(renderCell(cellType));
                cells[row][col].setDisable(state.isGameOver());
            }
        }
    }

    private String renderCell(CellType cellType) {
        return switch (cellType) {
            case EMPTY -> "";
            case X -> "X";
            case O -> "O";
            case SEALED -> "S";
        };
    }
}
