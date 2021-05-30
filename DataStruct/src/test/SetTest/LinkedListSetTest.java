package SetTest;

import Set.LinkedListSet;

import java.util.ArrayList;

/**
 * @className SetTest
 * @Author lulu
 * @Date 2019/12/7 8:47 上午
 **/
public class LinkedListSetTest {
    public static void main(String[] args) {

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("/Users/lulu/Desktop/DataStruct/DataStruct/src/test/SetTest/a-tale-of-two-cities.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("/Users/lulu/Desktop/DataStruct/DataStruct/src/test/SetTest/pride-and-prejudice.txt", words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
