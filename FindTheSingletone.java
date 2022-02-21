package onlineExams;

import junit.framework.Assert;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 4/3/19
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindTheSingletone {

    public static int run(int[] student_list) {

        int single_student_number = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < student_list.length; i++) {
            Integer m = map.get(student_list[i]);
            if (m == null) {
                map.put(student_list[i], 1);
            } else {
                map.put(student_list[i], m + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                single_student_number = key;
            }
        }
        return single_student_number;
    }

    public static void main(String[] str) {
        FindTheSingletone s = new FindTheSingletone();
        int[] parameters = {5, 3, 2, 2, 3, 5, 4, 6, 9, 6, 4, 12, 8, 9, 12};
        Assert.assertEquals(8, s.run(parameters));
    }
}