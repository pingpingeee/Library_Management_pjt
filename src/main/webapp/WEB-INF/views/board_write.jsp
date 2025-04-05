<%@page import="com.lmpjt.pilotpjt.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성 - 잉크 트리</title>
    <link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/board_write.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
    <script src="https://cdn.quilljs.com/1.3.6/quill.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <% 
    UserDTO user = (UserDTO) session.getAttribute("loginUser");
    if (user == null) {
        response.sendRedirect("/pilotpjt/loginView");
        return;
    }
    %>
    
    <div class="board-container">
        <div class="board-form">
            <div class="form-header">
                <h1 class="form-title">게시글 작성</h1>
                <p class="form-description">자유롭게 의견을 나누고 소통해보세요.</p>
            </div>
            
            <form action="/pilotpjt/save_post" method="post" onsubmit="return validateForm()">
                <input type="hidden" name="userNumber" value="<%= user.getUserNumber() %>">
                <input type="hidden" name="boardContent" id="boardContent">
                
                <div class="form-group">
                    <label for="boardTitle" class="form-label">제목</label>
                    <input type="text" id="boardTitle" name="boardTitle" class="form-control" placeholder="제목을 입력하세요" required>
                </div>
                
                <div class="form-group">
                    <label for="editor" class="form-label">내용</label>
                    <div id="editor" class="editor-container"></div>
                    <div id="contentError" class="error-message"></div>
                </div>
                
                <div class="form-actions">
                    <button type="button" class="btn btn-secondary" onclick="location.href='/pilotpjt/board_view'">취소</button>
                    <button type="submit" class="btn btn-primary">등록하기</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
        // Quill 에디터 초기화
        var quill = new Quill('#editor', {
            theme: 'snow',
            placeholder: '내용을 입력하세요.',
            modules: {
                toolbar: [
                    [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
                    ['bold', 'italic', 'underline', 'strike'],
                    [{ 'color': [] }, { 'background': [] }],
                    [{ 'list': 'ordered' }, { 'list': 'bullet' }],
                    [{ 'align': [] }],
                    ['link', 'image'],
                    ['clean']
                ]
            }
        });
        
        // 폼 제출 전 유효성 검사
        function validateForm() {
            var content = quill.root.innerHTML;
            var plainText = quill.getText().trim();
            
            if (plainText.length < 10) {
                document.getElementById('contentError').textContent = '내용은 최소 10자 이상 입력해주세요.';
                return false;
            }
            
            // 에디터 내용을 hidden input에 설정
            document.getElementById('boardContent').value = content;
            return true;
        }
    </script>
</body>
</html>