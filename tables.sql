create database Evelyn2;
use Evelyn2;

create table usuarios(
	id_user int not null auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50),
    tipo_documento varchar(50),
    documento bigint,
    email varchar(50),
    telefono bigint,
    id_rol_fk int,
    contraseña varchar(50)
);
alter table usuarios add foreign key (id_rol_fk) references rol(id_rol);

create table rol (
	id_rol int not null auto_increment primary key,
    rol varchar(20)
);

create table inventarios(
	id_inventario int not null auto_increment primary key,
    descripcion varchar(50),
    cantidad int
);

create table entradas(
	id_entrada int not null primary key auto_increment,
    id_inventario_fk int,
    id_user_fk int,
    id_producto_fk int,
    descripcion varchar(50),
    cantidad int,
    fecha date
);
alter table entradas add foreign key (id_inventario_fk) references inventarios(id_inventario);
alter table entradas add foreign key (id_user_fk) references usuarios(id_user);
alter table entradas add foreign key (id_producto_fk) references productos(id_producto);

create table productos(
	id_producto int not null auto_increment primary key,
    descripcion varchar(50)
);

create table proveedores(
	id_proveedor int not null auto_increment primary key,
    nombre varchar(50),
    direccion varchar(50),
    telefono bigint
);

create table pedidos(
	id_pedido int not null auto_increment primary key,
    id_user_fk int,
    id_proveedor_fk int,
    id_producto_fk int,
    descripcion varchar(50),
    cantidad int,
    estado varchar(50),
    fecha date
);
alter table pedidos add foreign key (id_user_fk) references usuarios(id_user);
alter table pedidos add foreign key (id_proveedor_fk) references proveedores(id_proveedor);
alter table pedidos add foreign key (id_producto_fk) references productos(id_producto);


CREATE TABLE solicitudesProduccion (
    id_solicitud INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_user_fk INT,
    id_inventario_fk INT,
    descripcion VARCHAR(50),
    cantidad int,
    fecha DATE
);
alter table solicitudesproduccion add foreign key (id_user_fk) references usuarios(id_user);
alter table solicitudesproduccion add foreign key (id_inventario_fk) references inventarios(id_inventario);

create table ficha_solicitudes(
	id_produccion_fk int,
    id_solicitud_fk int
);
alter table ficha_solicitudes add foreign key (id_produccion_fk) references producciones(id_produccion);
alter table ficha_solicitudes add foreign key (id_solicitud_fk) references solicitudesproduccion(id_solicitud);

create table producciones(
	id_produccion int not null auto_increment primary key,
    id_producto_fk int,
    descripcion varchar(50),
    genero varchar(5),
    talla varchar(5),
    color varchar(50),
    cantidad int,
    precio double,
    fecha date
);
alter table producciones add foreign key (id_producto_fk) references productos(id_producto);



