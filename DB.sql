CREATE DATABASE chapinmarket;

CREATE SCHEMA rtienda;
CREATE SCHEMA manejoproducto;
CREATE SCHEMA rcliente;
CREATE SCHEMA ventas;

CREATE TABLE rtienda.Tienda(
    Id VARCHAR(10)  NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY(Id)
);

CREATE TABLE rtienda.Sucursal(
    Id VARCHAR(10) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Tienda VARCHAR(10) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(Tienda) REFERENCES rtienda.Tienda(Id)
);

CREATE TABLE rtienda.Administrador(
    Id VARCHAR(10) NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Contrasena VARCHAR(20) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(Id) REFERENCES rtienda.Tienda(Id)
);

CREATE TABLE rtienda.Empleado(
    Id SERIAL,
    CUI VARCHAR(14) NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    Nacimiento DATE NOT NULL,
    Telefono VARCHAR(9) NOT NULL,
    Direccion VARCHAR(30) NOT NULL,
    Sueldo   DECIMAL NOT NULL,
    Sucursal VARCHAR(10) NOT NULL,
    PRIMARY KEY(Id),
    UNIQUE(CUI),
    FOREIGN KEY(Sucursal) REFERENCES rtienda.Sucursal(Id)
);

--1: Admin
--2: Inventario
--3: Bodega
--4: Cajero

CREATE TABLE rtienda.Usuario(
    Nombre VARCHAR(20) NOT NULL,
    Contrasena VARCHAR(20) NOT NULL,
    Tipo INT NOT NULL,
    Empleado INT NOT NULL,
    Caja INT,
    PRIMARY KEY(Empleado),
    UNIQUE(Nombre), 
    FOREIGN KEY(Empleado) REFERENCES rtienda.Empleado(Id)
);

CREATE TABLE manejoproducto.Producto(
    Id VARCHAR(10) NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Marca VARCHAR(10) NOT NULL,
    Sucursal VARCHAR(10) NOT NULL,
    Precio DECIMAL NOT NULL,
    Pasillo VARCHAR(3) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(Sucursal) REFERENCES rtienda.Sucursal(Id)
);

CREATE TABLE rcliente.Cliente(
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    Telefono VARCHAR(8) NOT NULL,
    NIT     VARCHAR(9) NOT NULL,
    Gastado INT  DEFAULT 0,
    PRIMARY KEY(NIT)
);

CREATE TABLE rcliente.Tarjeta(
    Id VARCHAR(10),
    Cliente VARCHAR(9) NOT NULL,
    Tipo INT NOT NULL,
    Puntos INT NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(Cliente) REFERENCES rcliente.Cliente(NIT)
);

CREATE TABLE manejoproducto.Inventario(
    Sucursal VARCHAR(10) NOT NULL,
    Producto VARCHAR(10) NOT NULL,
    Existencia INT NOT NULL,
    PRIMARY KEY(Sucursal,Producto),
    FOREIGN KEY(Sucursal) REFERENCES rtienda.Sucursal(Id),
    FOREIGN KEY(Producto) REFERENCES manejoproducto.Producto(Id)
);

CREATE TABLE manejoproducto.Estantes(
    Sucursal VARCHAR(10) NOT NULL,
    Producto VARCHAR(10) NOT NULL,
    Cantida  INT NOT NULL,
    PRIMARY KEY(Sucursal,Producto),
    FOREIGN KEY(Sucursal) REFERENCES rtienda.Sucursal(Id),
    FOREIGN KEY(Producto) REFERENCES manejoproducto.Producto(Id)
);


CREATE TABLE ventas.Venta(
    Factura VARCHAR(8) NOT NULL,
    Cliente VARCHAR(9),
    Empleado INT NOT NULL,
    Total INT NOT NULL,
    TotalDescuento INT NOT NULL,
    Sucursal VARCHAR(10) NOT NULL,
    PRIMARY KEY(Factura),
    FOREIGN KEY(Cliente) REFERENCES rcliente.Cliente(NIT),
    FOREIGN KEY(Empleado) REFERENCES rtienda.Empleado(Id),
    FOREIGN KEY(Sucursal) REFERENCES rtienda.Sucursal(Id)
);

