USE [QuanLySanPham]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaCTHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [int] NOT NULL,
	[MaSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [money] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayLapCTHD] [date] NULL DEFAULT (getdate()),
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[MaCTPN] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuNhap] [int] NOT NULL,
	[MaSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [money] NOT NULL,
	[ChuThich] [nvarchar](255) NULL CONSTRAINT [DF_ChiTietPhieuNhap_ChuThich]  DEFAULT (''),
 CONSTRAINT [PK_ChiTietPhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaCTPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaChucVu] [int] IDENTITY(1,1) NOT NULL,
	[TenChucVu] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL CONSTRAINT [DF_ChucVu_GhiChu]  DEFAULT (''),
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[MaChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HangSanXuat]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangSanXuat](
	[MaHangSanXuat] [int] IDENTITY(1,1) NOT NULL,
	[TenHangSanXuat] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HangSanXUat] PRIMARY KEY CLUSTERED 
(
	[MaHangSanXuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [int] NOT NULL,
	[MaNhanVien] [int] NOT NULL,
	[NgayLapHoaDon] [date] NOT NULL CONSTRAINT [DF_HoaDon_NgayLapHoaDon]  DEFAULT (getdate()),
	[TongTien] [money] NOT NULL,
	[GhiChu] [nvarchar](255) NULL CONSTRAINT [DF_HoaDon_GhiChu]  DEFAULT (''),
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Ngaysinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SDT] [varchar](11) NOT NULL,
	[LoaiKhachHang] [int] NOT NULL,
	[GhiChu] [nchar](10) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiKhachHang](
	[MaLoaiKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiKhachHang] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_LoaiKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaLoaiKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoaiSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiSanPham] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[MaLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgayVaoLam] [date] NOT NULL,
	[ChucVu] [int] NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SoDT] [varchar](11) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaPhanPhoi]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaPhanPhoi](
	[MaNhaPhanPhoi] [int] IDENTITY(1,1) NOT NULL,
	[TenNhaPhanPhoi] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[SDT] [varchar](11) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[ChuThich] [text] NULL,
 CONSTRAINT [PK_NhaPhanPhoi] PRIMARY KEY CLUSTERED 
(
	[MaNhaPhanPhoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[MaNhanVien] [int] NOT NULL,
	[MaNhaPhanPhoi] [int] NOT NULL,
	[TongTien] [money] NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[ChuThich] [nvarchar](255) NULL CONSTRAINT [DF_PhieuNhap_ChuThich]  DEFAULT (''),
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[MaQuyen] [int] IDENTITY(1,1) NOT NULL,
	[TenQuyen] [nvarchar](50) NOT NULL,
	[ChuThich] [nvarchar](255) NULL CONSTRAINT [DF_Quyen_ChuThich]  DEFAULT (''),
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[LoaiSanPham] [int] NOT NULL,
	[HangSanXuat] [int] NOT NULL,
	[GiaNhap] [money] NOT NULL,
	[GiaBan] [money] NOT NULL,
	[TonKho] [int] NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[Image] [varchar](150) NULL CONSTRAINT [DF_SanPham_image]  DEFAULT (''),
	[ChuThich] [nvarchar](255) NULL CONSTRAINT [DF_SanPham_ChuThich]  DEFAULT (''),
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SapXepThoiGian]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SapXepThoiGian](
	[MaSXTG] [int] IDENTITY(1,1) NOT NULL,
	[ThoiGian] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSXTG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNhanVien] [int] NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Quyen] [int] NOT NULL,
	[ChuThich] [nvarchar](255) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (11, 7, 5, 1, 21000000.0000, N'', CAST(N'2019-11-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (15, 13, 3, 1, 1890000.0000, N'', CAST(N'2019-10-03' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (19, 17, 4, 1, 1300000.0000, N'', CAST(N'2019-09-13' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (20, 13, 30, 1, 1100000.0000, N'', CAST(N'2019-10-03' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1020, 1021, 1, 3, 3900000.0000, N'', CAST(N'2019-12-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1021, 1021, 1, 5, 6500000.0000, N'', CAST(N'2019-12-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1022, 7, 6, 1, 7490000.0000, N'', CAST(N'2019-11-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1023, 7, 9, 1, 1200000.0000, N'', CAST(N'2019-11-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1024, 7, 30, 1, 1100000.0000, N'', CAST(N'2019-11-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1025, 20, 9, 1, 1200000.0000, N'', CAST(N'2018-07-03' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1026, 20, 28, 1, 14000000.0000, N'', CAST(N'2018-07-03' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1027, 1021, 28, 3, 42000000.0000, N'', CAST(N'2019-12-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1029, 1022, 49, 1, 400000.0000, N'', CAST(N'2020-01-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1030, 1022, 49, 1, 400000.0000, N'', CAST(N'2020-01-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1031, 1022, 45, 1, 1960000.0000, N'', CAST(N'2020-01-04' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1032, 13, 7, 1, 1800000.0000, N'', CAST(N'2019-10-03' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1033, 1023, 1, 1, 7890000.0000, N'', CAST(N'2017-07-05' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1034, 1024, 1, 1, 7890000.0000, N'', CAST(N'2016-07-05' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1040, 1029, 8, 2, 34000000.0000, N'', CAST(N'2020-01-06' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1041, 1029, 6, 2, 14980000.0000, N'', CAST(N'2020-01-06' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1042, 1030, 12, 1, 12600000.0000, N'', CAST(N'2020-01-07' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1043, 1031, 35, 10, 1199000000.0000, N'', CAST(N'2020-01-08' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1044, 1031, 35, 11, 1318900000.0000, N'', CAST(N'2020-01-08' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1045, 1031, 35, 1, 119900000.0000, N'', CAST(N'2020-01-08' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1046, 1030, 35, 2, 239800000.0000, N'', CAST(N'2020-01-09' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1047, 1033, 27, 3, 420000.0000, N'', CAST(N'2020-01-09' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1048, 1034, 34, 1, 12000000.0000, N'', CAST(N'2019-12-09' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1049, 1035, 7, 1, 1800000.0000, N'', CAST(N'2020-01-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1050, 1036, 3, 2, 3780000.0000, N'', CAST(N'2020-01-10' AS Date))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHoaDon], [MaSanPham], [SoLuong], [TongTien], [GhiChu], [NgayLapCTHD]) VALUES (1051, 1037, 7, 1, 1800000.0000, N'', CAST(N'2020-02-10' AS Date))
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] ON 

INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (1, 1, 3, 100, 1000000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (2, 1, 43, 1, 7890000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (3, 2, 1, 1, 7890000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (4, 2, 1, 1, 7890000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (5, 7, 6, 1, 7890000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (6, 7, 6, 1, 7490000.0000, N'')
INSERT [dbo].[ChiTietPhieuNhap] ([MaCTPN], [MaPhieuNhap], [MaSanPham], [SoLuong], [TongTien], [ChuThich]) VALUES (7, 7, 6, 1, 7890000.0000, N'')
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] OFF
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (1, N'Giám Đốc', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (2, N'Thu Ngân', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (3, N'Kế Toán', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (4, N'Bảo Vệ', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (5, N'Lễ Tân', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (6, N'new', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (7, N'Quản Lý ', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (8, N'Lao Công', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (9, N'Kiểm Soát Viên', N'')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu], [GhiChu]) VALUES (10, N'chưa có', N'')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
SET IDENTITY_INSERT [dbo].[HangSanXuat] ON 

INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (1, N'SamSung')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (2, N'LG')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (3, N'HTC')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (4, N'Sonny')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (5, N'HuaWei')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (6, N'Xiaomi')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (7, N'Lenovo')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (8, N'Bkav')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (9, N'Gionne')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (10, N'FPT')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (11, N'NOKIA')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (12, N'Blackberry')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (13, N'Apple')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (14, N'Trung Quốc')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (15, N'Nhật')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (16, N'Beataudio')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (17, N'ZTE')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (18, N'DELL')
INSERT [dbo].[HangSanXuat] ([MaHangSanXuat], [TenHangSanXuat]) VALUES (19, N'ASUS')
SET IDENTITY_INSERT [dbo].[HangSanXuat] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (7, 6, 11, CAST(N'2019-11-10' AS Date), 30790000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (13, 11, 6, CAST(N'2019-10-03' AS Date), 4790000.0000, N'huy')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (17, 12, 11, CAST(N'2019-09-13' AS Date), 1300000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (20, 14, 11, CAST(N'2018-07-03' AS Date), 15200000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1021, 6, 11, CAST(N'2019-12-04' AS Date), 52400000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1022, 15, 11, CAST(N'2020-01-04' AS Date), 2760000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1023, 15, 11, CAST(N'2017-07-05' AS Date), 7890000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1024, 15, 11, CAST(N'2016-07-05' AS Date), 7890000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1029, 6, 1, CAST(N'2020-01-06' AS Date), 48980000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1030, 11, 3, CAST(N'2020-01-07' AS Date), 252400000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1031, 1026, 26, CAST(N'2020-01-08' AS Date), 2637800000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1032, 11, 22, CAST(N'2020-01-09' AS Date), 0.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1033, 11, 26, CAST(N'2020-01-09' AS Date), 420000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1034, 6, 14, CAST(N'2019-12-09' AS Date), 12000000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1035, 6, 14, CAST(N'2020-01-10' AS Date), 1800000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1036, 6, 14, CAST(N'2020-01-10' AS Date), 3780000.0000, N'')
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [MaNhanVien], [NgayLapHoaDon], [TongTien], [GhiChu]) VALUES (1037, 15, 10, CAST(N'2020-02-10' AS Date), 1800000.0000, N'')
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (6, N'Nguyễn Thanh Tùng', CAST(N'1996-03-02' AS Date), 1, N'Thái Bình', N'0909898964', 1, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (11, N'Phở', CAST(N'1986-09-02' AS Date), 1, N'không cho xem', N'0745322222', 3, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (12, N'đức cường', CAST(N'1980-04-10' AS Date), 0, N'Hà Nội', N'0914232372', 3, N'mới thêm  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (14, N'Phạm Hồng Hà', CAST(N'1992-06-09' AS Date), 1, N'102 nguyễn tất thành-TP buôn Ma Thuật', N'0166542753', 2, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (15, N'Hoàng Raper', CAST(N'2000-06-09' AS Date), 0, N' Hải Phòng', N'0166554322', 1, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (18, N'Phạm Hồng Hà', CAST(N'1992-06-09' AS Date), 0, N'102 nguyễn tất thành-TP buôn Ma Thuật', N'0166542753', 2, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (19, N'phạm hoàng huy', CAST(N'2010-05-03' AS Date), 1, N'5433', N'6445654', 2, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (20, N'phạm hoàng huy', CAST(N'2010-05-03' AS Date), 1, N'5433', N'6445654', 2, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (21, N'mới', CAST(N'2011-07-06' AS Date), 1, N'656445', N'12334567890', 2, N'gfg       ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (22, N'hung', CAST(N'2003-04-04' AS Date), 1, N'iuik', N'1321212313', 1, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (1024, N'Nguyen Thai hung', CAST(N'1995-02-24' AS Date), 1, N'HP', N'0886860222', 1, N'xx        ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (1026, N'Truowng quoc phong', CAST(N'2010-05-03' AS Date), 1, N'5433', N'6445654', 1, N'kcg       ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (2036, N'Hung Thai Nguyen', CAST(N'2019-12-09' AS Date), 0, N'TNkkk', N'0147147147', 3, N'kcg       ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (2038, N'kiem tra them', CAST(N'2000-02-02' AS Date), 0, N'HN', N'123123133', 3, N'          ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (2039, N'test tlkh', CAST(N'2010-12-10' AS Date), 0, N'QN', N'0147147147', 3, N'ãasx      ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (2040, N'cvcxvc', CAST(N'2010-12-09' AS Date), 1, N'QNN', N'0258258258', 2, N'xxxxxxxx  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Ngaysinh], [GioiTinh], [DiaChi], [SDT], [LoaiKhachHang], [GhiChu]) VALUES (3027, N'ádsasd', CAST(N'2020-01-21' AS Date), 0, N'hn', N'12312312313', 3, N'qưeqwe    ')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiKhachHang] ON 

INSERT [dbo].[LoaiKhachHang] ([MaLoaiKhachHang], [TenLoaiKhachHang], [GhiChu]) VALUES (1, N'vip', N'giảm 10%')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKhachHang], [TenLoaiKhachHang], [GhiChu]) VALUES (2, N'thường', N'giảm 0%')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKhachHang], [TenLoaiKhachHang], [GhiChu]) VALUES (3, N'sinh viên', N'giảm 5%')
SET IDENTITY_INSERT [dbo].[LoaiKhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (1, N'Điện thoại phổ thông')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (2, N'Smartphone')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (3, N'Tablet')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (4, N'SmatWatch')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (5, N'Phụ Kiện')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (9, N'linh Kiện')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (11, N'CPU')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (12, N'Màn Hình Máy Tính')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSanPham], [TenLoaiSanPham]) VALUES (13, N'Main')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (1, N'Phạm Hoàng Huy', CAST(N'1996-12-25' AS Date), 1, CAST(N'2016-01-01' AS Date), 1, N'51- 102 Nguyễn Tất Thành', N'01293223225', N'chức cao nhất có thể')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (3, N'Phạm Văn Toàn', CAST(N'1997-01-02' AS Date), 0, CAST(N'2011-03-05' AS Date), 2, N'chưa có', N'01293223225', N'chưa có')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (6, N'Nguyễn Trúc Nhân', CAST(N'1990-06-10' AS Date), 1, CAST(N'2014-12-03' AS Date), 5, N'Hà Nội ', N'091425635', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (8, N'Phạm Băng Băng', CAST(N'1896-03-02' AS Date), 0, CAST(N'2015-05-04' AS Date), 5, N'việt nam', N'01652343643', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (10, N'Nguyễn Thanh Tùng', CAST(N'1994-07-05' AS Date), 1, CAST(N'2015-09-07' AS Date), 1, N'Thái Bình', N'09090909090', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (11, N'Lương Bích Hữu', CAST(N'1988-06-23' AS Date), 0, CAST(N'2015-06-04' AS Date), 3, N'Trung Quốc', N'46789976654', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (13, N'Khởi My', CAST(N'1984-06-03' AS Date), 0, CAST(N'2015-06-03' AS Date), 6, N'buôn Ma Thuật', N'', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (14, N'Nguyễn thị Hồng', CAST(N'1997-08-07' AS Date), 0, CAST(N'2011-03-05' AS Date), 2, N'buôn ma thuột', N'01293223225', N'
')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (15, N'nguyễn Văn Hùng', CAST(N'1994-03-02' AS Date), 1, CAST(N'2011-03-05' AS Date), 4, N'easup', N'01653454267', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (18, N'Phạm Văn Nguyên', CAST(N'1997-01-02' AS Date), 1, CAST(N'2014-03-05' AS Date), 4, N'hà nội', N'0921457432', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (22, N'Khởi My', CAST(N'1984-06-03' AS Date), 0, CAST(N'2015-06-03' AS Date), 1, N'buôn Ma Thuật', N'01293223225', N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinh], [GioiTinh], [NgayVaoLam], [ChucVu], [DiaChi], [SoDT], [GhiChu]) VALUES (26, N'Nguyễn thái Hưng', CAST(N'1995-02-24' AS Date), 1, CAST(N'2019-01-01' AS Date), 1, N'Hải Phòng', N'0886860224', N'ádad')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
SET IDENTITY_INSERT [dbo].[NhaPhanPhoi] ON 

INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (1, N'FPT Trading', N'Hồ Chí Minh', N'098674322', N'motcucgach7796@gmail.com', N'')
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (2, N'docomo', N'Trung Quốc ', N'34657865434', N'dcomo197@gmail.com', N'')
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (8, N'FPTShop', N'Việt Nam', N'34657865434', N'dcomo197@gmail.com', N'')
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (10, N'ZTE', N'Quảng đông Trung quốc', N'01293223225', N'ZTEhuy@gmail.com', N'')
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (11, N'FPTShop', N'Việt Nam', N'34657865434', N'dcomo197@gmail.com', N'          ')
INSERT [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi], [TenNhaPhanPhoi], [DiaChi], [SDT], [Email], [ChuThich]) VALUES (12, N'FPTShop', N'Việt Nam', N'34657865434', N'dcomo197@gmail.com', N'')
SET IDENTITY_INSERT [dbo].[NhaPhanPhoi] OFF
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 

INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (1, 11, 2, 100000.0000, CAST(N'2016-04-03' AS Date), N'')
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (2, 11, 2, 100000.0000, CAST(N'2016-01-01' AS Date), N'')
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (3, 11, 2, 100000.0000, CAST(N'2016-07-01' AS Date), N'')
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (7, 11, 2, 100000.0000, CAST(N'2016-04-03' AS Date), N'')
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (10, 3, 2, 0.0000, CAST(N'2015-02-02' AS Date), N'')
INSERT [dbo].[PhieuNhap] ([MaPhieuNhap], [MaNhanVien], [MaNhaPhanPhoi], [TongTien], [NgayNhap], [ChuThich]) VALUES (11, 3, 2, 0.0000, CAST(N'2015-02-02' AS Date), N'')
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
SET IDENTITY_INSERT [dbo].[Quyen] ON 

INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (1, N'Quản Trị Viên', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (2, N'Kế Toán', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (3, N'Thu Ngân', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (4, N'Bảo Vệ', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (5, N'New', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [ChuThich]) VALUES (6, N'Giám Đốc', N'')
SET IDENTITY_INSERT [dbo].[Quyen] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (1, N'Sony M4 Aqua', 2, 4, 7390000.0000, 7890000.0000, 34, 1, N'sonnu m4 w1.png', N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (3, N'HTC 10', 2, 3, 1800000.0000, 1890000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (4, N'Samsung S7 Edge', 2, 1, 1300000.0000, 1300000.0000, 10, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (5, N'Iphone 6', 2, 13, 20000000.0000, 21000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (6, N'Samsung Galaxy A5', 2, 1, 700000.0000, 7490000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (7, N'Samsung S7 Edge', 2, 1, 1500000.0000, 1800000.0000, 10, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (8, N'Iphone 6 Plus', 2, 13, 15000000.0000, 17000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (9, N'Samsung Galaxy A7', 2, 1, 1000000.0000, 1200000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (10, N'Samsung Galaxy J5 2018', 2, 1, 8490000.0000, 9000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (12, N'Samsung Galaxy S6 Edge', 1, 1, 12000000.0000, 12600000.0000, 100, 1, N'', N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (13, N'Samsung Galaxy S6 Edge Plus', 2, 1, 10000000.0000, 11000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (19, N'Samsung Galaxy J3', 2, 1, 20000000.0000, 21000000.0000, 100, 0, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (20, N'Htc One M9', 2, 3, 1000000.0000, 1200000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (21, N'HTC One M8', 2, 3, 20000000.0000, 21000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (27, N'Loa Rela Bueltooth', 5, 16, 100000.0000, 140000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (28, N'Loa Rock Bueltooth', 5, 17, 10000000.0000, 14000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (29, N'Loa Beataudio Bueltooth', 5, 16, 10000000.0000, 14000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (30, N'Tai Nghe Beataudio Bueltooth', 5, 16, 900000.0000, 1100000.0000, 17, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (31, N'Ipad Pro 12.9inch', 3, 13, 1800000.0000, 1960000.0000, 89, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (33, N'Samsung Gear S1', 4, 1, 1400000.0000, 1600000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (34, N'Samsung Gear S2', 4, 1, 10000000.0000, 12000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (35, N'Samsung Gear S2 Classic', 4, 1, 11000000.0000, 119900000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (38, N'Lenovo Tab 3 8inch', 3, 7, 8000000.0000, 8500000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (39, N'Lenovo Tab 3 7', 3, 7, 3490000.0000, 3990000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (40, N'Huawer Mediapad', 3, 5, 7000000.0000, 8000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (42, N'NOKIA 1020', 1, 11, 299000.0000, 400000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (43, N'NOKIA N3', 1, 11, 3000.0000, 5000.0000, 5, 1, NULL, N'sửa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (44, N'Samsung SSD 128gb', 9, 1, 800000.0000, 960000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (45, N'Ipad Pro 12.9inch', 3, 13, 1800000.0000, 1960000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (46, N'Samsung Galaxy S6 Edge Plus', 2, 1, 10000000.0000, 11000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (47, N'Samsung Gplus', 2, 1, 10000000.0000, 11000000.0000, 100, 1, NULL, N'')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (48, N'samsung galaxy s6 edge plus', 2, 2, 10000000.0000, 11000000.0000, 100, 1, N'', N'231')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (49, N'NOKIA 1020', 1, 11, 299000.0000, 400000.0000, 100, 1, N'', N'aa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (52, N'Iphone 11 Pro Max', 2, 13, 21000000.0000, 30000000.0000, 200, 1, N'', N'200')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (53, N'Iphone XS MAX', 2, 2, 15000000.0000, 21000000.0000, 100, 1, N'', N'Thanh lý nhanh')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (54, N'SamSung Note 10+', 2, 1, 12000000.0000, 16000000.0000, 10, 1, N'', N'Thanh lý samsung')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [LoaiSanPham], [HangSanXuat], [GiaNhap], [GiaBan], [TonKho], [TrangThai], [Image], [ChuThich]) VALUES (55, N'NOKIA  N3', 1, 11, 3000.0000, 5000.0000, 5, 1, N'', N'54654')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
SET IDENTITY_INSERT [dbo].[SapXepThoiGian] ON 

INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (1, N'To Day')
INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (2, N'Yesterday')
INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (3, N'This Month')
INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (4, N'Last Month')
INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (5, N'This Year')
INSERT [dbo].[SapXepThoiGian] ([MaSXTG], [ThoiGian]) VALUES (6, N'Last Year')
SET IDENTITY_INSERT [dbo].[SapXepThoiGian] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (1, 1, N'admin', N'admin', 1, N'người có thẩm quyền cao ngất ngưởng')
INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (2, 3, N'cuongnp', N'cuongnp', 2, N'')
INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (3, 6, N'Nhan1212', N'Nhan1212', 3, N'')
INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (5, 6, N'huyhuy12', N'HUYhuy12', 5, N' ')
INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (6, 13, N'khoimy12', N'Khoimy12', 5, N' ')
INSERT [dbo].[Users] ([ID], [MaNhanVien], [TenDangNhap], [Password], [Quyen], [ChuThich]) VALUES (7, 6, N'huyhuy12', N'HUYhuy12', 5, N' ')
SET IDENTITY_INSERT [dbo].[Users] OFF
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap] FOREIGN KEY([MaPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([MaPhieuNhap])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_LoaiKhachHang] FOREIGN KEY([LoaiKhachHang])
REFERENCES [dbo].[LoaiKhachHang] ([MaLoaiKhachHang])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_LoaiKhachHang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([ChucVu])
REFERENCES [dbo].[ChucVu] ([MaChucVu])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi] FOREIGN KEY([MaNhaPhanPhoi])
REFERENCES [dbo].[NhaPhanPhoi] ([MaNhaPhanPhoi])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaPhanPhoi]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_HangSanXUat] FOREIGN KEY([HangSanXuat])
REFERENCES [dbo].[HangSanXuat] ([MaHangSanXuat])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_HangSanXUat]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([LoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([MaLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_NhanVien]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Quyen] FOREIGN KEY([Quyen])
REFERENCES [dbo].[Quyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Quyen]
GO
/****** Object:  StoredProcedure [dbo].[del_KhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE PROC [dbo].[del_KhachHang] @makhachhang int
 AS
 DELETE FROM KhachHang WHERE MaKhachHang=@makhachhang
GO
/****** Object:  StoredProcedure [dbo].[DoanhThu_Today]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[DoanhThu_Today]
as
select sum(hd.TongTien)AS DoanhThu,count(hd.MaHoaDon)AS TongHoaDon,sum(cthd.SoLuong)AS TongSoSP from ChiTietHoaDon cthd JOIN HoaDon hd
on cthd.MaHoaDon=hd.MaHoaDon 
GO
/****** Object:  StoredProcedure [dbo].[insert_KhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[insert_KhachHang] @hoten nvarchar(64), @ngaysinh date,@gioitinh bit,@diachi nvarchar(256),@sdt varchar(12), @loaikhachhang int, @ghichu nvarchar(500)
as
INSERT KhachHang (TenKhachHang, Ngaysinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu) VALUES
 (@hoten,@ngaysinh,@gioitinh, @diachi, @sdt, @loaikhachhang, @ghichu)
GO
/****** Object:  StoredProcedure [dbo].[select_chinhxac_ngayhnay]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_chinhxac_ngayhnay]
as
select  sum(h.TongTien)AS DoanhThuHD,count(h.MaHoaDon)As TongHD,sum(c.SoLuong)AS TongSP
from HoaDon h full outer JOIN ChiTietHoaDon c
on h.MaHoaDon=c.MaHoaDon where h.NgayLapHoaDon=Convert(DATE, GetDate())
GO
/****** Object:  StoredProcedure [dbo].[select_DoanhThu_LastMonth]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_DoanhThu_LastMonth]
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE DATEPART(m, NgayLapHoaDon) = DATEPART(m, DATEADD(m, -1, getdate()))
AND DATEPART(yyyy, NgayLapHoaDon) = DATEPART(yyyy, DATEADD(m, -1, getdate()))
GO
/****** Object:  StoredProcedure [dbo].[select_DoanhThu_LastYear]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_DoanhThu_LastYear]
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE NgayLapHoaDon BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE())-1, 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)

GO
/****** Object:  StoredProcedure [dbo].[select_DoanhThu_ThisYear]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_DoanhThu_ThisYear]
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE NgayLapHoaDon BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())+1, 0)
GO
/****** Object:  StoredProcedure [dbo].[select_HangHoa]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[select_HangHoa]
 AS
 select*from SanPham sp 
 join LoaiSanPham lsp
 on sp.LoaiSanPham=lsp.MaLoaiSanPham
 join HangSanXuat hsx
 on hsx.MaHangSanXuat=sp.HangSanXuat
 Order By sp.TenSanPham ASC
GO
/****** Object:  StoredProcedure [dbo].[select_KhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE PROC  [dbo].[select_KhachHang]
 AS
 select kh.MaKhachHang, kh.TenKhachHang, kh.Ngaysinh, kh.GioiTinh,kh.DiaChi,kh.SDT,lkh.TenLoaiKhachHang,kh.LoaiKhachHang,
 kh.GhiChu 
 from KhachHang kh
 Full Join LoaiKhachHang lkh on kh.LoaiKhachHang = lkh.MaLoaiKhachHang

GO
/****** Object:  StoredProcedure [dbo].[select_lastmonth_SoLuong]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_lastmonth_SoLuong] as
 select sum(SoLuong)AS TongSoLuong from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)
GO
/****** Object:  StoredProcedure [dbo].[select_month_THD_TT]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_month_THD_TT] as
 select count(h.MaHoaDon)as TongHoaDon,sum(h.TongTien)as TongTien from HoaDon h
WHERE h.NgayLapHoaDon BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)
GO
/****** Object:  StoredProcedure [dbo].[select_nhanvien]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 create proc [dbo].[select_nhanvien]
 as
 select nv.MaNhanVien, nv.TenNhanVien, nv.NgaySinh,nv.GioiTinh,nv.NgayVaolam,nv.ChucVu,nv.DiaChi,nv.SoDT,nv.GhiChu,cv.TenChucVu
 from NhanVien nv join ChucVu cv
 on nv.ChucVu=cv.MaChucVu
GO
/****** Object:  StoredProcedure [dbo].[select_soluongSP_hqua]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_soluongSP_hqua]
as
select sum(SoLuong)AS TongSoLuong from ChiTietHoaDon
WHERE NgayLapCTHD >= dateadd(day,datediff(day,1,GETDATE()),0)
AND NgayLapCTHD < dateadd(day,datediff(day,0,GETDATE()),0)
GO
/****** Object:  StoredProcedure [dbo].[select_SoSP_LastMonth]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_SoSP_LastMonth]
AS
select sum(SoLuong)as TongSoLuong
 from ChiTietHoaDon 
WHERE DATEPART(m, NgayLapCTHD) = DATEPART(m, DATEADD(m, -1, getdate()))
AND DATEPART(yyyy, NgayLapCTHD) = DATEPART(yyyy, DATEADD(m, -1, getdate()))
GO
/****** Object:  StoredProcedure [dbo].[select_SoSP_LastYear]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_SoSP_LastYear]
AS
select sum(SoLuong)AS TongSoLuong
 from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())-1, 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
GO
/****** Object:  StoredProcedure [dbo].[select_SoSP_ThisYear]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_SoSP_ThisYear]
AS
select sum(SoLuong)AS TongSoLuong
 from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())+1, 0)
GO
/****** Object:  StoredProcedure [dbo].[select_ThoiGian]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_ThoiGian]
AS
select * from SapXepThoiGian
GO
/****** Object:  StoredProcedure [dbo].[select_TTien_THD_hqua]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[select_TTien_THD_hqua]
as
select count(h.MaHoaDon)as TongHoaDon,sum(h.TongTien)as TongTien from HoaDon h
WHERE h.NgayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0)
AND h.NgayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0)
GO
/****** Object:  StoredProcedure [dbo].[tongquan_hoadon]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tongquan_hoadon]
@ngaydau varchar(10),@ngaycuoi varchar(10)
as
select count(MaHoaDon)AS TongHoaDon,sum(TongTien) AS TongTienX from HoaDon
 Where NgayLapHoaDon >=@ngaydau and NgayLapHoaDon <= @ngaycuoi
GO
/****** Object:  StoredProcedure [dbo].[update_KhachHang]    Script Date: 09/01/2020 04:22:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE PROC [dbo].[update_KhachHang] @hoten nvarchar(64), @ngaysinh date,@gioitinh bit,@diachi nvarchar(256),@sdt varchar(12), @loaikhachhang int, @ghichu nvarchar(500), @makhachhang int
as
 UPDATE KhachHang SET TenKhachHang=@hoten, Ngaysinh=@ngaysinh, GioiTinh=@gioitinh, DiaChi=@diachi, SDT=@sdt, LoaiKhachHang=@loaikhachhang, GhiChu=@ghichu
 WHERE MaKhachHang=@makhachhang 
GO


select* from ChiTietHoaDon Where MaHoaDon = (select MaHoaDon from HoaDon)