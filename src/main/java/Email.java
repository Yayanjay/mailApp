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
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;

    // constructor firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        System.out.println("Hi, " + fullName + "\n");

        this.department = setDepartment();
//        System.out.println("The Department is \t\t" + this.department);

        this.password = randomPassword(defaultPasswordLength);
//        System.out.println("The Password is \t\t" + this.password);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyDomain;
//        System.out.printf("The Company Email is \t" + email);
    }

    // choose department
    private String setDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Department lists are, \n1. Sales \n2. Development \n3. Accounting \ntype the number : ");

        int deptChosen = sc.nextInt();
        if (deptChosen == 1) {
            return "sales";
        } else if (deptChosen == 2) {
            return "development";
        } else if (deptChosen == 3) {
            return "accounting";
        } else {
            return "no dept is choosen";
        }

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
        return "\nDisplay Name \t\t: " + firstName + " " + lastName +
                "\nCompany Email \t\t: " + email +
                "\nMailbox Capacity \t: " + mailboxCapacity + "mb" +
                "\n\n" + "Welcome " + fullName + ", You're in " + department + " department!";
    }
}
