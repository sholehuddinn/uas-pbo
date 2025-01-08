# Sistem Informasi Restoran

## Deskripsi Proyek

Sistem Informasi Restoran ini dikembangkan menggunakan React.js sebagai frontend, Express.js sebagai backend, dan MongoDB sebagai basis data. Sistem ini dirancang untuk mengelola data restoran seperti menu, pemesanan, dan pembuatan nota, serta dilengkapi dengan autentikasi login kasir.

## Fitur Utama

1. **Manajemen Menu**: Tambah, edit, dan hapus data menu.
2. **Pemesanan**: Buat dan kelola pesanan pelanggan.
3. **Pembuatan Nota**: Cetak nota dengan informasi kasir yang bertugas.
4. **Autentikasi Login**: Sistem login sederhana tanpa JWT, menggunakan nama dan password kasir.

## Teknologi yang Digunakan

- **Frontend**: React.js, Tailwind CSS, DaisyUI
- **Backend**: Springboot
- **Database**: MongoDB

## Instalasi

1. Clone repositori ini:
   ```bash
   git clone <repository-url >
   ```
2. Masuk ke direktori proyek:
   ```bash
   cd sistem-informasi-restoran
   ```
3. Instal dependensi untuk backend:
   ```bash
   cd backend
   npm install
   ```
4. Instal dependensi untuk frontend:
   ```bash
   cd ../frontend
   npm install
   ```

## Menjalankan Aplikasi

1. Jalankan backend:
   ```bash
   cd backend
   npm start
   ```
2. Jalankan frontend:
   ```bash
   cd ../frontend
   npm start
   ```
3. Buka browser dan akses aplikasi di [http://localhost:3000](http://localhost:3000).

## Struktur Proyek

```
.
├── backend
│   ├── models
│   ├── repository
│   ├── controllers
│   ├── service
│   └── backend.java
├── frontend
│   ├── src
│   │   ├── components
│   │   ├── pages
│   │   ├── App.js
│   │   └── index.js
│   └── public
├── README.md
└── package.json
```

## Akun Login Default

Berikut adalah data akun default untuk login kasir:

- **Nama**: admin
- **Password**: admin123

## Catatan

- Pastikan MongoDB telah terpasang dan berjalan di sistem Anda.
- Ubah pengaturan database di file `backend/config/db.js` sesuai dengan konfigurasi lokal Anda.

## Lisensi

Proyek ini menggunakan lisensi MIT. Silakan lihat file `LICENSE` untuk detail lebih lanjut.

---

**Kontributor:**

- Muhammad Fajar Sholehuddin Maulana Putra (202311420008)
- Hilmi Zavier Ar rosyid (202311420023)
- Allansyah Brawinatha (202311420008)
- Alleandro Sheva Denny Agoestinus (202311420023)

---

Jika Anda memiliki pertanyaan atau menemukan bug, silakan ajukan di bagian Issues pada repositori ini.

