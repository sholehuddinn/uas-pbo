class User {
  private String username;
  private String password;

  public User(String username, String password) {
      this.username = username;
      this.password = password;
  }

  public String getUsername() {
      return username;
  }

  public String getPassword() {
      return password;
  }

  public void showMenu() {
      // Default behavior for User, can be overridden by subclasses
      System.out.println("Menu umum tidak tersedia untuk role ini.");
  }
}