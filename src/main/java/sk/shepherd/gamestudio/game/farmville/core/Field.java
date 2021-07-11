package sk.shepherd.gamestudio.game.farmville.core;

public class Field {
    private int row;
    private int column;
    private Tile[][] tiles;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
        tiles = new Tile[row][column];
        generate();
    }

    private void generate() {
        for(int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                tiles[i][j] = new Spaces();
            }
        }
    }

    public void putLand(int rowPosition, int columnPosition) {
        if (rowPosition < 0 || columnPosition < 0 || rowPosition > getRow() - 5 || columnPosition > getColumn() -5 || !checkTiles(rowPosition, columnPosition)) {
            return;
        }
        for(int i = rowPosition; i < rowPosition + 5; i++) {
            for (int j = columnPosition; j < columnPosition + 5; j++) {
                tiles[i][j] = new Land();
            }
        }
    }

    private boolean checkTiles(int rowPosition, int columnPosition) {
        for(int i = rowPosition; i < rowPosition + 5; i++) {
            for (int j = columnPosition; j < columnPosition + 5; j++) {
                if (!(tiles[i][j] instanceof Spaces)) {
                    return false;
                }
            }
        }
        return true;
    }


    public void printField() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tiles[i][j] instanceof Spaces) {
                    System.out.print("S ");
                } else if (tiles[i][j] instanceof Land) {
                    System.out.print("L ");
                }
            }
            System.out.println();
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
