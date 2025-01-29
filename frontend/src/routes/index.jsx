import { createBrowserRouter } from "react-router-dom";
import Home from '../pages/home.jsx'
// import Midtrans from "../pages/midtrans.jsx";


const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
]);

export default router;
