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
	PhanQuyen bit not null,
)
go
insert into Account  values
('admin','admin',1),
('user','user',0);
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
('001',N'ABC','10/02/2001',1,N'Hà Nội',N'Công Nhân',N'15'),
('002',N'ABC','1/12/2001',1,N'Sài Gòn',N'Kỹ Sư',N'CNTT'),
('003',N'Lê Văn A','05/05/2001',0,N'Đà Nẵng',N'Nhân Viên',N'CNTT');
select * from CanBo
delete from CanBo where MaCanBo=''
update CanBo set ChucVu = N'Nhân Viên' where MaCanBo = '005'