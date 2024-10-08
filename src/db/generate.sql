USE [master]
GO
/****** Object:  Database [QuanLyPhongKhamNhaKhoa]    Script Date: 7/31/2023 11:31:10 AM ******/
CREATE DATABASE [QuanLyPhongKhamNhaKhoa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyPhongKhamNhaKhoa', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyPhongKhamNhaKhoa.mdf' , SIZE = 270336KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyPhongKhamNhaKhoa_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyPhongKhamNhaKhoa_log.ldf' , SIZE = 1253376KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyPhongKhamNhaKhoa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyPhongKhamNhaKhoa', N'ON'
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyPhongKhamNhaKhoa]
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaBenhNhan]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[GenerateMaBenhNhan]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaBenhNhan CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaBenhNhan, 8) AS INT)), 0) + 1
    FROM BenhNhan;

    -- Tạo mã nhân viên mới
    SET @MaBenhNhan = 'BN' + RIGHT('00000000' + CAST(@SoThuTu AS VARCHAR(8)), 8);

    RETURN @MaBenhNhan;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaDanhMuc]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaDanhMuc]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaDanhMuc CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaDanhMuc, 6) AS INT)), 0) + 1
    FROM DanhMucDieuTri;

    -- Tạo mã nhân viên mới
    SET @MaDanhMuc = 'DMDT' + RIGHT('000000' + CAST(@SoThuTu AS VARCHAR(6)), 6);

    RETURN @MaDanhMuc;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaDonThuoc]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaDonThuoc]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaDonThuoc CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaDonThuoc, 8) AS INT)), 0) + 1
    FROM DonThuoc;

    -- Tạo mã nhân viên mới
    SET @MaDonThuoc = 'DT' + RIGHT('00000000' + CAST(@SoThuTu AS VARCHAR(8)), 8);

    RETURN @MaDonThuoc;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaKeHoach]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaKeHoach]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaKeHoach CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaKeHoach, 8) AS INT)), 0) + 1
    FROM KeHoachDieuTri;

    -- Tạo mã nhân viên mới
    SET @MaKeHoach = 'KH' + RIGHT('00000000' + CAST(@SoThuTu AS VARCHAR(8)), 8);

    RETURN @MaKeHoach;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaNhanVien]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaNhanVien]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaNhanVien CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaNhanVien, 8) AS INT)), 0) + 1
    FROM NhanVien;

    -- Tạo mã nhân viên mới
    SET @MaNhanVien = 'NV' + RIGHT('00000000' + CAST(@SoThuTu AS VARCHAR(8)), 8);

    RETURN @MaNhanVien;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaNhaSi]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaNhaSi]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaNhaSi CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaNhaSi, 8) AS INT)), 0) + 1
    FROM NhaSi;

    -- Tạo mã nhân viên mới
    SET @MaNhaSi = 'NS' + RIGHT('00000000' + CAST(@SoThuTu AS VARCHAR(8)), 8);

    RETURN @MaNhaSi;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaQuanTriVien]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaQuanTriVien]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaQuanTriVien CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaQuanTriVien, 7) AS INT)), 0) + 1
    FROM QuanTriVien;

    -- Tạo mã nhân viên mới
    SET @MaQuanTriVien = 'QTV' + RIGHT('0000000' + CAST(@SoThuTu AS VARCHAR(7)), 7);

    RETURN @MaQuanTriVien;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaRang]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaRang]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaRang CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaRang, 9) AS INT)), 0) + 1
    FROM Rang;

    -- Tạo mã nhân viên mới
    SET @MaRang = 'R' + RIGHT('000000000' + CAST(@SoThuTu AS VARCHAR(9)), 9);

    RETURN @MaRang;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaThuoc]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[GenerateMaThuoc]()
