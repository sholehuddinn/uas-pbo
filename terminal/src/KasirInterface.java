import java.util.*;

class KasirInterface {
  private Scanner scanner;
  private OrderSystem orderSystem;

  public KasirInterface(Scanner scanner, OrderSystem orderSystem) {
    this.scanner = scanner;
    this.orderSystem = orderSystem;
  }

  public void showMenu() {
    boolean isKasirLoggedIn = true;
    while (isKasirLoggedIn) {
      List<OrderItem> order = new ArrayList<>();
      while (true) {
        System.out.println("\n=== Menu Kasir ===");
        orderSystem.displayMenu();
        System.out.println("\n1. Pilih Item");
        System.out.println("2. Selesai dan Cetak Nota");
        System.out.println("3. Logout");
        System.out.print("Pilihan: ");

        if (!scanner.hasNextInt()) {
          System.out.println("Input harus berupa angka. Coba lagi.");
          scanner.next();
          continue;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
          while (true) {
            System.out.print("Masukkan nomor item yang dipilih: ");
            if (!scanner.hasNextInt()) {
              System.out.println("Input harus berupa angka. Coba lagi.");
              scanner.next();
              continue;
            }
            int itemNumber = scanner.nextInt();
            scanner.nextLine();

            if (itemNumber > 0 && itemNumber <= orderSystem.getMenuItems().size()) {
              MenuItem selectedItem = orderSystem.getMenuItems().get(itemNumber - 1);
              System.out.print("Porsi: ");
              String porsi = scanner.nextLine();
              System.out.print("Quantity: ");
              if (!scanner.hasNextInt()) {
                System.out.println("Quantity harus berupa angka. Coba lagi.");
                scanner.next();
                continue;
              }
              int qty = scanner.nextInt();
              scanner.nextLine();

              order.add(new OrderItem(selectedItem, porsi, qty));
              System.out.println("Item berhasil ditambahkan: " + selectedItem.getName());
            } else {
              System.out.println("Nomor item tidak valid.");
            }

            System.out.print("Tambah item lagi? (iya/tidak): ");
            if (!scanner.nextLine().toLowerCase().equals("iya")) {
              break;
            }
          }
        } else if (choice == 2) {
          System.out.println("\n=== Nota Pembelian ===");
          int totalHarga = 0;
          for (OrderItem orderItem : order) {
            System.out.println("- " + orderItem.getItem().getName() +
                " | Porsi: " + orderItem.getPorsi() +
                " | Qty: " + orderItem.getQty() +
                " | Harga: Rp" + orderItem.getPrice());
            totalHarga += orderItem.getPrice();
          }
          System.out.println("Total: Rp" + totalHarga);
          break;
        } else if (choice == 3) {
          System.out.println("Logout berhasil.");
          isKasirLoggedIn = false;
          break;
        } else {
          System.out.println("Pilihan tidak valid.");
        }
      }
    }
  }
}
