package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Horse theGood = new Horse("Хороший", 3.0, 0.0);
        Horse theBad = new Horse("Плохой", 3.0, 0.0);
        Horse theUgly = new Horse("Злой", 3.0, 0.0);

        horses.add(theGood);
        horses.add(theBad);
        horses.add(theUgly);

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        if ((horses.get(0).getDistance() > horses.get(1).getDistance()) && (horses.get(0).getDistance() > horses.get(2).getDistance())) return horses.get(0);
        else if((horses.get(0).getDistance() > horses.get(1).getDistance()) && (horses.get(0).getDistance() < horses.get(2).getDistance())) return horses.get(2);
        else if((horses.get(0).getDistance() < horses.get(1).getDistance()) && (horses.get(1).getDistance() > horses.get(2).getDistance())) return horses.get(1);
        else return horses.get(2);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
//it's really my Hippodrome