import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function midtrans() {
  const [count, setCount] = useState(0)

  useEffect(() => {
    // Render Midtrans Snap Token

    const snapScript = "https://app.sandbox.midtrans.com/snap/snap.js"
    const clientKey = "SB-Mid-client-X7kvxEDWRJwYhwz9"
    const script = document.createElement("script");
    script.src = snapScript
    script.setAttribute("data-client-key", clientKey)
    script.async = true

    document.body.appendChild(script);

    return () => {
      document.body.removeChild(script)
    };

  }, []);

  const getResult = async (result) => {
    try {
      const response = await fetch(`http://localhost:2000/api/v1/midtrans/result`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json', // Tentukan format data yang dikirim
        },
        body: JSON.stringify(result), // Kirim data sebagai JSON
      });
  
      // Cek apakah respon berhasil
      if (response.ok) {
        const responseData = await response.json(); // Mendapatkan data hasil dari backend
        console.log("Response from server:", responseData);
      } else {
        console.error("Error sending result to backend");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };
  
  const pay = () => {
    // Token transaksi yang benar, pastikan token ini valid dari backend
    const transactionToken = '1ae0d7b6-2fb2-4d59-8d9e-745b11773526'; 
  
    // Memanggil Snap API untuk melakukan pembayaran
    window.snap.pay(transactionToken, {
      onSuccess: function (result) {
        // Kirim hasil pembayaran setelah sukses
        getResult(result); // Kirim data pembayaran ke backend
      },
      onPending: function (result) {
        console.log("Payment Pending:", result); // Handle status pending
      },
      onError: function (result) {
        console.log("Payment Error:", result); // Handle error
      },
      onClose: function () {
        console.log("Customer closed the popup");
      }
    });
  };
  

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => pay()}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default midtrans;
