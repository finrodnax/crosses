package crosses;

class Turn {

    private String result;
    private int turn;

//    public static void main(String[] args) {
//
//    }

    Turn(int turn, String result){
        this.turn = turn;
        this.result = result;
    }

    int getTurn() {
        return turn;
    }

    String getResult() {
        return result;
    }

}
