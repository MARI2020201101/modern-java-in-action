package ch09;

import java.util.StringJoiner;

public class ProcessDecorateString extends ProcessingObject<String> {

    @Override
    protected String handleObject(String input) {
        return "*****\n" + input + "\n*****";
    }
}
