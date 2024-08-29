<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin nhân viên</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="GiaoDienQuanLy.css" rel="stylesheet">
    </head>
    <body>
        <div id="welcomeMessage" class="text-center mt-5">
            <h2>Phần mềm quản lý nhân sự xin chào!</h2>
        </div>
        <div class="d-flex">
            <div class="sidebar">
                <h1>Menu</h1>
                <button type="button" class="btn btn-primary btn-block" id="toggleTableBtn">Xem danh sách nhân viên</button>
                <button type="button" class="btn btn-primary btn-block" id="btnShowPhongBan">Xem danh sách phòng ban</button>
                <button type="button" class="btn btn-primary btn-block" id="btnShowForm">Thêm nhân viên mới</button>
                <button type="button" class="btn btn-primary btn-block" id="btnShowLinkEmployee">Thêm nhân viên mới vào phòng ban</button>
                <button type="button" class="btn btn-primary btn-block" id="btnShowAddPhongBanForm">Thêm phòng ban mới</button>
                <button type="button" class="btn btn-danger btn-block" id="btnShowDeleteForm">Xóa nhân viên</button>
                <form action="login" method="get">
                    <input type="hidden" name="action" value="logout"/>
                    <input type="image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZmgG_e4ychBOsX0ZTCKbOISlyxKLr56q4MA&s" alt="Log out" class="btn btn-warning btn-sm" id="logoutbutton" width="60" height="60">
                </form>

            </div>
            <div class="container mt-5 main-content">
                <div class="table-container" id="employeeTableContainer" style="display: none;">
                    <!-- Employee table content -->
                    <div class="header text-center">
                        <h2>Thông tin nhân viên</h2>
                    </div>
                    <form action="nhanvienservlet" method="get" class="form-inline my-3">
                        <input type="text" name="search" class="form-control mr-sm-2" placeholder="Search">
                        <button type="submit" class="btn btn-primary">Search</button>
                    </form>
                    <table class="table table-bordered table-striped mt-3">
                        <thead>
                            <tr>
                                <th>Mã nhân viên</th>
                                <th>Tên</th>
                                <th>Giới tính</th>
                                <th>Ngày sinh</th>
                                <th>Quê quán</th>
                                <th>Chức vụ</th>
                                <th>Lương</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.ndata}" var="n">
                                <tr>
                                    <td>${n.maNhanVien}</td>
                                    <td>${n.ten}</td>
                                    <td>${n.gioiTinh ? 'Nam' : 'Nữ'}</td>
                                    <td>${n.ngayThangNamSinh}</td>
                                    <td>${n.queQuan}</td>
                                    <td>${n.chucVu}</td>
                                    <td>${n.luong}</td>
                                    <td class="action-buttons">
                                        <form action="nhanvienservlet" method="get">
                                            <input type="hidden" name="action" value="edit"/>
                                            <input type="hidden" name="maNhanVien" value="${n.maNhanVien}">
                                            <input type="image" src="https://cdn-icons-png.freepik.com/512/6325/6325975.png" alt="Edit" class="btn btn-warning btn-sm" width="44" height="40">
                                        </form>
                                        <form action="nhanvienservlet" method="post" onsubmit="return confirmDelete()">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="maNhanVien" value="${n.maNhanVien}">
                                            <input type="image" src="https://cdn-icons-png.freepik.com/512/5676/5676146.png" alt="Delete" class="btn btn-danger btn-sm" width="45" height="40">
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="table-container" id="phongBanTableContainer" style="display: none;">
                    <!-- Phong ban table content -->
                    <div class="header text-center">
                        <h2>Danh sách phòng ban và nhân viên</h2>
                    </div>
                    <table class="table table-bordered table-striped mt-3">
                        <thead>
                            <tr>
                                <th>Mã phòng ban</th> 
                                <th>Tên phòng ban</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="phongBan" items="${phongBanList}">
                                <tr data-phongban="${phongBan.maPhongBan}">
                                    <td class="phongban-code" style="cursor: pointer;">${phongBan.maPhongBan}</td>
                                    <td>${phongBan.tenPhongBan}</td>
                                </tr>
                                <tr class="nhanvien-info hidden" data-phongban="${phongBan.maPhongBan}">
                                    <td colspan="2">
                                        <table class="table table-bordered mt-3">
                                            <thead>
                                                <tr>
                                                    <th>Nhân viên</th>
                                                    <th>Chức vụ</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="nhanVien" items="${phongBan.nhanVienList}">
                                                    <tr>
                                                        <td>${nhanVien.ten}</td>
                                                        <td>${nhanVien.chucVu}</td>
                                                        <td class="action-buttons">
                                                            <form action="nhanvienservlet" method="post">
                                                                <input type="hidden" name="action" value="deletelink">
                                                                <input type="hidden" name="maNhanVien" value="${nhanVien.maNhanVien}">
                                                                <input type="image" src="https://cdn-icons-png.freepik.com/512/5676/5676146.png" alt="Delete" class="btn btn-danger btn-sm" width="45" height="40">
                                                            </form>

                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>




                <div class="form-container" id="addEmployeeForm" style="display: none;">
                    <!-- Add employee form -->
                    <h3>Thêm nhân viên mới</h3>
                    <form action="nhanvienservlet" method="post">
                        <input type="hidden" name="action" value="add">
                        <div class="form-group">
                            <label for="ten">Tên:</label>
                            <input type="text" class="form-control" id="ten" name="ten" required>
                        </div>
                        <div class="form-group">
                            <label>Giới tính:</label>
                            <div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="true" required>
                                    <label class="form-check-label" for="nam">Nam</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="false" required>
                                    <label class="form-check-label" for="nu">Nữ</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ngaySinh">Ngày sinh:</label>
                            <input type="date" class="form-control" id="ngaySinh" name="ngayThangNamSinh" required>
                        </div>
                        <div class="form-group">
                            <label for="queQuan">Quê quán:</label>
                            <input type="text" class="form-control" id="queQuan" name="queQuan" required>
                        </div>
                        <div class="form-group">
                            <label for="chucVu">Chức vụ:</label>
                            <input type="text" class="form-control" id="chucVu" name="chucVu" required>
                        </div>
                        <div class="form-group">
                            <label for="luong">Lương:</label>
                            <input type="number" class="form-control" id="luong" name="luong" required>
                        </div>
                        <input type="submit" value="Thêm" class="btn btn-primary">
                    </form>
                </div>
                <div class="form-container" id="linkEmployeeForm" style="display: none;">
                    <h3>Thêm nhân viên vào phòng ban</h3>
                    <form action="nhanvienservlet" method="post">
                        <input type="hidden" name="action" value="link">
                        <div class="form-group">
                            <label for="maPhongBan">Mã Phòng Ban:</label>
                            <input type="text" class="form-control" id="maPhongBan" name="maPhongBan" required>
                        </div>
                        <div class="form-group">
                            <label for="maNhanVien">Mã Nhân Viên:</label>
                            <input type="text" class="form-control" id="maNhanVien" name="maNhanVien" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>

                <div class="form-container" id="deleteEmployeeForm" style="display: none;">
                    <!-- Delete employee form -->
                    <h3>Xóa nhân viên</h3>
                    <form action="nhanvienservlet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <div class="form-group">
                            <label for="maNhanVien">Nhập mã nhân viên cần xóa:</label>
                            <input type="text" class="form-control" id="maNhanVien" name="maNhanVien" required>
                        </div>
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </form>
                </div>
                <div class="form-container" id="addPhongBanForm" style="display: none;">
                    <!-- Add department form -->
                    <h3>Thêm phòng ban mới</h3>
                    <form action="nhanvienservlet" method="post">
                        <input type="hidden" name="action" value="addPhongBan">
                        <div class="form-group">
                            <label for="maPhongBan">Mã Phòng Ban:</label>
                            <input type="text" class="form-control" id="maPhongBan" name="maPhongBan" required>
                        </div>
                        <div class="form-group">
                            <label for="tenPhongBan">Tên Phòng Ban:</label>
                            <input type="text" class="form-control" id="tenPhongBan" name="tenPhongBan" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>
            </div>
        </div>

        <script src="Button.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
