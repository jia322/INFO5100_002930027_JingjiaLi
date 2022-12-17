package exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Exercise_7 {
    //function for question (a): the function is to count odd integers in a list
    public static int countElement(List<Integer> list){
        int count = 0;
        for (int element:list){
            if (element % 2 == 1){
                count += 1;
            }
        }
        return count;
    }

    //test for question (a)
    public static void test1() {
        System.out.println("Test for question-a");
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        int odd_count = countElement(list);
        System.out.println("The number of odd integers in between list " + list + " is: " + odd_count );
    }

    // function for question (b)
    public static void swap (Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //test for question (b)
    public static void test2() {
        String[] a = {"Hello", "And", "Goodbye"};
        System.out.println("Test 1 for question-b:");
        System.out.println("raw array:"+Arrays.toString(a));
        swap(a, 0, 1);
        System.out.println("first, changing index 0 and 1:"+Arrays.toString(a));
        swap(a, 1, 2);
        System.out.println("second, changing index 1 and 2:"+Arrays.toString(a));
        System.out.println("Test 2 for question-b:");
        String[] b={"1","2","3"};
        System.out.println("raw array: "+Arrays.toString(a));
        swap(b,0,2);
        System.out.println("changing index 0 and 2: "+Arrays.toString(b));
    }

    //function for question (c)
    public static <T extends Comparable> T maximalElement (List<T> list, int from, int to) {
        T max = list.get(from);
        for (int i = from; i <= to; i++) {
            T elem1 = list.get(i);
            if (elem1.compareTo(max) > 0) {
                max = elem1;
            }
        }
        return max;
    }

    //test for question (c)
    public static void test3() {
        System.out.println("Test for question-c:");

        List<Integer> list_1 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        int max_element_1 = maximalElement(list_1, 3, 8);
        System.out.println("The max element between index 3 and index 8 of list " + list_1 + " is: " + max_element_1 );

        List<Integer> list_2 = new ArrayList<Integer>(Arrays.asList(1,4,6,2,6,3,5,6,7));
        int max_element_2 = maximalElement(list_2, 0, 5);
        System.out.println("The max element between index 0 and index 5 of list " + list_2 + " is: " + max_element_2 );
    }


    public static void main(String...args)
    {
        //test for question (a):
        test1();
        System.out.println("");
        //test for question (b):
        test2();
        System.out.println("");
        //test for question (c):
        test3();
    }
}