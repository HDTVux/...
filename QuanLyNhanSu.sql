Create table Account(
username varchar(100),
password varchar(100)
)
INSERT INTO Account (username, password) VALUES
('mra', '123'),
('mrb', '123'),
('mrc', '123');

CREATE TABLE PhongBan (
    MaPhongBan INT PRIMARY KEY,
    TenPhongBan NVARCHAR(100)
);

CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY IDENTITY(1,1),
    Ten NVARCHAR(100),
    GioiTinh BIT,
    NgayThangNamSinh DATE,
    QueQuan NVARCHAR(100),
    ChucVu NVARCHAR(50),
    Luong INT,
);
CREATE TABLE PhongBan_NhanVien (
    MaPhongBan INT,
    MaNhanVien INT,
    PRIMARY KEY (MaPhongBan, MaNhanVien),
    FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhongBan),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);


INSERT INTO NhanVien (Ten, GioiTinh, NgayThangNamSinh, QueQuan, ChucVu, Luong) VALUES
(N'Nguyễn Văn A', 1, '1990-01-01', N'Hà Nội', N'Nhân viên', 10000000),
(N'Trần Thị B', 0, '1992-02-02', N'Hà Nội', N'Nhân viên', 12000000),
(N'Lê Văn C', 1, '1994-03-03', N'Hải Phòng', N'Nhân viên', 15000000),
(N'Phạm Thị D', 0, '1991-04-04', N'Đà Nẵng', N'Nhân viên', 13000000),
(N'Hoàng Văn E', 1, '1985-05-05', N'Huế', N'Trưởng phòng', 16000000),
(N'Ngô Thị F', 0, '1993-06-06', N'Quảng Ninh', N'Nhân viên', 11000000),
(N'Đỗ Văn G', 1, '1990-07-07', N'Hà Nội', N'Nhân viên', 14000000),
(N'Phan Thị H', 0, '1989-08-08', N'Nghệ An', N'Nhân viên', 17000000),
(N'Vũ Văn I', 1, '1992-09-09', N'Hải Dương', N'Nhân viên', 12000000),
(N'Nguyễn Thị K', 0, '1991-10-10', N'Thái Bình', N'Nhân viên', 11000000),
(N'Trần Văn L', 1, '1980-11-11', N'Thanh Hóa', N'Trưởng phòng', 15000000),
(N'Lê Thị M', 0, '1987-12-12', N'Quảng Ngãi', N'Nhân viên', 1600000),
(N'Phạm Văn N', 1, '1986-01-13', N'Bình Định', N'Nhân viên', 13000000),
(N'Hoàng Thị O', 0, '1988-02-14', N'Phú Thọ', N'Nhân viên', 14000000),
(N'Ngô Văn P', 1, '1989-03-15', N'Ninh Bình', N'Nhân viên', 17000000);
GO
INSERT INTO NhanVien (Ten, GioiTinh, NgayThangNamSinh, QueQuan, ChucVu, Luong) VALUES
(N'Trịnh Văn Q', 1, '1990-01-16', N'Hà Nội', N'Nhân viên', 18000000),
(N'Bùi Thị R', 0, '1992-02-17', N'Hà Nội', N'Nhân viên', 19000000),
(N'Nguyễn Văn S', 1, '1994-03-18', N'Hải Phòng', N'Nhân viên', 20000000),
(N'Phạm Thị T', 0, '1991-04-19', N'Đà Nẵng', N'Nhân viên', 21000000),
(N'Lê Văn U', 1, '1985-05-20', N'Huế', N'Trưởng phòng', 22000000),
(N'Ngô Thị V', 0, '1993-06-21', N'Quảng Ninh', N'Nhân viên', 23000000),
(N'Đỗ Văn W', 1, '1990-07-22', N'Hà Nội', N'Nhân viên', 24000000),
(N'Phan Thị X', 0, '1989-08-23', N'Nghệ An', N'Nhân viên', 25000000),
(N'Vũ Văn Y', 1, '1992-09-24', N'Hải Dương', N'Nhân viên', 26000000),
(N'Nguyễn Thị Z', 0, '1991-10-25', N'Thái Bình', N'Nhân viên', 27000000),
(N'Trần Văn AA', 1, '1980-11-26', N'Thanh Hóa', N'Trưởng phòng', 28000000),
(N'Lê Thị BB', 0, '1987-12-27', N'Quảng Ngãi', N'Nhân viên', 29000000),
(N'Phạm Văn CC', 1, '1986-01-28', N'Bình Định', N'Nhân viên', 30000000),
(N'Hoàng Thị DD', 0, '1988-02-29', N'Phú Thọ', N'Nhân viên', 31000000)

INSERT INTO NhanVien (Ten, GioiTinh, NgayThangNamSinh, QueQuan, ChucVu, Luong) VALUES
(N'Trịnh Văn Sang', 1, '1990-01-16', N'Yên Bái', N'Nhân viên', 18000000),
(N'Bùi Thị Thúy', 0, '1992-02-17', N'Lào Cai', N'Nhân viên', 19000000),
(N'Nguyễn Văn Sĩ', 1, '1994-03-18', N'Hải Phòng', N'Nhân viên', 20000000),
(N'Phạm Thị Thanh', 0, '1991-04-19', N'Hồ Chí Minh', N'Nhân viên', 21000000)
INSERT INTO PhongBan (MaPhongBan, TenPhongBan) VALUES
(1, N'Phòng Kế toán'),
(2, N'Phòng Nhân sự'),
(3, N'Phòng Kinh doanh'),
(4, N'Phòng IT'),
(5, N'Phòng Marketing');
GO
INSERT INTO PhongBan (MaPhongBan, TenPhongBan) VALUES
(6, N'Phòng chăm sóc khách hàng'),
(7, N'Ban đối ngoại')
GO
INSERT INTO PhongBan_NhanVien (MaPhongBan, MaNhanVien) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 4),
(4, 5),
(2, 6),
(3, 7),
(5, 8),
(4, 9),
(1, 10),
(2, 11),
(3, 12),
(4, 13),
(5, 14),
(1, 15);
GO
INSERT INTO PhongBan_NhanVien (MaPhongBan, MaNhanVien) VALUES
(2, 34),
(3, 35),
(4, 36),
(5, 37),
(1, 38),
(2, 39),
(3, 40),
(4, 41),
(5, 42),
(1, 43),
(2, 44),
(3, 45),
(4, 46),
(5, 47)

INSERT INTO Account (username, password) VALUES
('nguoidunga', '123'),
('nguoidungb', '123'),
('nguoidungc', '123');

SELECT pb.MaPhongBan, pb.TenPhongBan, nv.Ten 
FROM PhongBan pb
LEFT JOIN PhongBan_NhanVien pb_nv ON pb.MaPhongBan = pb_nv.MaPhongBan 
LEFT JOIN NhanVien nv ON pb_nv.MaNhanVien = nv.MaNhanVien
ORDER BY pb.TenPhongBan

DELETE FROM PhongBan_NhanVien WHERE MaNhanVien = 23

INSERT INTO PhongBan_NhanVien (MaPhongBan, MaNhanVien) VALUES (1, 28)