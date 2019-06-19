package crosses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Table table = new Table();

    public static void main(String[] args) throws IOException {
        System.out.println("Управление осуществляется вводом номера ячейки, в которую Вы хотите поставить нолик от 1 до 9");
        table.showTable();
        System.out.println("You will lose soon!");
        table.setCell(5, "ii");
        table.showTable();

        int playerTurn1 = playerTurn();
        table.setCell(playerTurn1, "human");
        table.showTable();

        System.out.println("You can't beat me!");
        int iiTurn2 = iiTurn2(playerTurn1);
        table.setCell(iiTurn2, "ii");
        table.showTable();

        int playerTurn2 = playerTurn();
        table.setCell(playerTurn2, "human");
        table.showTable();

        System.out.println("The End is near!");
        Turn iiTurn3 = iiTurn3(playerTurn1, iiTurn2, playerTurn2);
        table.setCell(iiTurn3.getTurn(), "ii");
        table.showTable();
        showResult(iiTurn3.getResult());

    }

    private static int playerTurn() throws IOException {
        int turn;
        while (true) {
            turn = Integer.parseInt(reader.readLine());
            if (turn > 0 && turn < 10) {
                if (table.getCell(turn).equals(".")) {
                    break;
                }
            }
        }
        return turn;
    }

    private static int iiTurn2(int playerTurn1){
            switch (playerTurn1) {
            case 1:
            case 6:
            case 8: return 9;
            case 2:
            case 4:
            case 9: return 1;
            case 3: return 7;
            case 7: return 3;
        }
        return 0; // Unreachable
    }

    private static Turn iiTurn3(int playerTurn1, int iiTurn2, int playerTurn2){
        if (playerTurn1 == 1) {
            switch (playerTurn2) {
                case 2:
                case 8: return new Turn(3, "win");
                case 4:
                case 6: return new Turn(7, "win");
                case 3: return new Turn(2, "draw");
                case 7: return new Turn(4, "draw");
            }
        } else if (playerTurn1 == 3){
            switch (playerTurn2) {
                case 2:
                case 8: return new Turn(1, "win");
                case 4:
                case 6: return new Turn(9, "win");
                case 1: return new Turn(2, "draw");
                case 9: return new Turn(6, "draw");
            }
        } else if (playerTurn1 == 7){
            switch (playerTurn2) {
                case 2:
                case 8: return new Turn(9, "win");
                case 4:
                case 6: return new Turn(1, "win");
                case 1: return new Turn(4, "draw");
                case 9: return new Turn(8, "draw");
            }
        } else if (playerTurn1 == 9){
            switch (playerTurn2) {
                case 2:
                case 8: return new Turn(7, "win");
                case 4:
                case 6: return new Turn(3, "win");
                case 3: return new Turn(6, "draw");
                case 7: return new Turn(8, "draw");
            }
        } else if (playerTurn1 == 2 || playerTurn1 == 4) {
            return playerTurn2 == 9 ? new Turn(7, "win") : new Turn(9, "win");
//        } else if (playerTurn1 == 4) {
//            return playerTurn2 == 9 ? new Turn(7, "win") : new Turn(9, "win");
        } else if (playerTurn1 == 6 || playerTurn1 == 8) {
            return playerTurn2 == 1 ? new Turn(3, "win") : new Turn(1, "win");
//        } else if (playerTurn1 == 8) {
//            return playerTurn2 == 9 ? new Turn(7, "win") : new Turn(9, "win");
        }

        return new Turn(0, "Unreachable");
    }

    private static void showResult(String result){
        if (result.equals("win")) {
        System.out.println("Ha-ha, loser!");}
        if (result.equals("draw")) {
            System.out.println("Draw! You still can't beat me!");
        }
    }
}
