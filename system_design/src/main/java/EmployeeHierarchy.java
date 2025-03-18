import java.util.*;

public class EmployeeHierarchy {
    public static void printEmployeeLevels(List<String[]> relationships) {
        Map<String, List<String>> managerToEmployees = new HashMap<>();
        Set<String> employees = new HashSet<>();

        // Build Employee-Manager Mapping
        for (String[] pair : relationships) {
            String employee = pair[0], manager = pair[1];
            managerToEmployees.computeIfAbsent(manager, k -> new ArrayList<>()).add(employee);
            employees.add(employee);
        }

        // Find the CEO (who is not in the employee list)
        String CEO = null;
        for (String manager : managerToEmployees.keySet()) {
            if (!employees.contains(manager)) {
                CEO = manager;
                break;
            }
        }

        // Level-order traversal (BFS)
        Queue<String> queue = new LinkedList<>();
        queue.offer(CEO);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Level " + level + ": ");
            List<String> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                String manager = queue.poll();
                currentLevel.add(manager);
                if (managerToEmployees.containsKey(manager)) {
                    queue.addAll(managerToEmployees.get(manager));
                }
            }

            System.out.println(String.join(" ", currentLevel));
            level++;
        }
    }

    public static void main(String[] args) {
        List<String[]> relationships = Arrays.asList(
                new String[]{"Bob", "Alice"}, new String[]{"Charlie", "Alice"}, new String[]{"David", "Alice"},
                new String[]{"Eve", "Bob"}, new String[]{"Frank", "Bob"}, new String[]{"Grace", "Bob"},
                new String[]{"Helen", "Charlie"}, new String[]{"Irene", "Charlie"}, new String[]{"Jack", "Charlie"},
                new String[]{"Karen", "David"}, new String[]{"Larry", "David"}, new String[]{"Mike", "David"},
                new String[]{"Nancy", "Eve"}, new String[]{"Oscar", "Frank"}, new String[]{"Peter", "Grace"},
                new String[]{"Quinn", "Helen"}, new String[]{"Rachel", "Irene"}, new String[]{"Sam", "Jack"},
                new String[]{"Tim", "Karen"}, new String[]{"Uma", "Larry"}
        );

        printEmployeeLevels(relationships);
    }
}