import java.util.Scanner;

public class Miku {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("______________________");
        System.out.println("Hello! I'm Miku!\n" + "What can I do for you?");
        System.out.println("______________________");

        String newItem = in.nextLine();
        Task[] storedList = new Task[100];
        int numberOfListItems = 0;

        while (!newItem.equals("bye")) {
            System.out.println("______________________");

            if (newItem.contains("list")) {
                System.out.println("Here are your list items!");
                for (int i = 0; i < numberOfListItems; i++) {
                    System.out.println((i + 1) + ". " + storedList[i].toString());
                }

                System.out.println("______________________");
                newItem = in.nextLine();
                continue;
            }

            if (newItem.contains("mark")) {
                boolean isUnmarking = newItem.contains("unmark");
                String[] markList = newItem.split(" ");
                int listNumberInt = Integer.parseInt(markList[1]);
                storedList[listNumberInt - 1].isDone = (!isUnmarking);

                System.out.println(isUnmarking ? "Aww... I've marked it as undone."
                        : "Good job~! I've marked it as done");
                System.out.println("[" + storedList[listNumberInt - 1].getStatusIcon()
                        + "] " + storedList[listNumberInt - 1].description + "\n");
                System.out.println("______________________");

                newItem = in.nextLine();
                continue;
            }

            if (newItem.contains("todo")) {
                String[] itemString = newItem.split("todo");
                storedList[numberOfListItems] = new Todo(itemString[1]);
                storedList[numberOfListItems].description = (itemString[1]);
            } else if (newItem.contains("deadline")) {
                String[] itemString = newItem.split("deadline|/by");
                storedList[numberOfListItems] = new Deadline(itemString[1], itemString[2]);
                storedList[numberOfListItems].description = (itemString[1]);
            } else if (newItem.contains("event")) {
                String[] itemString = newItem.split("event|/from|/to");
                storedList[numberOfListItems] = new Event(itemString[1], itemString[2], itemString[3]);
                storedList[numberOfListItems].description = (itemString[1]);
            }

            System.out.println("Got it! I've added this task:\n" + storedList[numberOfListItems].toString());
            numberOfListItems++;
            System.out.println("Now you have " + numberOfListItems + " tasks in the list!");
            System.out.println("______________________");
            newItem = in.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("______________________");
    }
}