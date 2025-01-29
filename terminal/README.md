# Sistem Restoran Berbasis Java

## 📌 Deskripsi

Aplikasi ini adalah sistem pemesanan restoran berbasis Java yang mendukung fitur login untuk admin dan kasir. Admin dapat mengelola menu makanan dan minuman, sementara kasir dapat mencatat pesanan pelanggan dan mencetak nota pembayaran.

## 🚀 Fitur Utama

- **Login Sistem**: Autentikasi pengguna dengan role `admin` dan `kasir`.
- **Manajemen Menu** (Admin):
  - Tambah menu makanan/minuman.
  - Hapus menu makanan/minuman.
  - Lihat daftar menu.
- **Pemrosesan Pesanan** (Kasir):
  - Memilih item makanan/minuman berdasarkan nomor.
  - Menentukan porsi dan jumlah pesanan.
  - Mencetak nota dengan total harga.

## 📂 Struktur Proyek

```
resto/
├── App.java            # Program utama
├── LoginSystem.java    # Sistem autentikasi
├── OrderSystem.java    # Manajemen menu dan pesanan
├── MenuItem.java       # Kelas dasar untuk makanan/minuman
├── Food.java           # Kelas makanan
├── Drink.java          # Kelas minuman
├── OrderItem.java      # Kelas untuk item dalam pesanan
└── README.md           # Dokumentasi proyek
```

## 🔧 Cara Menjalankan

1. **Clone repositori atau buat folder proyek**:
   ```sh
   git clone https://github.com/username/resto-java.git
   cd resto-java
   ```
2. **Kompilasi semua file Java**:
   ```sh
   javac resto/*.java
   ```
3. **Jalankan aplikasi**:
   ```sh
   java resto.App
   ```

## 👤 Akun Default

| Username | Password | Role  |
| -------- | -------- | ----- |
| admin    | 123      | Admin |
| kasir    | 123      | Kasir |

## 📌 Contoh Penggunaan

**Admin Menambahkan Menu:**

```
=== Login ===
Username: admin
Password: admin123

=== Menu Admin ===
1. Tambah Menu
2. Hapus Menu
3. Lihat Menu
4. Logout
Pilihan: 1
Nama item: Nasi Goreng
Harga: 25000
Jenis (1. Makanan / 2. Minuman): 1
```

**Kasir Memesan dan Mencetak Nota:**

```
=== Login ===
Username: kasir
Password: kasir123

=== Menu Kasir ===
1. Pilih Item
2. Selesai dan Cetak Nota
3. Logout
Pilihan: 1
Masukkan nomor item yang dipilih: 1
Porsi: Jumbo
Quantity: 2
Tambah item lagi? (iya/tidak): tidak

=== Nota Pembelian ===
- Nasi Goreng | Porsi: Jumbo | Qty: 2 | Harga: Rp50000
Total: Rp50000
```

## 📌 Lisensi

Proyek ini bebas digunakan untuk keperluan belajar dan pengembangan lebih lanjut.

