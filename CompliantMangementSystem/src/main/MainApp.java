package main;

import service.ComplaintService;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        while (true) {
            System.out.println("\n=== Complaint Management System ===");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Issue: ");
                    String issue = sc.nextLine();
                    service.register(name, issue);
                    break;

                case 2:
                    service.display();
                    break;

                case 3:
                    System.out.print("Enter Complaint ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Status (Resolved/In Progress): ");
                    String status = sc.nextLine();
                    service.update(id, status);
                    break;

                case 4:
                    System.out.print("Enter Complaint ID: ");
                    int delId = sc.nextInt();
                    service.delete(delId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}