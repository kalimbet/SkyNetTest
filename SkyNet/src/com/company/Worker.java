package com.company;

public class Worker {
    String name;
    String surname;
    int timeOnWork = 0;
    int timeOnRest = 0;

    int raing = 0;
    boolean finishTask = false;

    Worker(String name, String surname){
        this.name = name;
        this.surname = surname;
    }


    public void addHour(int hourOfWork, int hourOfRest){
        int check = hourOfRest + hourOfWork;
        if(check <= 24){
            for(int i = 0; i < hourOfWork; i++){
                addOneHourWork();
            }

            for(int i = 0; i < hourOfRest; i++){
                addOneHourRest();
            }
        }
    }


    public void calculateRating(){
        if(timeOnWork > 6){
            raing += 3;
        }else{
            raing += 1;
        }

        if(timeOnRest < 5){
            raing += 3;
        }else{
            raing += 1;
        }

        if(finishTask == true){
            raing += 4;
        }else {
            raing += 1;
        }
    }

    private void addOneHourWork(){
        timeOnWork += 1;
    }

    private void addOneHourRest(){
        timeOnRest += 1;
    }
}
