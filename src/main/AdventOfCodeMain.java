package main;

import Day1.FrequencyCounter;
import Day2.Checksum;
import Day3.Areas;
import Day4.Guards;
import Day5.Polymers;
import Day6.Coordinates;
import Day7.Order;
import Day8.Nodes;

import java.io.FileNotFoundException;

public class AdventOfCodeMain {

    public static void main(String[] args) throws FileNotFoundException {

        FrequencyCounter frequencyCounter   = new FrequencyCounter();
        Checksum checksum                   = new Checksum();
        Areas areas                         = new Areas();
        Guards guards                       = new Guards();
        Polymers polymers                   = new Polymers();
        Coordinates coordinates             = new Coordinates();
        Order order                         = new Order();
        Nodes nodes                         = new Nodes();

        System.out.println("------ Day 1: Frequency ------");
        System.out.println(frequencyCounter.getFrequency());
        //System.out.println(frequencyCounter.twiceFrequency());

        System.out.println("------ Day 2: Checksum ------");
        System.out.println(checksum.checksum());
        System.out.println(checksum.getBoxId());

        System.out.println("------ Day 3: Areas ------");
        System.out.println(areas.overlaps());
        System.out.println(areas.getSingleId());

        System.out.println("------ Day 4: Guards ------");
        System.out.println(guards.getGuardMinute());
        System.out.println(guards.getMostFrequentGuard());

        System.out.println("------ Day 5: Polymers ------");
        System.out.println(polymers.getUnits());
        //System.out.println(polymers.getShortestPolymer());

        System.out.println("------ Day 6: Coordinates ------");
        System.out.println(coordinates.getLargestArea());
        System.out.println(coordinates.getRegion());

        System.out.println("------ Day 7: Order ------");
        System.out.println(order.getOrder());
        System.out.println(order.countDuration());

        System.out.println();

    }
}
