package Maersk;

import java.util.*;

public class CalculateStudentAverages {
    public static void main(String[] args) {
        String[] input = {
                "Puja Pandey; 8;6;7",
                "John Doe, 9,12,5",
                "DHEERAJ KUMAR 10 10 10"
        };

        Map<String, List<Integer>> studentMarks = new LinkedHashMap<>();

        for (String entry : input) {
            // Split the entry by any non-alphanumeric characters
            String[] parts = entry.split("[^a-zA-Z0-9]+");
            List<Integer> marks = new ArrayList<>();
            StringBuilder studentName = new StringBuilder();

            for (String part : parts) {
                try {
                    int mark = Integer.parseInt(part);
                    if (mark >= 1 && mark <= 10) {
                        marks.add(mark);
                    }
                } catch (NumberFormatException e) {
                    // If it's not an integer, it's part of the name
                    studentName.append(part).append(" ");
                }
            }

            studentName = new StringBuilder(studentName.toString().trim());
            studentMarks.put(studentName.toString(), marks);
        }

        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> marks = entry.getValue();
            int average = calculateAverage(marks);
            System.out.println(studentName + "-" + average);
        }
    }

    public static int calculateAverage(List<Integer> marks) {
        if (marks.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        return sum / marks.size(); // Integer division, truncating decimal places
    }
}