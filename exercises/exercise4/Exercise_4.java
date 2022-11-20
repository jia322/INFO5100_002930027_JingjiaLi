package exercise4;

import java.util.regex.Pattern;

public class Exercise_4 {
    public static void main(String[] args) {
//        Console console = System.console();

        String pattern_1_str = "Hello World";
        String pattern_2_str = "^\\d+(\\.\\d+)?";
        String pattern_3_str = "[a-zA-Z]{3}";
        String pattern_4_str = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
        String pattern_5_str = "^\\d{3}-?\\d{2}-?\\d{4}$";


        Pattern pattern_1 = Pattern.compile(pattern_1_str);
        Pattern pattern_2 = Pattern.compile(pattern_2_str);
        Pattern pattern_3 = Pattern.compile(pattern_3_str);
        Pattern pattern_4 = Pattern.compile(pattern_4_str);
        Pattern pattern_5 = Pattern.compile(pattern_5_str);

        // test cases for pattern_1
        String test_str_1 = "Hello World!";
        String test_str_2 = "Hello!";
        System.out.println(test_str_1 + " is matched by pattern 1: " + pattern_1.matcher(test_str_1).find());
        System.out.println(test_str_2 + " is matched by pattern 1: " + pattern_1.matcher(test_str_2).find());
        System.out.println();

        // test cases for pattern_2
        String test_str_3 = "1232.1231";
        String test_str_4 = "a11";
        System.out.println(test_str_3 + " is matched by pattern 1: " + pattern_2.matcher(test_str_3).find());
        System.out.println(test_str_4 + " is matched by pattern 1: " + pattern_2.matcher(test_str_4).find());
        System.out.println();


        // test cases for pattern_3
        String test_str_5 = "abcde";
        String test_str_6 = "ab11";
        System.out.println(test_str_5 + " is matched by pattern 1: " + pattern_3.matcher(test_str_5).find());
        System.out.println(test_str_6 + " is matched by pattern 1: " + pattern_3.matcher(test_str_6).find());
        System.out.println();


        // test cases for pattern_4
        String test_str_7 = "123-456-1111";
        String test_str_8 = "1212312";
        System.out.println(test_str_7 + " is matched by pattern 1: " + pattern_4.matcher(test_str_7).find());
        System.out.println(test_str_8 + " is matched by pattern 1: " + pattern_4.matcher(test_str_8).find());
        System.out.println();


        // test cases for pattern_5
        String test_str_9 = "666-22-3333";
        String test_str_10 = "1212312";
        System.out.println(test_str_9 + " is matched by pattern 1: " + pattern_5.matcher(test_str_9).find());
        System.out.println(test_str_10 + " is matched by pattern 1: " + pattern_5.matcher(test_str_10).find());
        System.out.println();
    }
}