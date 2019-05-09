package com.company;

import java.util.ArrayList;

public class Worker {
    String name;
    String surname;

    private int timeOnWork = 0, timeOnRest = 0;
    private int rating = 0, weekRating = 0;
    private int days;
    private boolean finishTask = false;
    ArrayList<Integer> weekListRating = new ArrayList<>();


    Worker(String name, String surname){
        this.name = name;
        this.surname = surname;

    }


    public void reportOfDay(int hourOfWork, int hourOfRest, byte completed){
        int check = hourOfRest + hourOfWork;
        if(check <= 24){
            for(int i = 0; i < hourOfWork; i++){
                addOneHourWork();
            }

            for(int i = 0; i < hourOfRest; i++){
                addOneHourRest();
            }
        }

        if(completed == 1){
            finishTask = true;
        }else if(completed == 0){
            finishTask = false;
        }
    }

    public void week(){
        weekListRating.add(rating);
        rating = 0;
        timeOnRest = 0;
        timeOnWork = 0;
    }

    public void showDaysRating(){
        for(int i = 0; i < weekListRating.size(); i++){
            days = i + 1;
            System.out.println("Day " + days);
            System.out.println("    Rating : " + weekListRating.get(i));
            System.out.println("    Conclusion : " + conclusionOfDay());
            System.out.println();
        }
    }

    public void showWeekRating(){
        System.out.println("Week rating : " + weekRating);
        System.out.println("    Conclusion: " + conclusionOfWeek());
    }

    public void calculateDayRating(){
        if(timeOnWork > 6){
            rating += 3;
        }else{
            rating += 1;
        }

        if(timeOnRest < 5){
            rating += 3;
        }else{
            rating += 1;
        }

        if(finishTask == true){
            rating += 4;
        }else {
            rating += 1;
        }
    }

    public int calculateWeekRating(){
        for(int i = 0; i < weekListRating.size(); i++){
            weekRating += weekListRating.get(i);
        }
        return weekRating;
    }

    public String conclusionOfDay(){
        if(rating >= 5 && rating <= 7) return "Acceptable result";
        if(rating >= 8) return "Excellent result";
        return "Bad result";
    }

    public String conclusionOfWeek(){
        if(weekRating >= 25 && weekRating<= 40) return "Acceptable result";
        if(weekRating > 40) return "Excellent result";
        return "Bad reuslt";
    }

    private void addOneHourWork(){
        timeOnWork += 1;
    }

    private void addOneHourRest(){
        timeOnRest += 1;
    }
}
