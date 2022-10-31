
import java.util.*;
/*
 * Suppose I have "abbbccda" then it should return [1, 3]. Because it starts from index 1 and is 3 characters long. If the input string is empty then return [-1, 0].
Other Examples:
"10000111" => [ 1, 4 ]
"aabbbbbCdAA" => [ 2, 6 ]
 */
public class LongestUniformSubstr {
    public static void main(String[] args) {
        System.out.println((Arrays.toString(longestUniformSubstring("abbbccda"))));
        System.out.println("---------------------------");
        System.out.println((Arrays.toString(longestUniformSubstring("10000111"))));
        System.out.println("---------------------------");
        System.out.println((Arrays.toString(longestUniformSubstring("aabbbbbCdAA"))));
        System.out.println("---------------------------");
        System.out.println((Arrays.toString(longestUniformSubstring("aaaabbbbb"))));
    }
    public static int[] longestUniformSubstring(String str) {
        int longestStart=0;
        int start =0;
        int longestEnd=0;
        int length=0;
        int maxLength=0;

        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for(int end=1; end<str.length(); end++) {
            if(set.contains(str.charAt(end))) {
                length = end-start+1;
                if(length > maxLength) {
                    longestStart = start;
                    longestEnd = end;
                    maxLength = length;
                }
                System.out.println("cur char " + str.charAt(end) + " inside if - longestStart : " +  longestStart + " longestEnd _ "+ longestEnd + " length " + length+ " maxLen " + maxLength);
            }
            else {
                set.remove(str.charAt(start));
                start = end;
                // set.remove(str.charAt(end-1));
                set.add(str.charAt(end));
                System.out.println("set " + set.toString());
            }
            
        }

        return new int[] {longestStart, longestEnd};
    }

    public static int[] repeatedSubstring(String s){
        if(s.length() == 0) return new int[]{-1,0};
        if(s.length() == 1) return new int[]{0,1};
        int idx = -1;
        int maxCharCount = 0;
        int count = 1;
        int i;
        for(i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }else{
                if(count > maxCharCount){
                    maxCharCount = count;
                    idx = i - count;
                }
                count = 1;
            }
        }
        if(count > maxCharCount){
            maxCharCount = count;
            idx = i - count;
        }
       return new int[]{idx, maxCharCount};
}
}
