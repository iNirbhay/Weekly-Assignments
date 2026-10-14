import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static void countVowelsAndConsonants(String word) {
        if (word == null) return;
        int vowels = 0;
        int consonants = 0;
        String lower = word.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String word = sc.next();
            countVowelsAndConsonants(word);
        }
        sc.close();
    }
}
