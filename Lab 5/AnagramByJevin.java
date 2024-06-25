import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class AnagramByJevin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        String[] arr = new String[5];
        System.out.println("Enter words : ");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next();
        }

        int ind = ran.nextInt(5);
        String word = arr[ind];

        System.out.println("\nGenerated word : " + word);
        System.out.print("\nEnter a word for anagram : ");
        String uWord = sc.next();

        int l1 = word.length(), l2 = uWord.length();
        if (l1 != l2) {
            System.out.println("Not Anagram");
            System.exit(0);
        }

        if (anagram1(word, uWord, l1, l2)) {
            System.out.println("Yes, Anagram");
        }
        else {
            System.out.println("Not Anagram.");
        }

        if (anagram2(word, uWord, l1, l2)) {
            System.out.println("Yes, Anagram");
        }
        else {
            System.out.println("Not Anagram.");
        }


        sc.close();
    }
    public static boolean anagram1(String word, String uWord, int l1, int l2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < l1; i++) {
            boolean not = true;
            for (int j = 0; j < l2; j++) {
                if (word.charAt(i) == uWord.charAt(j) && !list.contains(j)) {
                        list.add(j);
                        not = false;
                        break;
                }
            }
            if (not) {
                return false;
            }
        }
        return true;
    }
    public static boolean anagram2(String word, String uWord, int l1, int l2) {
        word = word.toLowerCase();
        uWord = uWord.toLowerCase();
        int c1[] = new int[26];

        for (char c : word.toCharArray()) {
            c1[c-97]++;
        }
        for (char c : uWord.toCharArray()) {
            c1[c-97]--;
        }
        for (int i : c1) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
}
