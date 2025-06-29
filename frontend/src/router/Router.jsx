// src/router/Router.jsx
import { Routes, Route } from "react-router-dom";
import BookList from "../pages/BookList";

const Router = () => (
  <Routes>
    <Route path="/" element={<BookList />} />
    <Route path="/books" element={<BookList />} />
    <Route path="*" element={<div>404 Not Found</div>} />
  </Routes>
);

export default Router;
