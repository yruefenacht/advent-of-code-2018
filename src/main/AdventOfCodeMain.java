package main;

import Day2.Checksum;
import Day3.Areas;
import Day4.Guards;

import java.io.FileNotFoundException;

public class AdventOfCodeMain {

    public static void main(String[] args) throws FileNotFoundException {

        Checksum checksum = new Checksum();
        Areas areas = new Areas();
        Guards guards = new Guards();

        System.out.println("------ Checksum ------");
        System.out.println(checksum.checksum());
        System.out.println(checksum.getBoxId());

        System.out.println("------ Areas ------");
        System.out.println(areas.overlaps());
        System.out.println(areas.getSingleId());

        System.out.println("------ Guards ------");
        System.out.println(guards.getGuardMinute());
        System.out.println(guards.getMostFrequentGuard());
    }
}
