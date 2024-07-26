package com.duckrace;

class BoardTest {

    public static void main(String[] args) {
        Board board = Board.getInstance();

        board.update(3, Reward.DEBIT_CARD);
        board.update(2, Reward.DEBIT_CARD);
        board.update(1, Reward.PRIZES);
        board.update(5, Reward.DEBIT_CARD);
        board.update(3, Reward.PRIZES);

        board.show();
    }
}