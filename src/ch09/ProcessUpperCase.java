package ch09;

import java.util.Locale;

public class ProcessUpperCase extends ProcessingObject<String> {


    @Override
    protected String handleObject(String input) {
        return input.toUpperCase(Locale.ROOT);
    }
}
