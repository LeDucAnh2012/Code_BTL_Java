use master
go 
drop database QLCanBo
go
use master
go
create database QLCanBo
go
use QLCanBo
go
Create table Account(
	UserName varchar(50) not null primary key,
	PassWord_ varchar(50) not null,
)
go
insert into Account  values
('abc','abc');
go
create table CanBo(
	MaCanBo varchar(10) Primary key,
	TenCanBo nvarchar(50) not null,
	NamSinh date not null,
	GioiTinh bit not null,
	DiaChi nvarchar(100) not null,
	ChucVu nvarchar(10) not null, check (ChucVu = N'Công Nhân' OR ChucVu = N'Kỹ Sư' OR ChucVu = N'Nhân Viên'),
	ThuocTinh nvarchar(100) not null,
)
insert into CanBo values
('001',N'ABC','10/02/2001',1,N'Ha Noi','Công Nhân','15');
select * from CanBo