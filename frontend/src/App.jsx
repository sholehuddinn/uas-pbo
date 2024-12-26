import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
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
  
  const pay = () => {
    // Pastikan token ini diperoleh dari backend Anda
    const transactionToken = 'c2fef9d5-bffd-4e52-9e4d-5ba3f507e68b'; // Token transaksi yang benar
//                            c7eaf832-a721-4030-970e-c411c9929807
    // Memanggil Snap API untuk melakukan pembayaran
    window.snap.pay(transactionToken, {
      onSuccess: function(result) {
        console.log("Payment Success:", result);
      },
      onPending: function(result) {
        console.log("Payment Pending:", result);
      },
      onError: function(result) {
        console.log("Payment Error:", result);
      },
      onClose: function() {
        console.log("Customer closed the popup");
      }
    });
  }

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

export default App;
