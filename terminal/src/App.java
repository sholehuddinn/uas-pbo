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
                // Admin menu
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
                    scanner.nextLine(); // Consume newline

                    if (choice == 1) {
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
                    } else if (choice == 2) {
                        System.out.print("Nama item yang akan dihapus: ");
                        String name = scanner.nextLine();
                        orderSystem.removeMenuItem(name);
                    } else if (choice == 3) {
                        orderSystem.displayMenu();
                    } else if (choice == 4) {
                        break;
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
            } else if (role.equals("kasir")) {
                // Kasir menu
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

                                    // Tambahkan item ke dalam daftar pesanan
                                    OrderItem orderItem = new OrderItem(selectedItem, porsi, qty);
                                    order.add(orderItem);
                                    System.out.println("Item berhasil ditambahkan: " + selectedItem.getName());
                                } else {
                                    System.out.println("Nomor item tidak valid.");
                                }

                                System.out.print("Tambah item lagi? (iya/tidak): ");
                                String addMore = scanner.nextLine().toLowerCase();
                                if (!addMore.equals("iya")) {
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
                                totalHarga += orderItem.getPrice() ;
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

                    if (!isKasirLoggedIn) {
                        break;
                    }

                    if (!order.isEmpty()) {
                        order.clear();
                    }
                }
            }
        }
    }
}
