package com.ensslin.elevator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {

    private int currentFloor; // keeps track of the current floor
    private int destinationFloor; // where the elevator is heading

    public Queue<Integer> floorPriorityQueue; // a priority queue to track floors

    /***************************************************
                        Constructor
     ***************************************************/
    Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        //Comparator<Integer> comparator = new FloorPriorityComparator();
        this.floorPriorityQueue = new LinkedList<>();
        this.destinationFloor = currentFloor;
    }

    /***************************************************
                call - adds floor to queue
     ***************************************************/
    public void call(int floor) {
        this.floorPriorityQueue.add(floor);
    }

    /***************************************************
            run - directs elevator to next floor
     ***************************************************/
    public void run() {

        // dequeue next floor number, if none. return current floor and print empty queue
        if (!this.floorPriorityQueue.isEmpty()) {
            this.destinationFloor = this.floorPriorityQueue.remove();

            // compare current floor vs destination floor
            if (isGoingDown()) {
                down();
            } else if (isGoingUp()) {
                up();
            } else {
                System.out.println("There is nowhere to go! You will remain at the current floor");
            }
        } else
            System.out.println("There is nowhere to go! You will remain at the current floor");
    }

    /***************************************************
                        elevator - up
     ***************************************************/
    public void up() {
        printCurrentFloor(this.currentFloor);
        System.out.println();

        for (int i = this.currentFloor + 1; i <= this.destinationFloor; i++) {
            System.out.println("Passing floor: " + i + " going up!");
        }

        System.out.println("Arrived at floor: " + this.destinationFloor);
        System.out.println();

        updateCurrentFloor(this.destinationFloor);
    }

    /***************************************************
                        elevator - down
     ***************************************************/
    public void down() {
        printCurrentFloor(this.currentFloor);
        System.out.println();

        for (int i = this.currentFloor - 1; i >= this.destinationFloor; i--) {
            System.out.println("Passing floor: " + i + " going down!");
        }

        System.out.println("Arrived at floor: " + this.destinationFloor);
        System.out.println();

        updateCurrentFloor(this.destinationFloor);
    }

    /***************************************************
                        Helper Methods
     ***************************************************/
    public void printCurrentFloor(int currentFloor) {
        System.out.println("Currently on floor: " + currentFloor);
    }

    public void updateCurrentFloor(int destinationFloor) {
        this.currentFloor = destinationFloor;
    }

    public boolean isGoingDown() {
        return (this.currentFloor > this.destinationFloor);
    }

    public boolean isGoingUp() {
        return (this.currentFloor < this.destinationFloor);
    }
}