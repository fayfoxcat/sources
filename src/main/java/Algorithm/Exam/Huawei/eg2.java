package Algorithm.Exam.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class eg2 {

    public static class Student {
        private String classNo;
        private String no;

        private Integer scoreA;

        private Integer scoreB;

        private Integer score;

        public Student() {
        }

        public Student(String classNo, String no, Integer scoreA, Integer scoreB, Integer score) {
            this.classNo = classNo;
            this.no = no;
            this.scoreA = scoreA;
            this.scoreB = scoreB;
            this.score = score;
        }

        public String getClassNo() {
            return classNo;
        }

        public void setClassNo(String classNo) {
            this.classNo = classNo;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public Integer getScoreA() {
            return scoreA;
        }

        public void setScoreA(Integer scoreA) {
            this.scoreA = scoreA;
        }

        public Integer getScoreB() {
            return scoreB;
        }

        public void setScoreB(Integer scoreB) {
            this.scoreB = scoreB;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    static Map<String, Student> studentMap = new HashMap<>();

    static void setMap(String[] course) {
        for (String s : course) {
            String[] split = s.split(",");
            String no = split[0];
            String classNo = split[0].substring(0, 5);
            Integer score = Integer.parseInt(split[1]);
            Student student = studentMap.get(no);
            if (studentMap.get(no) != null) {
                student.setScoreB(score);
                student.setScore(student.getScore() + score);
            } else {
                studentMap.put(no, new Student(classNo, no, score, null, score));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] courseA = reader.readLine().split(";");
        String[] courseB = reader.readLine().split(";");
        setMap(courseA);
        setMap(courseB);

        LinkedHashMap<String, List<Student>> list = studentMap.values().stream().filter(o -> o.getScoreA() != null && o.getScoreB() != null)
                .collect(Collectors.groupingBy(Student::getClassNo, LinkedHashMap::new, Collectors.toList()));
        StringBuilder builder = new StringBuilder();
        List<String> keys = new ArrayList<>(list.keySet());
        Collections.sort(keys);
        keys.forEach(o -> {
            builder.append(o).append("\n");
            StringBuilder tmp = new StringBuilder();
            list.get(o).stream().sorted(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getNo)).forEach(s -> {
                tmp.append(s.getNo()).append(";");
            });
            builder.append(tmp.substring(0, tmp.length() - 1));
            builder.append("\n");
        });
        System.out.println(builder.length() > 0 ? builder : "NULL");
    }
}