class Admin extends User {
  public Admin(String username, String password) {
      super(username, password);
  }

  @Override
  public void showMenu() {
      System.out.println("\n=== Menu Admin ===");
      System.out.println("1. Tambah Menu");
      System.out.println("2. Hapus Menu");
      System.out.println("3. Lihat Menu");
      System.out.println("4. Logout");
  }
}