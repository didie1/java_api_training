package fr.lernejo.game;


public class Battlefield {
    public final int[][] board;
    public final int numberShip;
    public final int carrier = 5;
    public final int assault = 4;
    public final int missile = 3;
    public final int cruiser = 2;
    public Battlefield(){
        this.board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0;
            }
        }
        this.numberShip = 5;
    }
    public void placeBoat() {
        for (int i = 0; i < carrier; i++) {this.board[i][0] = 1; }
        for (int i = 0; i < assault; i++) { this.board[6][i] = 1; }
        for (int i = 0; i < missile; i++) { this.board[2][i] = 1; this.board[i][7] = 1; }
        for (int i = 0; i < cruiser; i++) { this.board[4][i] = 1; }
    }

    public String update(String target){
        int row = (int)target.charAt(0) - 65;
        int column = Integer.parseInt(String.valueOf(target.charAt(1)));
        return "miss";
    }
}