RETURNS CHAR(10)
AS
BEGIN
    DECLARE @SoThuTu INT;
    DECLARE @MaThuoc CHAR(10);

    -- Lấy số thứ tự hiện tại
    SELECT @SoThuTu = COALESCE(MAX(CAST(RIGHT(MaThuoc, 9) AS INT)), 0) + 1
    FROM Thuoc;

    -- Tạo mã nhân viên mới
    SET @MaThuoc = 'T' + RIGHT('000000000' + CAST(@SoThuTu AS VARCHAR(9)), 9);

    RETURN @MaThuoc;
END;
GO
/****** Object:  Table [dbo].[BenhNhan]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BenhNhan](
	[MaBenhNhan] [char](10) NOT NULL,
	[TenBenhNhan] [nvarchar](50) NOT NULL,
	[Tuoi] [smallint] NOT NULL,
	[GioiTinh] [nvarchar](4) NULL,
	[SucKhoeRangMieng] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDanhMucDieuTri]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDanhMucDieuTri](
	[MaChiTietDanhMucDieuTri] [int] IDENTITY(1,1) NOT NULL,
	[MaDanhMuc] [char](10) NOT NULL,
	[MaKeHoach] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaChiTietDanhMucDieuTri] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDonThuoc]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonThuoc](
	[MaChiTietDonThuoc] [int] IDENTITY(1,1) NOT NULL,
	[MaDonThuoc] [char](10) NOT NULL,
	[MaThuoc] [char](10) NOT NULL,
	[SoLuong] [smallint] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaChiTietDonThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChongChiDinh]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChongChiDinh](
	[MaChongChiDinh] [int] IDENTITY(1,1) NOT NULL,
	[MaBenhNhan] [char](10) NOT NULL,
	[MaThuoc] [char](10) NOT NULL,
	[GhiChu] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaChongChiDinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucDieuTri]    Script Date: 7/31/2023 11:31:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucDieuTri](
	[MaDanhMuc] [char](10) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[DonGia] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonThuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonThuoc](
	[MaDonThuoc] [char](10) NOT NULL,
	[NgayLap] [date] NULL,
	[MaBenhNhan] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDonThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KeHoachDieuTri]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KeHoachDieuTri](
	[MaKeHoach] [char](10) NOT NULL,
	[MaBenhNhan] [char](10) NOT NULL,
	[MaNhaSi] [char](10) NOT NULL,
	[NgayDieuTri] [date] NOT NULL,
	[MoTa] [nvarchar](100) NULL,
	[GhiChu] [nvarchar](100) NULL,
	[TrangThaiDieuTri] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKeHoach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichHen]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichHen](
	[MaLichHen] [int] IDENTITY(1,1) NOT NULL,
	[ThoiGianHen] [datetime] NULL,
	[MaBenhNhan] [char](10) NOT NULL,
	[MaNhaSi] [char](10) NOT NULL,
	[PhongKham] [nvarchar](50) NULL,
	[TinhTrang] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLichHen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichLamViec]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichLamViec](
	[MaLichLamViec] [int] IDENTITY(1,1) NOT NULL,
	[MaNhaSi] [char](10) NOT NULL,
	[NgayLamViec] [date] NOT NULL,
	[SanSang] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLichLamViec] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [char](10) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[Tuoi] [smallint] NULL,
	[GioiTinh] [nvarchar](4) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SoDienThoai] [varchar](20) NULL,
	[MatKhau] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaSi]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaSi](
	[MaNhaSi] [char](10) NOT NULL,
	[TenNhaSi] [nvarchar](50) NOT NULL,
	[Tuoi] [smallint] NULL,
	[GioiTinh] [nvarchar](4) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SoDienThoai] [varchar](20) NULL,
	[MatKhau] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhaSi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuanTriVien]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuanTriVien](
	[MaQuanTriVien] [char](10) NOT NULL,
	[TenQuanTriVien] [nvarchar](50) NOT NULL,
	[Tuoi] [smallint] NULL,
	[GioiTinh] [nvarchar](4) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SoDienThoai] [varchar](20) NULL,
	[MatKhau] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaQuanTriVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rang]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rang](
	[MaRang] [char](10) NOT NULL,
	[TenRang] [nvarchar](50) NOT NULL,
	[VungRang] [int] NULL,
	[SoRang] [smallint] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaRang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RangDieuTri]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RangDieuTri](
	[MaRangDieuTri] [int] IDENTITY(1,1) NOT NULL,
	[MaKeHoach] [char](10) NOT NULL,
	[MaRang] [char](10) NOT NULL,
	[L] [bit] NULL,
	[F] [bit] NULL,
	[D] [bit] NULL,
	[M] [bit] NULL,
	[T] [bit] NULL,
	[R] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaRangDieuTri] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[MaThanhToan] [int] IDENTITY(1,1) NOT NULL,
	[MaKeHoach] [char](10) NOT NULL,
	[TongTien] [bigint] NULL,
	[NgayThanhToan] [date] NULL,
	[MaNhanVien] [char](10) NULL,
	[TienDaTra] [bigint] NULL,
	[TienThoi] [bigint] NULL,
	[LoaiThanhToan] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[MaThuoc] [char](10) NOT NULL,
	[TenThuoc] [nvarchar](50) NOT NULL,
	[DonViTinh] [nvarchar](10) NOT NULL,
	[DonGia] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_BenhNhan_TenBenhNhan]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_BenhNhan_TenBenhNhan] ON [dbo].[BenhNhan]
(
	[TenBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChiTietDanhMucDieuTri_MaDanhMuc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChiTietDanhMucDieuTri_MaDanhMuc] ON [dbo].[ChiTietDanhMucDieuTri]
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChiTietDanhMucDieuTri_MaKeHoach]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChiTietDanhMucDieuTri_MaKeHoach] ON [dbo].[ChiTietDanhMucDieuTri]
(
	[MaKeHoach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChiTietDonThuoc_MaDonThuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChiTietDonThuoc_MaDonThuoc] ON [dbo].[ChiTietDonThuoc]
(
	[MaDonThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChiTietDonThuoc_MaThuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChiTietDonThuoc_MaThuoc] ON [dbo].[ChiTietDonThuoc]
(
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChongChiDinh_MaBenhNhan]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChongChiDinh_MaBenhNhan] ON [dbo].[ChongChiDinh]
(
	[MaBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ChongChiDinh_MaThuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ChongChiDinh_MaThuoc] ON [dbo].[ChongChiDinh]
(
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_DanhMucDieuTri_TenDanhMuc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_DanhMucDieuTri_TenDanhMuc] ON [dbo].[DanhMucDieuTri]
(
	[TenDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_DonThuoc_MaKeHoach]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_DonThuoc_MaKeHoach] ON [dbo].[DonThuoc]
(
	[MaBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_KeHoachDieuTri_MaBenhNhan]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_KeHoachDieuTri_MaBenhNhan] ON [dbo].[KeHoachDieuTri]
(
	[MaBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_KeHoachDieuTri_MaNhaSi]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_KeHoachDieuTri_MaNhaSi] ON [dbo].[KeHoachDieuTri]
(
	[MaNhaSi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_LichHen_MaBenhNhan]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_LichHen_MaBenhNhan] ON [dbo].[LichHen]
(
	[MaBenhNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_LichHen_MaNhaSi]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_LichHen_MaNhaSi] ON [dbo].[LichHen]
(
	[MaNhaSi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_NhaSi_TenNhaSi]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_NhaSi_TenNhaSi] ON [dbo].[NhaSi]
(
	[TenNhaSi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Rang_TenRang]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_Rang_TenRang] ON [dbo].[Rang]
(
	[TenRang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_RangDieuTri_MaKeHoach]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_RangDieuTri_MaKeHoach] ON [dbo].[RangDieuTri]
(
	[MaKeHoach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_RangDieuTri_MaRang]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_RangDieuTri_MaRang] ON [dbo].[RangDieuTri]
(
	[MaRang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ThanhToan_MaKeHoach]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ThanhToan_MaKeHoach] ON [dbo].[ThanhToan]
(
	[MaKeHoach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ThanhToan_MaNhanVien]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_ThanhToan_MaNhanVien] ON [dbo].[ThanhToan]
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Thuoc_TenThuoc]    Script Date: 7/31/2023 11:31:11 AM ******/
CREATE NONCLUSTERED INDEX [IX_Thuoc_TenThuoc] ON [dbo].[Thuoc]
(
	[TenThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [L]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [F]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [D]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [M]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [T]
GO
ALTER TABLE [dbo].[RangDieuTri] ADD  DEFAULT ((0)) FOR [R]
GO
ALTER TABLE [dbo].[ThanhToan] ADD  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[ThanhToan] ADD  DEFAULT ((0)) FOR [TienDaTra]
GO
ALTER TABLE [dbo].[ThanhToan] ADD  DEFAULT ((0)) FOR [TienThoi]
GO
ALTER TABLE [dbo].[ChiTietDanhMucDieuTri]  WITH CHECK ADD FOREIGN KEY([MaDanhMuc])
REFERENCES [dbo].[DanhMucDieuTri] ([MaDanhMuc])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDanhMucDieuTri]  WITH CHECK ADD FOREIGN KEY([MaKeHoach])
REFERENCES [dbo].[KeHoachDieuTri] ([MaKeHoach])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDonThuoc]  WITH CHECK ADD FOREIGN KEY([MaDonThuoc])
REFERENCES [dbo].[DonThuoc] ([MaDonThuoc])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDonThuoc]  WITH CHECK ADD FOREIGN KEY([MaThuoc])
REFERENCES [dbo].[Thuoc] ([MaThuoc])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChongChiDinh]  WITH CHECK ADD FOREIGN KEY([MaBenhNhan])
REFERENCES [dbo].[BenhNhan] ([MaBenhNhan])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChongChiDinh]  WITH CHECK ADD FOREIGN KEY([MaThuoc])
REFERENCES [dbo].[Thuoc] ([MaThuoc])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DonThuoc]  WITH CHECK ADD FOREIGN KEY([MaBenhNhan])
REFERENCES [dbo].[BenhNhan] ([MaBenhNhan])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KeHoachDieuTri]  WITH CHECK ADD FOREIGN KEY([MaBenhNhan])
REFERENCES [dbo].[BenhNhan] ([MaBenhNhan])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KeHoachDieuTri]  WITH CHECK ADD FOREIGN KEY([MaNhaSi])
REFERENCES [dbo].[NhaSi] ([MaNhaSi])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[LichHen]  WITH CHECK ADD FOREIGN KEY([MaBenhNhan])
REFERENCES [dbo].[BenhNhan] ([MaBenhNhan])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[LichHen]  WITH CHECK ADD FOREIGN KEY([MaNhaSi])
REFERENCES [dbo].[NhaSi] ([MaNhaSi])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[LichLamViec]  WITH CHECK ADD FOREIGN KEY([MaNhaSi])
REFERENCES [dbo].[NhaSi] ([MaNhaSi])
GO
ALTER TABLE [dbo].[RangDieuTri]  WITH CHECK ADD FOREIGN KEY([MaKeHoach])
REFERENCES [dbo].[KeHoachDieuTri] ([MaKeHoach])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RangDieuTri]  WITH CHECK ADD FOREIGN KEY([MaRang])
REFERENCES [dbo].[Rang] ([MaRang])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD FOREIGN KEY([MaKeHoach])
REFERENCES [dbo].[KeHoachDieuTri] ([MaKeHoach])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [QuanLyPhongKhamNhaKhoa] SET  READ_WRITE 
GO
