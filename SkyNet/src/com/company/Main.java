package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

	    Worker jakub = new Worker("Viktor", "Surzhko");

        for(int i = 0; i < 2; i++){
            int days = i + 1;
            System.out.println("Day " + days);
            System.out.println("    Write work hours: ");
            int work = input.nextInt();
            System.out.println("    Write rest hours: ");
            int rest = input.nextInt();
            System.out.println("    Completed the task?");
            byte completed = input.nextByte();
            System.out.println("____________________");
            jakub.reportOfDay(work, rest, completed);
            jakub.calculateDayRating();
            jakub.week();
        }
	    System.out.println();
        jakub.calculateWeekRating();
        jakub.showDaysRating();
        jakub.showWeekRating();
    }
}
