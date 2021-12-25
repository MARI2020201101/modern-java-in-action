package ch03;

import java.io.BufferedReader;

@FunctionalInterface
public interface ProcessFileFunction {

    String processFile(BufferedReader br);
}
