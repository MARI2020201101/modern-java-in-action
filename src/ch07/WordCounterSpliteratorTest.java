package ch07;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterSpliteratorTest {
    public static void main(String[] args) {
        Spliterator<Character> spliterator = new WordCounterSpliterator(sentence());
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        int counter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine).getCounter();


        System.out.println("counter : "+ counter);
    }

    public static String sentence(){
        return  "Casings wilted like lettuce out of water, as heavy machinery writhed and twisted into grotesque shapes in the blazing inferno.\n" +
                "more_vertThe inferno sent five firefighters to the hospital, and required the assistance of several fire departments and hazardous materials teams.\n" +
                "more_vertThe great chest opens for each victim and when a youngster is slid into the inferno, the door closes and the open mouth belches flame.\n" +
                "more_vertThe football field and school were unoccupied at the time of the inferno.\n" +
                "more_vertThe inferno raged for over 18 hours despite seven fire companies' efforts to battle the blaze.";
    }
}
