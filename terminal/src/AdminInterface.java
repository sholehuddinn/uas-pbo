import java.util.*;

class AdminInterface {
  private Scanner scanner;
  private OrderSystem orderSystem;

  public AdminInterface(Scanner scanner, OrderSystem orderSystem) {
    this.scanner = scanner;
    this.orderSystem = orderSystem;
  }

  public void showMenu() {
    while (true) {
      System.out.println("\n=== Menu Admin ===");
      System.out.println("1. Tambah Menu");
      System.out.println("2. Hapus Menu");
      System.out.println("3. Lihat Menu");
      System.out.println("4. Logout");
      System.out.print("Pilihan: ");

      if (!scanner.hasNextInt()) {
        System.out.println("Input harus berupa angka. Coba lagi.");
        scanner.next();
        continue;
      }

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Nama item: ");
          String name = scanner.nextLine();
          System.out.print("Harga: ");
          if (!scanner.hasNextInt()) {
            System.out.println("Harga harus berupa angka. Coba lagi.");
            scanner.next();
            continue;
          }
          int price = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Jenis (1. Makanan / 2. Minuman): ");
          if (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka. Coba lagi.");
            scanner.next();
            continue;
          }
          int type = scanner.nextInt();
          scanner.nextLine();

          if (type == 1) {
            orderSystem.addMenuItem(new Food(name, price));
          } else if (type == 2) {
            orderSystem.addMenuItem(new Drink(name, price));
          } else {
            System.out.println("Jenis tidak valid.");
          }
          break;
        case 2:
          System.out.print("Nama item yang akan dihapus: ");
          String itemName = scanner.nextLine();
          orderSystem.removeMenuItem(itemName);
          break;
        case 3:
          orderSystem.displayMenu();
          break;
        case 4:
          return;
        default:
          System.out.println("Pilihan tidak valid.");
      }
    }
  }
}