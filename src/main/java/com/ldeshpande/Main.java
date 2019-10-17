package com.ldeshpande;

import com.ldeshpande.service.CheeseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        CheeseService cheeseService = new CheeseService();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            int testCases = parseInt(reader.readLine());
            while (testCases-- > 0) {
                int maximumCheeseWeight = findMaximumCheese(cheeseService, reader);
                writeToConsole(writer, maximumCheeseWeight);
            }
        } catch (IOException ignored) {
            throw new IllegalStateException();
        }
    }

    private static void writeToConsole(PrintWriter writer, int output) {
        writer.println(output);
    }

    private static int findMaximumCheese(CheeseService service, BufferedReader reader) throws IOException {
        reader.readLine(); // Array count is not necessary
        int[] cheeseBlocks = readInputArray(reader);
        return service.getMaxConsecutiveCheese(cheeseBlocks);
    }

    private static int[] readInputArray(BufferedReader reader) throws IOException {
        String[] tokens = reader.readLine().split(SPACE);
        return Arrays.stream(tokens).mapToInt(Main::parseInt).toArray();
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str.trim());
    }
}
