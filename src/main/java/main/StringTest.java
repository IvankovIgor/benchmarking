package main;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void hey() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            strings.add("hello");
        }
        strings.clear();
//        System.out.println(strings);
    }
}
