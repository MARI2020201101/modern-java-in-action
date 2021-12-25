package ch03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface ProcessFileFunction {

    String processFile(BufferedReader br) throws IOException;
}
