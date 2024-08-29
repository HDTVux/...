<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Employee Information</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="GiaoDienEdit.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Edit Employee Information</h2>
        <form action="nhanvienservlet" method="post">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="MaNhanVien" value="${param.maNhanVien}">
            <div class="form-group">
                <label for="Ten">Tên nhân viên:</label>
                <input type="text" class="form-control" id="Ten" name="Ten" value="${nhanVien.ten}" required>
            </div>
            <div class="form-group">
                <label>Giới tính:</label>
                <div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="GioiTinh" id="Nam" value="true" ${nhanVien.gioiTinh ? 'checked' : ''} required>
                        <label class="form-check-label" for="Nam">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="GioiTinh" id="Nu" value="false" ${!nhanVien.gioiTinh ? 'checked' : ''} required>
                        <label class="form-check-label" for="Nu">Nữ</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="NgayThangNamSinh">Ngày tháng năm sinh:</label>
                <input type="date" class="form-control" id="NgayThangNamSinh" name="NgayThangNamSinh" value="${nhanVien.ngayThangNamSinh}" required>
            </div>
            <div class="form-group">
                <label for="QueQuan">Quê quán:</label>
                <input type="text" class="form-control" id="QueQuan" name="QueQuan" value="${nhanVien.queQuan}" required>
            </div>
            <div class="form-group">
                <label for="ChucVu">Chức vụ:</label>
                <input type="text" class="form-control" id="ChucVu" name="ChucVu" value="${nhanVien.chucVu}" required>
            </div>
            <div class="form-group">
                <label for="Luong">Lương:</label>
                <input type="number" class="form-control" id="Luong" name="Luong" value="${nhanVien.luong}" required>
            </div>
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </form>
    </div>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
