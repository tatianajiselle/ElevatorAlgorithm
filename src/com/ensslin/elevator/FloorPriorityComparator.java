package com.ensslin.elevator;

import java.util.Comparator;

public class FloorPriorityComparator implements Comparator<Integer>
{

    // compares if the called floor is greator priority than destination floor (on the way to destination)
    @Override
    public int compare(Integer calledFloor, Integer destinationFloor)
    {

        // if the current floor is the called floor
        if (destinationFloor == calledFloor) {
            return -1;
        }


        if (destinationFloor > calledFloor) { // called floor is on the way down
            return 1;
        }

        else if (destinationFloor < calledFloor) { // called floor is on the way up
            return 1;
        } else {
            return -1;
        }
    }

}
