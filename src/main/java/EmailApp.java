import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the firstname : ");
        String firstname = sc.next();
        System.out.print("Enter the lastname : ");
        String lastname = sc.next();

        Email mail = new Email(firstname, lastname);
        System.out.println(mail.showInfo());
    }
}
