create database Papeleria;

use Papeleria;

create table Vendedores (
idVendedor int auto_increment,
NombreVendedor varchar(70),
SexoVendedor varchar(15),
DomicilioVendedor varchar(50),
CorreoVendedor varchar(50),
ContrasenaVendedor varchar(50),
ImagenVendedor varchar(50) default('imagenvendedor.jpg'),
activo boolean default(true),
primary key (idVendedor)
);

create table Productos(
idProductos int auto_increment,
nombreProducto varchar(30) not null,
Existencias int default(0),
PrecioCompra double not null,
PrecioVenta double not null,
Categoria varchar(30) not null,
primary key(idProductos)
);

create table Provedores(
idProvedores int auto_increment,
nombreProvedor varchar(30)not null,
codigoProvedor int(10),
telefonoProvedor varchar(15),
correoProvedor varchar(30)not null,
producto varchar(50)not null,
cantidad int(5),
activo boolean default(true),
primary key(idProvedores)
);

create table Usuarios(
idUsuario int auto_increment,
nicknameUsuario varchar (50) not null,
nombreUsuario varchar (50) not null,
apellidosUsuario varchar (50) not null,
telefonoUsuario varchar (14) not null,
correoUsuario varchar (50) not null,
contraseñaUsuario varchar (50) not null,
primary key (idUsuario)
);

create table Inventario(
IdInventario int auto_increment,
Nombre varchar(50),
Marca varchar(20),
Consumibles varchar (50),
Categoria varchar(50),
existenciasCon int default(0),
primary key (IdInventario)
);

create table Ventas(
idVentas int auto_increment,
numeroVenta varchar(20),
nombreCliente varchar(50),
categoriaProducto varchar(30),
cantidad int,
precioVenta double,
fechaVenta varchar(30),
primary key(idVentas)
);

select * from Vendedores;



drop table cliente;

