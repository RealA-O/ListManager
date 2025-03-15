import java.util.*;

public class ListManager {
    private static Map<String, List<String>> lists = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nList Manager");
            System.out.println("1. Create a new list");
            System.out.println("2. Delete a list");
            System.out.println("3. Add variable to a list");
            System.out.println("4. Remove variable from a list");
            System.out.println("5. Display all lists");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // leads to which function

            switch (choice) {
                case 1:
                    createList();
                    break;
                case 2:
                    deleteList();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    displayLists();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createList() {
        System.out.print("Enter list name: ");
        String name = scanner.nextLine();
        if (lists.containsKey(name)) {
            System.out.println("List already exists!");
        } else {
            lists.put(name, new ArrayList<>());
            System.out.println("List made successfully.");
        }
    }

    private static void deleteList() {
        System.out.print("Enter list name to delete: ");
        String name = scanner.nextLine();
        if (lists.remove(name) != null) {
            System.out.println("List deleted successfully.");
        } else {
            System.out.println("List not found.");
        }
    }

    private static void addItem() {
        System.out.print("Enter list name: ");
        String name = scanner.nextLine();
        if (!lists.containsKey(name)) {
            System.out.println("List not found!");
            return;
        }
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine();
        lists.get(name).add(item);
        System.out.println("Item added.");
    }

    private static void removeItem() {
        System.out.print("Enter list name: ");
        String name = scanner.nextLine();
        if (!lists.containsKey(name)) {
            System.out.println("List not found!");
            return;
        }
        System.out.print("Enter item to remove: ");
        String item = scanner.nextLine();
        if (lists.get(name).remove(item)) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found in list.");
        }
    }

    private static void displayLists() {
        if (lists.isEmpty()) {
            System.out.println("No lists available.");
        } else {
            for (Map.Entry<String, List<String>> entry : lists.entrySet()) {
                System.out.println("List: " + entry.getKey());
                System.out.println("Items: " + entry.getValue());
            }
        }
    }
}
