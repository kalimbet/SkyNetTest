package com.company;

import java.util.ArrayList;

public class Worker {
    String name;
    String surname;

    private int timeOnWork = 0, timeOnRest = 0;
    private int rating = 0, weekRating = 0;
    private int days;
    private boolean finishTask = false;
    ArrayList<Integer> dayskListRating = new ArrayList<>();


    Worker(String name, String surname){
        this.name = name;
        this.surname = surname;

    }

    //Report
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


    //Update
    public void addToListAndUpdate(){
        dayskListRating.add(rating);
        rating = 0;
        timeOnRest = 0;
        timeOnWork = 0;
    }

    public void updateWeekRating(){
        weekRating = 0;
    }

    // Visualisation
    public void showDaysRating(){
        for(int i = 0; i < dayskListRating.size(); i++){
            days = i + 1;
            System.out.println("Day " + days);
            System.out.println("    Rating : " + dayskListRating.get(i));
            System.out.println("    Conclusion : " + conclusionOfDay(dayskListRating.get(i)));
            System.out.println();
        }
    }

    public void showWeekRating(){
        System.out.println("Week rating : " + weekRating);
        System.out.println("    Conclusion: " + conclusionOfWeek());
    }

    //Calculation
    public int calculateDayRating(){
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
        return rating;
    }

    public int calculateWeekRating(){
        for(int i = 0; i < dayskListRating.size(); i++){
            weekRating += dayskListRating.get(i);
        }
        return weekRating;
    }

    //Conclusion
    public String conclusionOfDay(int xRating){
        if(xRating >= 5 && xRating <= 7) return "Acceptable result";
        if(xRating >= 8) return "Excellent result";
        return "Bad result";
    }

    public String conclusionOfWeek(){
        if(weekRating >= 25 && weekRating<= 40) return "Acceptable result";
        if(weekRating > 40) return "Excellent result";
        return "Bad reuslt";
    }

    //
    private void addOneHourWork(){
        timeOnWork += 1;
    }

    private void addOneHourRest(){
        timeOnRest += 1;
    }
}
