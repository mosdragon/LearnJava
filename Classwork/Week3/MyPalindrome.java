public class MyPalindrome {
    public static void main(String[] args) {
        String s = args[0];
        s = s.trim();
        s = s.toUpperCase();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[,.?!]", "");
        System.out.printf("%s normalized is: %s%n", args[0], s);
        boolean isPalindrome = true;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
            }
        }
        String verdict = (isPalindrome) ? "is a Palindome" : "is not a Palindrome";
        System.out.printf("The verdict: %s %s.%n", args[0], verdict);
    }           
}