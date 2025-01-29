public class OrderItem {
    private MenuItem item;
    private String porsi;
    private int qty;
    private int price;

    public OrderItem(MenuItem item, String porsi, int qty) {
        this.item = item;
        this.porsi = porsi;
        this.qty = qty;
        this.price = item.getPrice() * qty; // Harga dihitung berdasarkan jumlah yang dipesan
    }

    public MenuItem getItem() {
        return item;
    }

    public String getPorsi() {
        return porsi;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }
}
