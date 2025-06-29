// src/App.jsx

import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Router from "./router/Router";

function App() {
  return (
    <BrowserRouter>
      <header style={{ padding: "12px 24px", background: "#333" }}>
        <Link to="/" style={{ color: "#fff", textDecoration: "none", fontWeight: "bold" }}>
          도서 관리 시스템
        </Link>
      </header>

      <Routes>
        <Route path="/*" element={<Router />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
