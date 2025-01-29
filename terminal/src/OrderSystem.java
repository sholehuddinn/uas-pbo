import java.util.*;

class OrderSystem {
  private List<MenuItem> menuItems;

  public OrderSystem() {
      menuItems = new ArrayList<>();
      // Predefined menu items
      menuItems.add(new Food("Ayam Geprek", 12000));
      menuItems.add(new Food("Ayam Panggang", 9000));
      menuItems.add(new Drink("Es Teh", 20000));
  }

  public void addMenuItem(MenuItem item) {
      menuItems.add(item);
  }

  public void removeMenuItem(String name) {
      menuItems.removeIf(item -> item.getName().equalsIgnoreCase(name));
  }
  

  public void displayMenu() {
      if (menuItems.isEmpty()) {
          System.out.println("Menu kosong. Tambahkan item terlebih dahulu.");
      } else {
          System.out.println("=== Menu ===");
          for (int i = 0; i < menuItems.size(); i++) {
              MenuItem item = menuItems.get(i);
              System.out.println((i + 1) + ". " + item.getName() + " | Rp. " + item.getPrice());
          }
      }
  }

  public List<MenuItem> getMenuItems() {
      return menuItems;
  }

  public int calculateTotal(List<MenuItem> order) {
    int total = 0;
    for (MenuItem item : order) {
        total += item.getPrice();
    }
    return total;
}
}