import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String fullName;
    private String password;
    private String department;
    private String companyDomain = "asylum.com";
    private String email;
    private String altEmail;
    private String[] departments = {"Human Resources", "Sales", "Finance", "Marketing", "IT"}; // change this if you want to edit the available departments
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;

    // constructor firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        System.out.println("\nHi, " + fullName + "\n");

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase().replaceAll("\\s+","") + "." + companyDomain;
    }

    // choose department
    private String setDepartment() {
        System.out.println("Available Departments:");
        for (int i = 0; i < departments.length; i++) {
            System.out.println((i + 1) + ". " + departments[i]);
        }

        // Get user input for department selection
        Scanner scanner = new Scanner(System.in);
        int selectedDepartment;
        do {
            System.out.print("Select department (1-" + departments.length + "): ");
            selectedDepartment = scanner.nextInt();
        } while (selectedDepartment < 1 || selectedDepartment > departments.length);

        // Match the user's input with the department from the list
        String department = departments[selectedDepartment - 1];
        System.out.println("Selected department: " + department);
        return department;
    }

    // generate password

    private String randomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * chars.length());
            password[i] = chars.charAt(rand);
        }

        return new String(password);
    }

    // set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // set alt email
    public void setAlternateEmail(String alt) {
        this.altEmail = alt;
    }

    public String getAlternateEmail() {
        return altEmail;
    }

    // change password
    public void setNewPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // show info
    public String showInfo() {
        if (department == null) {
            return "Cannot find the department, Please enter the correct number";
        } else {
            return "\nDisplay Name \t\t: " + firstName + " " + lastName +
                    "\nCompany Email \t\t: " + email +
                    "\nEmail Password \t\t: " + password + " (please change this immediately)" +
                    "\nMailbox Capacity \t: " + mailboxCapacity + "mb" +
                    "\n\n" + "Welcome " + fullName + ", You're in " + department + " department!";
        }
    }
}
