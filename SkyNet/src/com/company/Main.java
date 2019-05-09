package com.company;

public class Main {

    public static void main(String[] args) {
	    Worker jakub = new Worker("Viktor", "Surzhko");
	    jakub.addHour(8,2);
        jakub.calculateRating();

	    System.out.println(jakub.raing);

    }
}
