// src/components/BookModal.jsx

import { useEffect, useState } from 'react';
import { Modal, Box, Typography, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import BookForm from './BookForm';

const BookModal = ({ open, onClose, mode = "create", onSubmit, initialValues = {} }) => {
  const [formValues, setFormValues] = useState({
    title: "",
    author: "",
    cover_prompt: "",
    cover_url: "",
  });

  useEffect(() => {
    if (initialValues && mode === "edit") {
      setFormValues({
        title: initialValues.title || "",
        author: initialValues.author || "",
        cover_prompt: initialValues.cover_prompt || "",
        cover_url: initialValues.cover_url || "",
      });
    } else if (mode === "create") {
      setFormValues({
        title: "",
        author: "",
        cover_prompt: "",
        cover_url: "",
      });
    }
  }, [initialValues, mode, open]);

  const handleSubmit = (data) => {
    onSubmit(data);
  };

  return (
    <Modal open={open} onClose={onClose}>
      <Box
        sx={{
          position: 'fixed',
          top: 0,
          left: 0,
          width: '100vw',
          height: '100vh',
          display: 'flex',
          alignItems: 'flex-start', // 상단 정렬
          justifyContent: 'center',
          overflowY: 'auto',
          padding: 2,
          boxSizing: 'border-box',
        }}
      >
        <Box
          sx={{
            backgroundColor: 'white',
            width: '100%',
            maxWidth: 600,
            borderRadius: 2,
            padding: 4,
            position: 'relative',
            boxSizing: 'border-box',
            marginTop: '5vh', // 상단 여백
            marginBottom: '5vh', // 하단 여백
          }}
        >
          <IconButton
            onClick={onClose}
            sx={{ position: 'absolute', top: 8, right: 8 }}
          >
            <CloseIcon />
          </IconButton>

          <Typography variant="h5" sx={{ mb: 3, textAlign: 'center' }}>
            {mode === "edit" ? "도서 수정" : "도서 등록"}
          </Typography>

          <BookForm initialValues={formValues} onSubmit={handleSubmit} />
        </Box>
      </Box>
    </Modal>
  );
};

export default BookModal;
