import React, { useEffect, useState } from 'react';
import { Grid, Typography, Button, Box, TextField, CircularProgress, Alert } from '@mui/material';
import BookCard from '../components/BookCard';
import BookModal from '../components/BookModal';
import { getBooks, deleteBook, getBook, createBook, updateBook } from '../api/bookApi';

const BookList = () => {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [keyword, setKeyword] = useState("");

  // 모달 관련 상태
  const [modalOpen, setModalOpen] = useState(false);
  const [modalMode, setModalMode] = useState("create"); // "create" or "edit"
  const [editBookId, setEditBookId] = useState(null);
  const [editBookData, setEditBookData] = useState(null);

  // 도서 목록 불러오기
  const fetchBooks = async () => {
    try {
      setLoading(true);
      setError(null);
      const response = await getBooks();
      if (response.data && response.data.data) {
        setBooks(response.data.data);
      } else {
        setBooks([]);
        setError("도서 목록을 불러오는 데 실패했습니다.");
      }
    } catch (err) {
      console.error("도서 목록 조회 중 오류:", err);
      setError("서버 오류로 도서 목록을 불러올 수 없습니다.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  const filteredBooks = books.filter(book =>
    book.title.toLowerCase().includes(keyword.toLowerCase()) ||
    book.author.toLowerCase().includes(keyword.toLowerCase())
  );

  const handleDelete = async (id) => {
    const confirmDelete = window.confirm('정말로 이 도서를 삭제하시겠습니까?');
    if (!confirmDelete) return;
    try {
      await deleteBook(id);
      setBooks(prev => prev.filter(book => book.id !== id));
    } catch (err) {
      alert("삭제 실패: 서버 오류");
      console.error(err);
    }
  };

  // 등록 모달 열기
  const handleOpenCreate = () => {
    setModalMode("create");
    setEditBookId(null);
    setEditBookData(null);
    setModalOpen(true);
  };

  // 수정 모달 열기
  const handleOpenEdit = async (id) => {
    try {
      const response = await getBook(id);
      if (response.data && response.data.data) {
        setModalMode("edit");
        setEditBookId(id);
        setEditBookData(response.data.data);
        setModalOpen(true);
      } else {
        alert("도서 정보를 불러오지 못했습니다.");
      }
    } catch (err) {
      console.error("도서 조회 실패:", err);
      alert("도서 정보를 불러오는 데 실패했습니다.");
    }
  };

  // 등록/수정 완료 시
  const handleFormSubmit = async (data) => {
    try {
      if (modalMode === "create") {
        await createBook(data);
      } else if (modalMode === "edit" && editBookId) {
        await updateBook(editBookId, data);
      }
      setModalOpen(false);
      fetchBooks();
    } catch (err) {
      console.error("등록/수정 실패:", err);
      alert("등록 또는 수정 실패");
    }
  };

  return (
    <Box sx={{ px: { xs: 2, sm: 5, md: 10, lg: 35 }, py: 5, mx: 'auto' }}>
      <Box
        sx={{
          mb: 3,
          display: 'flex',
          flexDirection: { xs: 'column', sm: 'row' },
          justifyContent: 'space-between',
          alignItems: { xs: 'flex-start', sm: 'center' },
          gap: 2
        }}
      >
        <Typography variant="h4" fontWeight={600}>도서 목록</Typography>
        <Box
          sx={{
            display: 'flex',
            gap: 2,
            width: { xs: '100%', sm: 'auto' },
            flexDirection: { xs: 'column', sm: 'row' }
          }}
        >
          <TextField
            fullWidth={window.innerWidth < 600}
            size="small"
            placeholder="제목 또는 작가 검색"
            value={keyword}
            onChange={(e) => setKeyword(e.target.value)}
            sx={{ backgroundColor: '#fff' }}
          />
          <Button
            variant="contained"
            size="large"
            onClick={handleOpenCreate}
            sx={{ width: { xs: '100%', sm: 'auto' }, backgroundColor: '#5a9', color: '#fff',}}
          >
            새 도서 등록
          </Button>
        </Box>
      </Box>

      {loading ? (
        <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '200px' }}>
          <CircularProgress />
          <Typography sx={{ ml: 2 }}>도서 목록을 불러오는 중...</Typography>
        </Box>
      ) : error ? (
        <Alert severity="error" sx={{ my: 2 }}>{error}</Alert>
      ) : filteredBooks.length === 0 ? (
        <Alert severity="info" sx={{ my: 2 }}>
          {keyword ? "검색 결과가 없습니다." : "등록된 도서가 없습니다."}
        </Alert>
      ) : (
        <Grid container spacing={2} justifyContent="flex-start">
          {filteredBooks.map(book => (
            <Grid item xs={6} sm={4} md={3} lg={2} key={book.id}>
              <BookCard
                book={book}
                onEdit={() => handleOpenEdit(book.id)}
                onDelete={() => handleDelete(book.id)}
              />
            </Grid>
          ))}
        </Grid>
      )}

      {/* 모달 */}
      <BookModal
        open={modalOpen}
        onClose={() => setModalOpen(false)}
        mode={modalMode}
        onSubmit={handleFormSubmit}
        initialValues={editBookData}
      />
    </Box>
  );
};

export default BookList;
