package exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student{
    String name;
    public int quiz_scores[] = new int[15];

    //constructor
    public Student(String n, int[] scores){
        name = n;
        quiz_scores = scores;
    }

}

class PartTimeStudent extends Student{
    public PartTimeStudent(String n, int[] scores){
        super(n, scores);
    }
}

class FullTimeStudent extends Student{
    public int exam_score_1, exam_score_2;

    public FullTimeStudent(String n,  int[] scores, int score_1, int score_2){
        super(n, scores);
        exam_score_1 = score_1;
        exam_score_2 = score_2;
    }
}

class Session {
    Student students[];
    double average_quiz_scores[];

    public Session(){
        students = new Student[20];
        average_quiz_scores = new double[20];
    }

    public void averageQuizScore() {

        for (int i = 0; i < students.length; i++) {
            double total_score = 0.0;
            int scores[] = students[i].quiz_scores;
            for (int j = 0; j < scores.length; j++) {
                total_score += scores[j];
            }
            average_quiz_scores[i] = total_score / scores.length;
            System.out.println("Average Quiz score for student " + students[i].name + " is " + average_quiz_scores[i]);
        }
    }

    public void printSortedQuizScores(){
        List<Integer> all_quiz_score_list = new ArrayList<Integer>();
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            Integer[] scores = new Integer[student.quiz_scores.length];
            Arrays.setAll(scores, j -> student.quiz_scores[j]);
            for (Integer score : scores){
                all_quiz_score_list.add(score);
            }
        }
        int[] all_quiz_scores = all_quiz_score_list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(all_quiz_scores);
        System.out.println("The sorted Average Quiz score for student is " + Arrays.toString(all_quiz_scores));
    }

    public void printPartTimeStudentNames() {
        String name_list = "";
        for (int i = 0; i < students.length; i++) {

            if (students[i] instanceof PartTimeStudent) {
                name_list += students[i].name + "\t";
            }

        }
        System.out.println("The name for Part-Time students is: " + name_list);

    }

    public void printFullTimeStudentExamScores() {
        for (int i = 0; i < students.length; i++) {

            String name_list = "";
            if (students[i] instanceof FullTimeStudent) {
                FullTimeStudent student = (FullTimeStudent)students[i];
                System.out.println("For Full-Time student " + student.name + " the exam 1 score is: " +
                        student.exam_score_1 + " the exam 2 score is: " +
                        student.exam_score_2);
            }
        }
    }

}

public class Exercise_1 {
    public static void main(String[] args) {
        Session session = new Session();

        // populate 10 part-time students
        for (int i = 0; i < 10; i++){
            int[] scores = new int[15];

            for (int j = 0; j < 15; j++){
                scores[j] = i;
            }
            session.students[i] = new PartTimeStudent("Student_"+String.valueOf(i), scores);
        }

        // populate 10 full-time students
        for (int i = 10; i < 20; i++){
            int[] scores = new int[15];

            for (int j = 0; j < 15; j++){
                scores[j] = i;
            }
            session.students[i] = new FullTimeStudent("Student_"+String.valueOf(i), scores, i, i);
        }

        System.out.println("Results for average quiz scores computation:");
        session.averageQuizScore();
        System.out.println();

        System.out.println("Results for sorting average quiz scores :");
        session.printSortedQuizScores();
        System.out.println();

        System.out.println("Results for part-time student name:");
        session.printPartTimeStudentNames();
        System.out.println();

        System.out.println("Results for full-time student exam scores:");
        session.printFullTimeStudentExamScores();
        System.out.println();


    }
}
