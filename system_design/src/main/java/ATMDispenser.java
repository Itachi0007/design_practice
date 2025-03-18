import java.util.*;

public class ATMDispenser {
    public static Map<Integer, Integer> withdrawAmount(int withdrawalAmount, Map<Integer, Integer> atmNotes) {
        Map<Integer, Integer> dispensedNotes = new LinkedHashMap<>();

        List<Integer> denominations = new ArrayList<>(atmNotes.keySet());
        denominations.sort(Collections.reverseOrder()); // Sort in descending order

        int remainingAmount = withdrawalAmount;

        for (int note : denominations) {
            if (remainingAmount <= 0) break;

            int availableNotes = atmNotes.get(note);
            int requiredNotes = remainingAmount / note;
            int notesToDispense = Math.min(requiredNotes, availableNotes);

            if (notesToDispense > 0) {
                dispensedNotes.put(note, notesToDispense);
                remainingAmount -= notesToDispense * note;
            }
        }

        return (remainingAmount == 0) ? dispensedNotes : Collections.emptyMap(); // Return empty if not possible
    }

    public static void main(String[] args) {
        Map<Integer, Integer> atmNotes = new HashMap<>();
        atmNotes.put(100, 5);
        atmNotes.put(50, 3);
        atmNotes.put(20, 2);
        atmNotes.put(10, 1);

        int withdrawalAmount = 270;
        Map<Integer, Integer> result = withdrawAmount(withdrawalAmount, atmNotes);

        if (!result.isEmpty()) {
            System.out.println("Dispensed Notes: " + result);
        } else {
            System.out.println("ATM cannot fulfill the request.");
        }
    }
}