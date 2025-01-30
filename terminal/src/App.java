import java.util.*;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LoginSystem loginSystem = new LoginSystem();
    OrderSystem orderSystem = new OrderSystem();

    while (true) {
      System.out.println("=== Login ===");
      System.out.print("Username: ");
      String username = scanner.nextLine();
      System.out.print("Password: ");
      String password = scanner.nextLine();

      String role = loginSystem.login(username, password);

      if (role == null) {
        System.out.println("Login gagal. Username atau password salah.");
      } else if (role.equals("admin")) {
        AdminInterface adminInterface = new AdminInterface(scanner, orderSystem);
        adminInterface.showMenu();
      } else if (role.equals("kasir")) {
        KasirInterface kasirInterface = new KasirInterface(scanner, orderSystem);
        kasirInterface.showMenu();
      }
    }
  }
}
