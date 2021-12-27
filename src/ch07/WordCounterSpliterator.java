package ch07;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize<10){
            return null;
        }
        for(int splitPos = currentSize/2 + currentChar; splitPos < string.length() ; splitPos++){
            if(Character.isWhitespace(string.charAt(splitPos))){//공백을 찾아서 분할한다.
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,splitPos));
                currentChar = splitPos; //나의 시작위치는 쪼갠 중간부터 시작한다.
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
