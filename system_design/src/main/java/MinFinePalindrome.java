public class MinFinePalindrome {

    // Clarify questions like -
    // what will be the output in case of - 999, 808 ?
    private static int findNextPalindrome(int N) {
        char[] numArr = String.valueOf(N).toCharArray();
        int len = numArr.length;
        int left = 0, right = len - 1;

        // Step 1: Make the number a palindrome by copying left side to right
        while (left < right) {
            numArr[right] = numArr[left];
            left++;
            right--;
        }

        // Step 2: Check if palindrome is >= N
        int newPalindrome = Integer.parseInt(new String(numArr));
        if (newPalindrome >= N) return newPalindrome;

        // Step 3: If not, increment the middle part and adjust
        int mid = len / 2;
        while (mid >= 0 && numArr[mid] == '9') {
            numArr[mid] = '0';
            if (len % 2 == 0) numArr[len - mid - 1] = '0';  // Mirror change
            mid--;
        }
        if (mid >= 0) {
            numArr[mid]++;
            if (len % 2 == 0) numArr[len - mid - 1] = numArr[mid];  // Mirror change
        } else {
            // If all digits were 9 (e.g., 999 → 1001), add '1' at start & end
            return Integer.parseInt("1" + "0".repeat(len - 1) + "1");
        }

        return Integer.parseInt(new String(numArr));
    }

    public static void main(String[] args) {
        System.out.println(findNextPalindrome(125));
        System.out.println(findNextPalindrome(250));
        System.out.println(findNextPalindrome(123));
        System.out.println(findNextPalindrome(397));
        System.out.println(findNextPalindrome(4512));
        System.out.println(findNextPalindrome(1234));
        System.out.println(findNextPalindrome(1997));
        System.out.println(findNextPalindrome(999));
    }
}