//frontend/src/pointApi.js

import axios from "axios";

// API 게이트웨이 주소를 기본 URL로 설정합니다.
const apiClient = axios.create({
  baseURL: "https://8088-suku8-msabookservice-hw3y5b3m0wj.ws-us120.gitpod.io", // 중요: 개별 서비스(8085)가 아닌 게이트웨이(8088) 주소입니다.
  headers: {
    "Content-Type": "application/json",
  },
});

// 포인트 정보를 조회하는 함수
export const getPoint = (userId) => apiClient.get(`/points/${userId}`);

// (나중에 추가할) 포인트 충전 함수
// export const addPoint = (userId, amount) => apiClient.put(`/points/${userId}/addpoint`, { amount });

export default apiClient;