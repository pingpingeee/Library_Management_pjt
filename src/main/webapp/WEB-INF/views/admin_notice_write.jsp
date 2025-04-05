<%@page import="com.lmpjt.pilotpjt.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 작성 - 도서관리 시스템</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/admin_notice_write.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <div class="container">
        <div class="page-header">
<!--             <h1 class="page-title">공지사항 작성</h1> -->
<!--             <p class="page-description">도서관리 시스템의 새로운 공지사항을 작성합니다.</p> -->
        </div>
        
        <form action="/pilotpjt/notice_write" method="POST" enctype="multipart/form-data" class="notice-form">
            <div class="form-group">
                <label for="category" class="form-label">카테고리</label>
                <select id="category" name="noticeCategory" class="form-select" required>
                    <option value="">카테고리 선택</option>
                    <option value="important">중요 공지</option>
                    <option value="event">이벤트</option>
                    <option value="info">안내</option>
                    <option value="update">업데이트</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="title" class="form-label">제목</label>
                <input type="text" id="title" name="noticeTitle" class="form-input" placeholder="공지사항 제목을 입력하세요" required>
            </div>
            
            <div class="form-group">
                <div class="editor-toolbar">
                    <button type="button" class="toolbar-btn" onclick="formatText('bold')">
                        <i class="fas fa-bold"></i>
                    </button>
                    <button type="button" class="toolbar-btn" onclick="formatText('italic')">
                        <i class="fas fa-italic"></i>
                    </button>
                    <button type="button" class="toolbar-btn" onclick="formatText('underline')">
                        <i class="fas fa-underline"></i>
                    </button>
                    <div class="toolbar-separator"></div>
                    <button type="button" class="toolbar-btn" onclick="formatText('h2')">
                        <i class="fas fa-heading"></i>
                    </button>
                    <button type="button" class="toolbar-btn" onclick="formatText('ul')">
                        <i class="fas fa-list-ul"></i>
                    </button>
                    <button type="button" class="toolbar-btn" onclick="formatText('ol')">
                        <i class="fas fa-list-ol"></i>
                    </button>
                    <div class="toolbar-separator"></div>
                    <button type="button" class="toolbar-btn" onclick="formatText('link')">
                        <i class="fas fa-link"></i>
                    </button>
                    <button type="button" class="toolbar-btn" onclick="formatText('image')">
                        <i class="fas fa-image"></i>
                    </button>
                </div>
                <label for="content" class="form-label">내용</label>
                <textarea id="content" name="noticeContent" class="form-textarea" placeholder="공지사항 내용을 입력하세요" required></textarea>
            </div>
            
<!--             개발 시 테이블수정해서 컬럼 넣어야함 -->
            <div class="form-group">
                <label class="form-label">첨부파일</label>
                <div id="file-container">
                    <div class="file-input-container">
                        <input type="file" name="attachments" class="file-input">
                    </div>
                </div>
                <button type="button" class="add-file-btn" onclick="addFileInput()">
                    <i class="fas fa-plus"></i> 파일 추가
                </button>
            </div>
            
            <div class="form-group">
                <div class="checkbox-group">
                    <input type="checkbox" id="fixed" name="fixed" class="form-checkbox">
                    <label for="fixed" class="checkbox-label">상단 고정</label>
                </div>
            </div>
            
            <div class="form-actions">
                <button type="button" class="action-btn cancel-btn" onclick="location.href='admin_notice'">
                    <i class="fas fa-times"></i> 취소
                </button>
                <button type="submit" class="action-btn submit-btn">
                    <i class="fas fa-check"></i> 등록하기
                </button>
            </div>
        </form>
    </div>
    
    <script>
        function addFileInput() {
            const container = document.getElementById('file-container');
            const fileInputContainer = document.createElement('div');
            fileInputContainer.className = 'file-input-container';
            fileInputContainer.innerHTML = '<input type="file" name="attachments" class="file-input">';
            container.appendChild(fileInputContainer);
        }

        function formatText(command) {
            const textarea = document.getElementById('content');
            const start = textarea.selectionStart;
            const end = textarea.selectionEnd;
            const selectedText = textarea.value.substring(start, end);
            let replacement = '';

            switch(command) {
                case 'bold':
                    replacement = `**${selectedText}**`;
                    break;
                case 'italic':
                    replacement = `*${selectedText}*`;
                    break;
                case 'underline':
                    replacement = `<u>${selectedText}</u>`;
                    break;
                case 'h2':
                    replacement = `\n## ${selectedText}\n`;
                    break;
                case 'ul':
                    replacement = '\n' + selectedText.split('\n').map(line => `- ${line}`).join('\n') + '\n';
                    break;
                case 'ol':
                    const lines = selectedText.split('\n');
                    replacement = '\n' + lines.map((line, index) => `${index + 1}. ${line}`).join('\n') + '\n';
                    break;
                case 'link':
                    const url = prompt('링크 URL을 입력하세요:', 'http://');
                    if (url) {
                        replacement = `[${selectedText || '링크 텍스트'}](${url})`;
                    } else {
                        return;
                    }
                    break;
                case 'image':
                    const imageUrl = prompt('이미지 URL을 입력하세요:', 'http://');
                    if (imageUrl) {
                        replacement = `![${selectedText || '이미지 설명'}](${imageUrl})`;
                    } else {
                        return;
                    }
                    break;
            }

            textarea.value = textarea.value.substring(0, start) + replacement + textarea.value.substring(end);
            textarea.focus();
            textarea.selectionStart = textarea.selectionEnd = start + replacement.length;
        }
    </script>
</body>
</html>
