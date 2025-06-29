// src/api/bookApi.js

import axios from "axios";

// Axios 인스턴스 생성
const api = axios.create({
  baseURL: "http://localhost:8080/api/books",
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true, // ✅ 쿠키를 백엔드로 전달하게 설정
});

// 도서 전체 목록 조회
export const getBooks = () => api.get();

// 도서 상세 조회
export const getBook = (id) => api.get(`/${id}`);

// 도서 등록
export const createBook = (data) => api.post("", data);

// 도서 수정
export const updateBook = (id, data) => api.put(`/${id}`, data);

// 도서 삭제
export const deleteBook = (id) => api.delete(`/${id}`);

// 도서 표지 생성 (기능 확장용 API)
export const generateCover = (id) => api.post(`/${id}/generate-cover`);