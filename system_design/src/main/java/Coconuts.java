public class Coconuts {
    static boolean distribute(int N) {
        if (N < 4) return false;  // Smallest valid N is 4 (2+2)
        if (N % 2 == 0) return true;  // All even numbers > 3 are valid

        // Check factors only for odd numbers
        for (int E = 3; E * E <= N; E += 2) {  // Skip even numbers
            if (N % E == 0) {
                int factor1 = E;
                int factor2 = N / E;

                // Check if either factor is a valid number of elephants
                if (factor1 >= 2 && (N / factor1) >= 2) return true;
                if (factor2 >= 2 && (N / factor2) >= 2) return true;
            }
        }

        return false;
    }
}