package SetTest;

import Set.Set;
import Set.LinkedListSet;
import Set.BstSet;

import java.util.ArrayList;

/**
 * @className LLSetVSBSet
 * @Author lulu
 * @Date 2019/12/7 3:38 下午
 **/
public class LLSetVSBSet {

    private static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("/Users/lulu/Desktop/DataStruct/DataStruct/src/test/SetTest/a-tale-of-two-cities.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            for (String word : words1)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "/Users/lulu/Desktop/DataStruct/DataStruct/src/test/SetTest/pride-and-prejudice.txt";

        LinkedListSet<String> set1 = new LinkedListSet();
        BstSet<String> set2 = new BstSet();

        System.out.println("LinkedListSet : "+testSet(set1, fileName));
        System.out.println("BstSet : "+testSet(set2, fileName));
    }
}
