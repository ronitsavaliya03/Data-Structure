import java.util.Scanner; 
import java.util.Random;
import java.util.ArrayList;

public class Anagram {
    public static void main(String[] args) {

        // Scanner sc=new Scanner(System.in);
        // String word=sc.nextLine();

        // int array[]=new int[25];
        // int lenght=((int)(Math.random()*args.length));

        // String random=args[lenght];

        // System.out.println(random);

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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < l1; i++) {
            boolean check = false;
            for (int j = 0; j < l2; j++) {
                if (word.charAt(i) == uWord.charAt(j)) {
                    if (!list.contains(j)) {
                        System.out.println("Yes " + uWord.charAt(j) + "'s index " + j);
                        list.add(j);
                        check = true;
                        break;
                    }
                }
            }
            if (!check) {
                System.out.println("Not Anagram.");
                System.exit(0);
            }
        }
        System.out.println("Yes, Anagram");
        sc.close();
    }
}