CREATE TABLE ventas.Descripcion(
    Id SERIAL,
    Factura VARCHAR(8) NOT NULL,
    Producto VARCHAR(10) NOT NULL,
    Cantidad INT NOT NULL,
    Total   INT,
    PRIMARY KEY(Id,Factura),
    FOREIGN KEY(Producto) REFERENCES manejoproducto.Producto(Id)
);


CREATE OR REPLACE FUNCTION total_venta()
RETURNS TRIGGER AS 
$$
DECLARE
    total_venta INT;
BEGIN
    SELECT SUM(Total) INTO total_venta FROM venta.Descripcion WHERE Factura = NEW.Factura;
    UPDATE ventas.venta
    SET Total = total_venta;
    RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;
CREATE TRIGGER actualizar_totalventa
AFTER INSERT ON ventas.venta
FOR EACH ROW
EXECUTE FUNCTION total_venta();


CREATE OR REPLACE FUNCTION calcular_total()
RETURNS TRIGGER AS 
$$
BEGIN
    UPDATE ventas.Descripcion
    SET Total = NEW.Cantidad * p.Precio
    FROM manejoproducto.producto p
    WHERE ventas.Descripcion.Producto = p.Id AND ventas.Descripcion.Factura = NEW.Factura;
    RETURN NEW;

END;
$$ 
LANGUAGE plpgsql;
CREATE TRIGGER actualizar_total
AFTER INSERT ON ventas.Descripcion
FOR EACH ROW
EXECUTE FUNCTION calcular_total();



CREATE ROLE Cajero;
CREATE ROLE Bodega;
CREATE ROLE Inventario;
CREATE ROLE Administrador;

GRANT USAGE ON SCHEMA rcliente,ventas TO Cajero;
GRANT USAGE ON SCHEMA manejoproducto TO Bodega;
GRANT USAGE ON SCHEMA manejoproducto TO Inventario;
GRANT USAGE ON SCHEMA rtienda,manejoproducto,rcliente,ventas TO  Administrador;
GRANT USAGE ON SCHEMA rtienda TO Administrador;
GRANT USAGE ON SCHEMA manejoproducto TO Administrador;
GRANT USAGE ON SCHEMA rcliente TO Administrador;
GRANT USAGE ON SCHEMA ventas TO Administrador;
GRANT USAGE, SELECT ON ventas.descripcion_id_seq TO Administrador;

--Falta asignarle acciones que podra utilizar
GRANT INSERT,UPDATE,SELECT ON TABLE rtienda.Usuario  TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE rtienda.Empleado TO Administrador;
GRANT INSERT,UPDATE,SELECT,DELETE ON TABLE rtienda.Empleadonousuario TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE rtienda.Sucursal TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE rcliente.Cliente TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE manejoproducto.producto TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE ventas.Descripcion TO Administrador;
GRANT INSERT,UPDATE,SELECT ON TABLE ventas.venta TO Administrador;

GRANT UPDATE ON TABLE rcliente.Cliente TO Administrador;
GRANT INSERT ON TABLE rcliente.Tarjeta TO Administrador;
GRANT INSERT,UPDATE ON TABLE rcliente.Cliente TO Cajero;
GRANT INSERT ON TABLE ventas.Venta TO Cajero;
GRANT INSERT ON TABLE ventas.Descripcion TO Cajero;
GRANT INSERT,UPDATE ON TABLE manejoproducto.Producto TO Bodega; 
GRANT INSERT ON TABLE manejoproducto.Inventario TO Bodega;
GRANT INSERT,SELECT ON TABLE manejoproducto.Estantes TO Inventario;

CREATE USER Usuario1 WITH PASSWORD 'usuario1abc';
CREATE USER Usuario2 WITH PASSWORD 'bodega_chapinmarker';
CREATE USER Usuario3 WITH PASSWORD 'abc1548_02';
CREATE USER Usuario4 WITH PASSWORD 'abcdef';

GRANT Cajero TO Usuario1;
GRANT Bodega TO Usuario2;
GRANT Inventario TO Usuario3;
GRANT Administrador TO Usuario4;



psql -h localhost -U usuario1 -d tienda





SELECT e.Id AS id, e.CUI, e.Nombre AS nombre, e.Apellido, e.Nacimiento, e.Telefono, e.Direccion, e.Sueldo, e.Sucursal
FROM rtienda.Empleado e
LEFT JOIN rtienda.Usuario u ON e.Id = u.Empleado
WHERE u.Empleado IS  NULL