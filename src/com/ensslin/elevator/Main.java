package com.ensslin.elevator;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Elevator elevator = new Elevator(1);
        //boolean keepRunning = true;

        elevator.call(4); // adds floor to the queue
        elevator.call(6);
        elevator.call(3);
        int i = 5;

        while (i > 0) {
            elevator.run();
            i--;
        }

    }
}
