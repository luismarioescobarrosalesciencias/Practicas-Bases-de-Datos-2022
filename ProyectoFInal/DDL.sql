DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

CREATE TABLE persona(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  nombre VARCHAR(50),
  apPat VARCHAR(50),
  apMat VARCHAR(50)
  calle VARCHAR(70)
  numero   int CHECK(numeroT BETWEEN 0 and 9999),
  cp     CHAR(5) CHECK (cpT SIMILAR TO '[0-9]{5}'),
  estado VARCHAR(30),
  email VARCHAR(80)  -- expresion regular probable
);
COMMENT ON TABLE persona IS 'Tabla que guarda los datos de una persona';
COMMENT ON COLUMN persona.curp IS 'Curp de la persona';
COMMENT ON COLUMN persona.nombre IS 'Nombre de la persona';
COMMENT ON COLUMN persona.apPat IS 'Apellido paterno de la persona';
COMMENT ON COLUMN persona.apMat IS 'Apellido materno de la persona';
COMMENT ON COLUMN persona.calle IS 'Nombre de la calle donde vive la persona';
COMMENT ON COLUMN persona.numero IS 'Numero de la calle donde vive la persona';
COMMENT ON COLUMN persona.cp IS 'Codigo postal de la ubicacion donde vive la persona';
COMMENT ON COLUMN persona.estado IS 'Estado donde vive la persona';
COMMENT ON COLUMN persona.email IS 'Correo electronico de una persona';

CREATE TABLE telefono(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),  --No es unico
  telefono CHAR(10) CHECK(telefono SIMILAR TO '[0-9]{10}') UNIQUE
  --PRIMARY KEY
  --PRIMARY KEY
);
COMMENT ON TABLE telefono IS 'Tabla que guarda el telefono de una persona '

CREATE TABLE cliente(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  puntosAcumulados int CHECK(idConsultorio >=0)
  --PRIMARY KEY curp
);

CREATE TABLE empleado(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc)=13) UNIQUE,
  nss CHAR(9) CHECK (cpT SIMILAR TO '[0-9]{9}') UNIQUE,
  fechaNacimiento DATE NOT NULL,
  fechadeIngreso DATE NOT NULL ,
  salario NUMERIC NOT NULL CHECK (salario > 0)

  --PRIMARY KEY curp
);

CREATE TABLE taquero(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE
  --PRIMARY KEY curp
);

CREATE TABLE parrillero(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE
  --PRIMARY KEY curp
);

CREATE TABLE cajero(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE
  --PRIMARY KEY curp
);

CREATE TABLE tortillero(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE
  --PRIMARY KEY curp
);

CREATE TABLE mesero(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE
  --PRIMARY KEY curp
);
CREATE TABLE repartidor(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
  licencia CHAR(14) CHECK (cpT SIMILAR TO '[0-9]{14}')
  --PRIMARY KEY curp
);
CREATE TABLE vehiculo(
   curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
   numeroSerie CHAR(18) NOT NULL CHECK(CHAR_LENGTH(numeroSerie)=17) UNIQUE  ,
   marca  CHAR(20),
   modelo CHAR(20),
   tipo   CHAR(20)
   --PRIMARY KEY curp
   --PRIMARY KEY numeroSerie
);

CREATE TABLE ticketmesa(
numero int CHECK(numero BETWEEN 1 and 10000)
--PRIMARY KEY (numero)
);
CREATE TABLE ticketAdomicilio(
  numero int CHECK(numero BETWEEN 1 and 10000)
  --Primary key (numero)
);

