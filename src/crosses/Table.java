package crosses;

class Table {

    private String[] table = {".", ".", ".", ".", ".", ".", ".", ".", "."};

//    public static void main(String[] args) {
////        setCell(5, "ii");
////        setCell(1, "player");
////        System.out.println(getCell(1));
////        showTable();
//    }

    void showTable() {
        System.out.print(table[0] + table[1] + table[2] + "\n" + table[3] + table[4] + table[5] + "\n" + table[6] + table[7] + table[8] + "\n");
    }

    void setCell(int cell, String player){
        if (player.equals("ii")) {table[cell - 1] = "X";}
        else {table[cell - 1] = "O";}
    }

    String getCell(int cell){
        return table[cell - 1];
    }
}
