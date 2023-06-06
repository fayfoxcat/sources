package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ29 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        char[] output = reader.readLine().toCharArray();
        char[] newInput = new char[input.length];
        char[] newOutput = new char[output.length];

        for (int i = 0; i < input.length; i++) {
            if (input[i] >= 'a' && input[i] < 'z') {
                newInput[i] = Character.toUpperCase((char) (input[i] + 1));
            } else if (input[i] == 'z') {
                newInput[i] = 'A';
            } else if (input[i] >= 'A' && input[i] < 'Z') {
                newInput[i] = Character.toLowerCase((char) (input[i] + 1));
            } else if (input[i] == 'Z') {
                newInput[i] = 'a';
            } else if (input[i] >= '0' && input[i] < '9') {
                newInput[i] = (char) (input[i] + 1);
            } else if (input[i] == '9') {
                newInput[i] = '0';
            } else {
                newInput[i] = input[i];
            }
        }

        for (int i = 0; i < output.length; i++) {
            if (output[i] > 'a' && output[i] <= 'z') {
                newOutput[i] = Character.toUpperCase((char) (output[i] - 1));
            } else if (output[i] == 'a') {
                newOutput[i] = 'Z';
            } else if (output[i] > 'A' && output[i] <= 'Z') {
                newOutput[i] = Character.toLowerCase((char) (output[i] - 1));
            } else if (output[i] == 'A') {
                newOutput[i] = 'z';
            } else if (output[i] > '0' && output[i] <= '9') {
                newOutput[i] = (char) (output[i] - 1);
            } else if (output[i] == '0') {
                newOutput[i] = '9';
            } else {
                newOutput[i] = output[i];
            }
        }
        StringBuilder inputBuilder = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder();
        for (char c : newInput) {
            inputBuilder.append(c);
        }
        for (char c : newOutput) {
            outputBuilder.append(c);
        }
        System.out.println(inputBuilder + "\n" + outputBuilder);
    }

}