CREATE TABLE sucursal(
    idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
    calleS VARCHAR(70)  NOT NULL CHECK (calleS <>''),
    numeroS int NOT NULL CHECK(numeroS BETWEEN 1 and 9999),  -- No acepta numeros menores a 1 , ni mayores a 9999
    cpS CHAR(5) NOT NULL  CHECK (cpS SIMILAR TO '[0-9]{5}'), -- No acepta numeros menores a 00001 , ni mayores a 99999
    estadoS VARCHAR(50) NOT NULL  CHECK (estadoS <>''), --Deberia ser unique ?
    alcaldia VARCHAR(50) NOT NULL  CHECK (alcaldia <>''), --Deberia ser unique ?
    --PRIMARY KEY(idSucursal)
);
COMMENT ON TABLE sucursal IS 'Tabla que guarda todos los datos de una sucursal';
COMMENT ON COLUMN sucursal.idSucursal IS 'Guarda el identificador de la sucursal';
COMMENT ON COLUMN sucursal.calleS IS 'Calle donde esta la sucursal';
COMMENT ON COLUMN sucursal.numeroS IS 'Número de la localidad donde esta la sucursal';
COMMENT ON COLUMN sucursal.cpS IS 'Código postal de la sucursal';
COMMENT ON COLUMN sucursal.estadoS IS 'Estado donde esta la sucursal';
COMMENT ON COLUMN sucursal.alcaldia IS 'Alcaldía donde esta la sucursal';

CREATE TABLE proveedor(
    rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc)=13) UNIQUE,
    nombreP VARCHAR(50) NOT NULL  CHECK (nombre <>''),
    calleP VARCHAR(70) CHECK (calle <>''),
    numeroP int CHECK(numero BETWEEN 1 and 9999),  -- No acepta numeros menores a 1 , ni mayores a 9999
    cpP CHAR(5) CHECK (cp SIMILAR TO '[0-9]{5}'),  -- No acepta numeros menores a 00001 , ni mayores a 99999
    telefonoP CHAR(10) CHECK(telefonoP SIMILAR TO '[0-9]{10}') UNIQUE
    --PRIMARY KEY(rfc)
);
COMMENT ON COLUMN proveedor.rfc IS 'RFC del proveedor';
COMMENT ON COLUMN proveedor.nombreP IS 'Nombre del Veterinario';
COMMENT ON COLUMN proveedor.calleP IS 'Calle de la dirección donde vive el proveedor ';
COMMENT ON COLUMN proveedor.numeroP IS 'Número de la residencia del proveedor ';
COMMENT ON COLUMN proveedor.cpP IS 'Código Postal de la direccion del proveedor';
COMMENT ON COLUMN proveedor.telefonoP IS 'Número telefonico del proveedor';


CREATE TABLE inventario (
    idInventario int NOT NULL CHECK (idInventario >0) UNIQUE,
    tipoI CHAR(20) NOT NULL  CHECK (tipoI <>''),
    marcaI CHAR(15),
    cantidadI NUMERIC CHECK(cantidadI >= 0)
    --PRIMARY KEY(idInventario)
);
COMMENT ON TABLE inventario IS 'Tabla que guarda los datos del inventario';
COMMENT ON COLUMN inventario.idInventario  is 'Identificador del inventario';
COMMENT ON COLUMN inventario.tipoI  is 'Tipo de inventario';
COMMENT ON COLUMN inventario.marcaI  is 'La marca del inventario';
COMMENT ON COLUMN inventario.cantidadI  is 'La cantidad de productos en el inventario';

CREATE TABLE producto (
    idProducto int NOT NULL CHECK (idProducto > 0) UNIQUE,
    nombre VARCHAR(50) NOT NULL  CHECK (nombre <>''),
    tipo CHAR(20) NOT NULL  CHECK (tipo <>''),
    --PRIMARY KEY(idProducto)
);

COMMENT ON TABLE producto IS 'Tabla que guarda la información del producto';
COMMENT ON COLUMN producto.idProducto IS 'Identificador del producto';
COMMENT ON COLUMN producto.nombre IS  'Nombre del producto';
COMMENT ON COLUMN producto.tipo IS  'Tipo de producto';

CREATE TABLE salsa (
    idProducto int NOT NULL CHECK (idProducto > 0) UNIQUE,
    recomendacionPlatillo VARCHAR(100),
    presentacion VARCHAR(100),
    nivelPicor  VARCHAR(100),
);

COMMENT ON TABLE salsa IS 'Tabla que guarda la información de la salsa ';
COMMENT ON COLUMN salsa.idProducto IS  'Identificador de la salsa';
COMMENT ON COLUMN salsa.recomendacionPlatillo IS  'Recomendación de combinación de salsa y platillo';
COMMENT ON COLUMN salsa.presentacion  IS 'Presentación de la salsa en un platillo';
COMMENT ON COLUMN salsa.nivelPicor IS  'Nivel de picor de la salsa';
