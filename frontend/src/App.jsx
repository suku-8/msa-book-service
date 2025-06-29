import { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Router from "./router/Router";
import { getPoint } from './api/pointApi'; // 1. 방금 만든 pointApi를 가져옵니다.

function App() {
  // 2. 서버에서 받아온 포인트 정보를 저장할 공간(state)을 만듭니다.
  const [pointInfo, setPointInfo] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  // 3. 컴포넌트가 처음 실행될 때 딱 한 번만 API를 호출합니다.
  useEffect(() => {
    const fetchPoint = async () => {
      try {
        // ID가 1인 사용자의 포인트를 조회합니다.
        const response = await getPoint(1); 
        setPointInfo(response.data); // 성공하면 데이터를 저장합니다.
      } catch (e) {
        setError(e); // 실패하면 에러를 저장합니다.
      } finally {
        setIsLoading(false); // 로딩 상태를 끝냅니다.
      }
    };

    fetchPoint();
  }, []);

  return (
    <BrowserRouter>
      <header style={{ padding: "12px 24px", background: "#333" }}>
        <Link to="/" style={{ color: "#fff", textDecoration: "none", fontWeight: "bold" }}>
          AI IN 서재
        </Link>
      </header>

      {/* --- 4. API 호출 결과를 화면에 표시하는 부분 --- */}
      <div style={{ padding: "24px" }}>
        <h2>백엔드 연동 테스트</h2>
        {isLoading && <p>포인트 정보 로딩 중...</p>}
        {error && <p>에러 발생: {error.message}</p>}
        {pointInfo && (
          <div>
            <h3>User ID: 1의 현재 포인트 정보</h3>
            <pre style={{ background: '#f4f4f4', padding: '16px' }}>
              {JSON.stringify(pointInfo, null, 2)}
            </pre>
          </div>
        )}
      </div>
      {/* ------------------------------------------- */}
      
      <Routes>
        <Route path="/*" element={<Router />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;