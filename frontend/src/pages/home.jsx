import React, { useEffect, useState } from 'react';
import FoodCard from '../components/card';
import axios from 'axios';
import Swal from 'sweetalert2';

const Home = () => {
  const [foodItems, setFoodItems] = useState([]);
  const [cart, setCart] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:2000/api/menu')
      .then(res => setFoodItems(res.data))
      .catch(err => console.log(err));
  }, []);

  const handleAddToCart = (item) => {
    let variantOptions = [];

    if (item.kategori === 'makanan') {
      variantOptions = ['Pedas', 'Sedang', 'Biasa'];
    } else if (item.kategori === 'minuman') {
      variantOptions = ['Gelas Besar', 'Gelas Kecil', 'Panas', 'Dingin'];
    }

    Swal.fire({
      title: `Pilih variant untuk ${item.namaMenu}`,
      input: 'select',
      inputOptions: variantOptions.reduce((acc, curr, idx) => {
        acc[idx + 1] = curr;
        return acc;
      }, {}),
      inputPlaceholder: 'Pilih variant',
      showCancelButton: true,
      inputValidator: (value) => {
        if (!value) {
          return 'Harap pilih variant!';
        }
      }
    }).then((result) => {
      if (result.isConfirmed) {
        const updatedItem = {
          ...item,
          variant: [variantOptions[result.value - 1]],
          quantity: 1,
          total: item.harga
        };
        setCart([...cart, updatedItem]);
      }
    });
  };

  const handleCheckout = () => {
    const orderData = {
      name: "Nama Kasir",
      kursi: "A1",
      catatan: "Catatan",
      status: "Pending",
      item: cart.map(item => ({
        productId: item.productId,
        name: item.namaMenu,
        quantity: item.quantity,
        price: item.harga,
        total: item.total,
        variant: item.variant
      })),
      gross_amount: cart.reduce((total, item) => total + item.total, 0),
      order_id: "123456"
    };

    axios.post('http://localhost:2000/api/order', orderData)
      .then(response => {
        Swal.fire('Pesanan berhasil', 'Pesanan telah dikirim ke dapur.', 'success');
        setCart([]);
      })
      .catch(error => {
        Swal.fire('Terjadi kesalahan', 'Gagal mengirimkan pesanan.', 'error');
      });
  };

  return (
    <div className="min-h-screen bg-green-50 p-4">
      <h1 className="text-2xl font-bold text-center mb-6 text-green-700">Menu Makanan</h1>
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
        {foodItems.map((props, index) => (
          <FoodCard
            key={index}
            title={props.namaMenu}
            image={`http://localhost:2000/image/${props.gambar}`}
            price={props.harga}
            onAddToCart={() => handleAddToCart(props)}
          />
        ))}
      </div>

      {/* UI Cart dengan Tema Hijau */}
      {cart.length > 0 && (
        <div className="fixed bottom-0 left-0 right-0 bg-green-600 text-white shadow-lg p-4 rounded-t-lg">
          <h3 className="text-lg font-semibold">Keranjang</h3>
          <ul className="space-y-2">
            {cart.map((item, index) => (
              <li key={index} className="flex justify-between items-center">
                <span>{item.namaMenu} - {item.variant[0]}</span>
                <span>Rp {item.total}</span>
              </li>
            ))}
          </ul>
          <div className="mt-4 flex justify-between items-center">
            <button
              className={`px-4 py-2 bg-green-800 text-white rounded ${cart.length === 0 ? 'opacity-50 cursor-not-allowed' : ''}`}
              onClick={handleCheckout}
              disabled={cart.length === 0}
            >
              Checkout
            </button>
            <span className="text-lg font-semibold">
              Total: Rp {cart.reduce((total, item) => total + item.total, 0)}
            </span>
          </div>
        </div>
      )}
    </div>
  );
};

export default Home;
