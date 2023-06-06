package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HJ68 {

    static class Student {
        String name;
        int score;
        int sort;

        public Student(String name, int score, int sort) {
            this.name = name;
            this.score = score;
            this.sort = sort;
        }

        public int getScore() {
            return score;
        }

        public int getSort() {
            return sort;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int sort = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            students.add(new Student(split[0], Integer.parseInt(split[1]), i));
        }
        StringBuilder builder = new StringBuilder();
        if (sort == 1) {
            students.stream().sorted(Comparator.comparing(Student::getScore)
                    .thenComparing(Student::getSort)).forEach(o ->
                    builder.append(o.name).append(" ").append(o.score).append("\n"));
        } else {
            students.stream().sorted(Comparator.comparing(Student::getScore).reversed()
                    .thenComparing(Student::getSort)).forEach(o ->
                    builder.append(o.name).append(" ").append(o.score).append("\n"));
        }
        System.out.println(builder);
    }

}