
create proc tongquan_hoadon
@ngaydau varchar(10),@ngaycuoi varchar(10)
as
select count(MaHoaDon)AS TongHoaDon,sum(TongTien) AS TongTienX from HoaDon
 Where NgayLapHoaDon >='2016-07-03' and NgayLapHoaDon <= '2016-07-05'
drop proc 
create proc tongquan_cthd
@ngaydau varchar(10),@ngaycuoi varchar(10)
as
select sum(hd.TongTien)AS DoanhThu,count(hd.MaHoaDon)AS TongHoaDon,sum(cthd.SoLuong)AS TongSoSP from ChiTietHoaDon cthd JOIN HoaDon hd
on cthd.MaHoaDon=hd.MaHoaDon
Where hd.NgayLapHoaDon= '2020-01-08'
Where hd.NgayLapHoaDon >='2016-07-4' and hd.NgayLapHoaDon <= '2016-7-5'

create table SapXepThoiGian(
	MaSXTG int identity(1,1) primary key,
	ThoiGian nvarchar(15)
)

create proc select_ThoiGian
AS
select * from SapXepThoiGian
select   sum(cthd.TongTien)AS DoanhThu,count(cthd.MaHoaDon)AS TongHoaDon,sum(cthd.SoLuong)AS TongSoSP from ChiTietHoaDon cthd JOIN HoaDon hd
on cthd.MaHoaDon=hd.MaHoaDon 

select count(MaHoaDon)AS TongHD, sum(TongTien)AS TongTien from HoaDon hd where NgayLapHoaDon=Convert(DATE, GetDate())
select sum(TongTien)AS TongTien, count(MaSanPham)as TongSP from ChiTietHoaDon where NgayLapCTHD=Convert(DATE, GetDate())
--select doanh thu theo ngày hôm nay
select * from HoaDon where NgayLapHoaDon= Convert(DATE, GetDate())
select * from ChiTietHoaDon where NgayLapCTHD=Convert(DATE, GetDate())


select * from HoaDon h full outer JOIN ChiTietHoaDon c
on h.MaHoaDon=c.MaHoaDon where h.NgayLapHoaDon=Convert(DATE, GetDate())

--select doanhthu ngày hôm nay chuẩn nhất
create proc select_chinhxac_ngayhnay
as
select  sum(h.TongTien)AS DoanhThuHD,count(h.MaHoaDon)As TongHD,sum(c.SoLuong)AS TongSP
from HoaDon h full outer JOIN ChiTietHoaDon c
on h.MaHoaDon=c.MaHoaDon where h.NgayLapHoaDon=Convert(DATE, GetDate())
select * from ChiTietHoaDon where NgayLapCTHD='2020-01-09'


--select doanhthu ngày hôm qua
create proc select_TTien_THD_hqua
as
select count(h.MaHoaDon)as TongHoaDon,sum(h.TongTien)as TongTien from HoaDon h
WHERE h.NgayLapHoaDon >= dateadd(day,datediff(day,1,GETDATE()),0)
AND h.NgayLapHoaDon < dateadd(day,datediff(day,0,GETDATE()),0)

create proc select_soluongSP_hqua
as
select sum(SoLuong)AS TongSoLuong from ChiTietHoaDon
WHERE NgayLapCTHD >= dateadd(day,datediff(day,1,GETDATE()),0)
AND NgayLapCTHD < dateadd(day,datediff(day,0,GETDATE()),0)


--select doanh thu theo tháng này
create proc select_month_THD_TT as
 select count(h.MaHoaDon)as TongHoaDon,sum(h.TongTien)as TongTien from HoaDon h
WHERE h.NgayLapHoaDon BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)

--select số lượng theo tháng này
create proc select_lastmonth_SoLuong as
 select sum(SoLuong)AS TongSoLuong from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)

----select doanh thu theo tháng trước
create proc select_DoanhThu_LastMonth
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE DATEPART(m, NgayLapHoaDon) = DATEPART(m, DATEADD(m, -1, getdate()))
AND DATEPART(yyyy, NgayLapHoaDon) = DATEPART(yyyy, DATEADD(m, -1, getdate()))

----select số lượng theo tháng trước
drop proc select_SoSP_LastMonth
create proc select_SoSP_LastMonth
AS
select sum(SoLuong)as TongSoLuong
 from ChiTietHoaDon 
WHERE DATEPART(m, NgayLapCTHD) = DATEPART(m, DATEADD(m, -1, getdate()))
AND DATEPART(yyyy, NgayLapCTHD) = DATEPART(yyyy, DATEADD(m, -1, getdate()))


--select doanh thu của năm nay
CREATE PROC select_DoanhThu_ThisYear
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE NgayLapHoaDon BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())+1, 0)


--select số lượng của năm nay

create proc select_SoSP_ThisYear
AS
select sum(SoLuong)AS TongSoLuong
 from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())+1, 0)

--select doanh thu của năm ngoái
create proc select_DoanhThu_LastYear
AS
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien
 from HoaDon 
WHERE NgayLapHoaDon BETWEEN 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE())-1, 0)
     AND 
     DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)
--select số lượng của năm ngoái
create proc select_SoSP_ThisYear
AS
select sum(SoLuong)AS TongSoLuong
 from ChiTietHoaDon 
WHERE NgayLapCTHD BETWEEN 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE()), 0)
     AND 
     DATEADD(YEAR, DATEDIFF(YEAR, 0, GETDATE())+1, 0)

--select doanh số theo phạm vi ngày
select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien from ChiTietHoaDon
where NgayLapCTHD >= '2020-01-04' and NgayLapCTHD<='2020-01-09'
--select số lượng sản phẩm theo phạm vi ngày
select sum(hd.TongTien)AS DoanhThu,count(hd.MaHoaDon)AS TongHoaDon,sum(cthd.SoLuong)AS TongSoSP from ChiTietHoaDon cthd JOIN HoaDon hd
on cthd.MaHoaDon=hd.MaHoaDon
Where hd.NgayLapHoaDon= '2020-01-08'


