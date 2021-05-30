package SetTest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @className FileOperation
 * @Author lulu
 * @Date 2019/12/7 8:22 上午
 * 文件相关操作
 **/
public class FileOperation {

    // 读取文件名称为fileName中的内容，并将其中包含的所有词语放进words中
    public static boolean readFile(String fileName, ArrayList<String> words) {
        if (fileName == null || words == null) {
            System.out.println("file name is null or words is null");
            return false;
        }
        // 文件读取
        Scanner scanner;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Cannot open" + fileName);
            return false;
        }

        // 简单分词
        if (scanner.hasNextLine()) {
             String contents = scanner.useDelimiter("\\A").next();
             int start = firstCharacterIndex(contents, 0);
            for (int i = start+1; i < contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start+1;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

    // 寻找字符串s中，从start位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }
}




























