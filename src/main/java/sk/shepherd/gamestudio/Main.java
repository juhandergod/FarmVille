package sk.shepherd.gamestudio;

import sk.shepherd.gamestudio.game.farmville.core.Field;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(10,10);

        System.out.println("columns: "+field.getColumn()+"\nrows: "+field.getRow());

        System.out.println("FIELD - 1:");
        field.printField();
        System.out.println();
        System.out.println();
        System.out.println("FIELD - 2:");

        field.putLand(5,5);
        field.printField();

        System.out.println("FIELD - 3:");

        field.putLand(5,1);
        field.printField();


    }
}
