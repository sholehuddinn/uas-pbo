class MenuItem {
  private String name;
  private int price;
  private String jenis;

  public MenuItem() {}

  public MenuItem(String name, int price, String Jenis) {
      this.name = name;
      this.price = price;
      this.jenis = Jenis;
  }

  public String getName() {
      return name;
  }

  public int getPrice() {
      return price;
  }

  public String getJenis() {
    return jenis;
  }

}