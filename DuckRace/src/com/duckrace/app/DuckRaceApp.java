package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

/*
 * Application controller.
 * It conducts the overall "flow" of the app, does all user prompting,
 * and passes user-provided info into the back-end (model).
 */

public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void welcome() {
        System.out.println(" -------------------------------------------------");
        System.out.println("| W E L C O M E   T O   T H E   D U C K   R A C E |");
        System.out.println(" -------------------------------------------------");
    }

    private void showBoard() {
        board.show();
    }

    private int promptForId() {
        int id = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\nEnter the winner's ID [1-11]: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d{1,2}")) {
                id = Integer.parseInt(input);
                if (id > 11 || id < 1) {
                    System.out.println("ID " + id + " is out of range [1-11]");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input! Try again.");
            }
        }

        return id;
    }

    private Reward promptForReward() {
        Reward reward = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\nPlease enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.matches("D|P")) {
                reward = input.equals("D") ? Reward.DEBIT_CARD : Reward.PRIZES;
                validInput = true;
            } else {
                System.out.println("Invalid input! Try again.");
            }
        }

        return reward;
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

}