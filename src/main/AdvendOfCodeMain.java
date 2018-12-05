package main;

import Day1.FrequencyCounter;

import java.io.IOException;

public class AdvendOfCodeMain {

    public static void main(String[] args) throws IOException {

        FrequencyCounter frequencyCounter = new FrequencyCounter();


        System.out.println(frequencyCounter.getFrequency());
        System.out.println(frequencyCounter.twiceFrequency());

    }
}
