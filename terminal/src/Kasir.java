class Kasir extends User {
  public Kasir(String username, String password) {
      super(username, password);
  }

  @Override
  public void showMenu() {
      System.out.println("\n=== Menu Kasir ===");
      System.out.println("1. Pilih Item");
      System.out.println("2. Selesai dan Cetak Nota");
      System.out.println("3. Logout");
  }
}
