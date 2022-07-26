package p3;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Chat application..
 *
 * The chat application can deduct the abusive language and convert into different format
 *
 *  Hello idiot how are you. You are stupid
 *  Hello ##### how are you. You are ######
 */
public class ChatApp {
    public static void main(String[] args) {
        Set<String> abusiveWords = new HashSet<>();
        abusiveWords.add("idiot");
        abusiveWords.add("stupid");

        String str = "Hello idiot how are you. You are stupid ";

        StringTokenizer words = new StringTokenizer(str);

        while(words.hasMoreTokens()){
            String str1 = words.nextToken();
            if(abusiveWords.contains(str1)){
                for(int j = 0; j < str1.length(); j++){
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            else System.out.print(str1 + " ");
        }



    }
}
