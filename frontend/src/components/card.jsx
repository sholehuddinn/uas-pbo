import React from 'react';

const FoodCard = ({ title, image, price, onAddToCart }) => {
  return (
    <div className="bg-white p-4 rounded-lg shadow-md max-w-xs mx-auto border border-green-300">
      <img src={image} alt={title} className="w-full h-40 object-cover rounded-md" />
      <h3 className="text-lg font-semibold mt-2 text-green-700">{title}</h3>
      <p className="text-gray-500">Rp {price}</p>
      <button
        onClick={onAddToCart}
        className="mt-4 px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600 w-full"
      >
        Tambah ke Keranjang
      </button>
    </div>
  );
};

export default FoodCard;
