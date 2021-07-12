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

    /**
     * Generate funkció a kezdőpályát feltölti üres helyekkel.
     */

    private void generate() {
        for(int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                tiles[i][j] = new Spaces();
            }
        }
    }

    /**
     * Ha leakarunk helyezni egy földet a kijelölt pályára akkor meghivja ezt a funkciót
     * @param rowPosition -- a pozició ahova leakarjuk rakni x
     * @param columnPosition -- y koordinata
     */

    public void putLand(int rowPosition, int columnPosition) {
        if (rowPosition < 0 || columnPosition < 0 || rowPosition > getRow() - 5 || columnPosition > getColumn() -5 || !checkTiles(rowPosition, columnPosition, "Land")) {
            return;
        }
        for(int i = rowPosition; i < rowPosition + 5; i++) {
            for (int j = columnPosition; j < columnPosition + 5; j++) {
                tiles[i][j] = new Land();
            }
        }
    }

    /**
     * Megnezi, hogy ha az adott helyre ahova leakarunk helyezni valamit, szabad - e vagy sem.
     * @param rowPosition -- pozicio
     * @param columnPosition
     * @return -- true ha ures, false ha nem ures
     */

    private boolean checkTiles(int rowPosition, int columnPosition, String type) {
        int num;
        switch (type) {
            case "Land":
                num = 5;
                break;
            case "Item":
                num = 1;
                break;
            default:
                num = 0;
                break;
        }

        for(int i = rowPosition; i < rowPosition + num; i++) {
            for (int j = columnPosition; j < columnPosition + num; j++) {
                if (!(tiles[i][j] instanceof Spaces)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Kiirja a fieldet a console-ba
     */

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
