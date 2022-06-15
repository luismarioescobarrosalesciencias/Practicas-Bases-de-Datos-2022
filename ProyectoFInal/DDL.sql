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
  email VARCHAR(80)
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
  --un usuario puede tener varios telefonos pero un telefono solo esta asociado a una persona
  --se puede repetir el curp en la tabla per no los telefonos
);
COMMENT ON TABLE telefono IS 'Tabla que guarda el telefono de una persona '

CREATE TABLE cliente(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  puntosAcumulados
  --Los clientes que son empleados tienen el servicio gratis procedimiento almacenado
  --PRIMARY KEY curp
);
--promociones
--costo
--precio nulo empleados
--aumento de salario por antiguedad
--
CREATE TABLE empleado(
  curp  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
  rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc)=13) UNIQUE,
  nss CHAR(9) CHECK (cpT SIMILAR TO '[0-9]{9}') UNIQUE,
  fechaNacimiento DATE NOT NULL,
  fechadeIngreso DATE NOT NULL ,
  salario NUMERIC NOT NULL CHECK (salario > 0)
  antiguedad DATE NOT NULL, -- (procedimientos almacenados )
  edad DATE NOT NULL
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
   curp  CHAR(18)  CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
   numeroSerie CHAR(18) NOT NULL CHECK(CHAR_LENGTH(numeroSerie)=17) ,
   marca  CHAR(20),
   modelo CHAR(20),
   tipo   CHAR(20)
   --los vehiculos pueden ser de la empresa y pueden ser prestados (suposicion)
   --PRIMARY KEY curp
   --PRIMARY KEY numeroSerie
);

CREATE TABLE ticketmesa(
numeroTM int CHECK(numero BETWEEN 1 and 10000) UNIQUE,
curpc  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
curpm  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
fecha DATE NOT NULL,
tipoPago CHAR(1) NOT NULL CHECK (tipoPago SIMILAR TO '(t|T|e|E|p|P)' )
subtotal NUMERIC NOT NULL, --triggers
total NUMERIC NOT NULL --triggers
--PRIMARY KEY (numero)
);
CREATE TABLE ticketAdomicilio(
  numeroAD int CHECK(numero BETWEEN 1 and 10000) UNIQUE,
  curpc  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  curpr  CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18) UNIQUE,
  idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
  fecha DATE NOT NULL,
  tipoPago CHAR(1) NOT NULL CHECK (tipoPago SIMILAR TO '(t|T|e|E|p|P)' )
  subtotal NUMERIC NOT NULL, --triggers
  total NUMERIC NOT NULL
  --Primary key (numero)
);

CREATE TABLE sucursal(
    idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
    rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc)=13) UNIQUE,
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
    marcaI CHAR(15),   --posible procedimiento almacenado
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
CREATE TABLE ingrediente(
  idIngrediente int NOT NULL CHECK (idProducto > 0) UNIQUE,
  marca VARCHAR(30),
  nombreI VARCHAR(30) NOT NULL,
  unidadmedida NUMERIC NOT NULL,
  cantidadIg int NOT NULL,
  fechaCaducidad DATE NOT NULL

);


COMMENT ON TABLE producto IS 'Tabla que guarda la información del producto';
COMMENT ON COLUMN producto.idProducto IS 'Identificador del producto';
COMMENT ON COLUMN producto.nombre IS  'Nombre del producto';
COMMENT ON COLUMN producto.tipo IS  'Tipo de producto';

CREATE TABLE salsa (
    idProducto int NOT NULL CHECK (idProducto > 0) UNIQUE,
    presentacion VARCHAR(100),
    nivelPicor  VARCHAR(100),
);

COMMENT ON TABLE salsa IS 'Tabla que guarda la información de la salsa ';
COMMENT ON COLUMN salsa.idProducto IS  'Identificador de la salsa';
COMMENT ON COLUMN salsa.recomendacionPlatillo IS  'Recomendación de combinación de salsa y platillo';
COMMENT ON COLUMN salsa.presentacion  IS 'Presentación de la salsa en un platillo';
COMMENT ON COLUMN salsa.nivelPicor IS  'Nivel de picor de la salsa';

CREATE TABLE precio(
  idProducto int NOT NULL CHECK (idProducto > 0) UNIQUE,
  idPrecio int NOT NULL CHECK (idProducto > 0) UNIQUE,
  precio NUMERIC NOT NULL,
  fecha DATE NOT NULL
);


CREATE TABLE tener(
    idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
    idInventario int NOT NULL CHECK (idInventario >0) UNIQUE,
    cantidad int NOT NULL

);
CREATE TABLE disponer(
  idSucursal int NOT NULL CHECK (idSucursal > 0) UNIQUE,
  idIngrediente int NOT NULL CHECK (idProducto > 0) UNIQUE

);
CREATE TABLE surtir(
  idIngrediente int NOT NULL   CHECK (idProducto > 0),
  rfc CHAR(13) NOT NULL CHECK(CHAR_LENGTH(rfc)=13),
  precio NUMERIC NOT NULL,
  cantidad int NOT NULL
);

CREATE TABLE integrar(
    idIngrediente int NOT NULL CHECK (idProducto > 0),
    idProducto int  CHECK (idProducto > 0),
    cantidad int NOT NULL CHECK (cantidad >0)
);

CREATE TABLE consumirmesa(
  numero int CHECK(numero BETWEEN 1 and 10000) ,
  idProducto int NOT NULL CHECK (idProducto > 0)
);

CREATE TABLE consumiraDomicilio(
  numero int CHECK(numero BETWEEN 1 and 10000) ,
  idProducto int NOT NULL CHECK (idProducto > 0)
);

CREATE TABLE enviar(
  idInventario int NOT NULL CHECK (idInventario >0) UNIQUE,
  rfc CHAR(13)  CHECK(CHAR_LENGTH(rfc)=13),
  precioe NUMERIC NOT NULL,
  cantidade int NOT NULL
);
CREATE TABLE recomendar (
idProducto int  CHECK (idProducto > 0) ,
idProductos int  CHECK (idProducto > 0)
);



--Llaves primarias
ALTER TABLE persona ADD CONSTRAINT persona_pkey PRIMARY KEY (curp);
ALTER TABLE cliente ADD CONSTRAINT cliente_pkey PRIMARY KEY (curp);
ALTER TABLE empleado ADD CONSTRAINT empleado_pkey PRIMARY KEY (curp);
ALTER TABLE taquero ADD CONSTRAINT taquero_pkey PRIMARY KEY (curp);
ALTER TABLE parrillero ADD CONSTRAINT parrillero_pkey PRIMARY KEY (curp);
ALTER TABLE cajero ADD CONSTRAINT cajero_pkey PRIMARY KEY (curp);
ALTER TABLE tortillero ADD CONSTRAINT tortillero_pkey PRIMARY KEY (curp);
ALTER TABLE mesero ADD CONSTRAINT mesero_pkey PRIMARY KEY (curp);
ALTER TABLE repartidor ADD CONSTRAINT repartidor_pkey PRIMARY KEY (curp);
ALTER TABLE sucursal ADD CONSTRAINT sucursal_pkey PRIMARY KEY (idSucursal);
ALTER TABLE inventario ADD CONSTRAINT inventario_pkey PRIMARY KEY (idInventario);
ALTER TABLE ingrediente ADD CONSTRAINT ingrediente_pkey PRIMARY KEY (idIngrediente);
ALTER TABLE producto ADD CONSTRAINT producto_pkey PRIMARY KEY (idProducto);
ALTER TABLE proveedor ADD CONSTRAINT proveedor_pkey PRIMARY KEY (rfc);
ALTER TABLE salsa ADD CONSTRAINT idProducto_pkey PRIMARY KEY(idProducto);

 --Llaves compuestas y foraneas
--vehiculo,precio,telefono

ALTER TABLE telefono ADD CONSTRAINT telefono_pkey PRIMARY KEY (curp,telefono);

ALTER TABLE vehiculo ADD CONSTRAINT vehiculo_pkey PRIMARY KEY (curp,numeroSerie);

ALTER TABLE precio ADD CONSTRAINT precio_pkey PRIMARY KEY (idProducto,idPrecio);

ALTER TABLE empleado ADD CONSTRAINT empleado_pkey PRIMARY KEY (curp);
ALTER TABLE empleado ADD CONSTRAINT empleado_fkey FOREIGN KEY(idSucursal) REFERENCES sucursal(idSucursal)

ALTER TABLE ticketmesa ADD CONSTRAINT ticketmesaN_pkey PRIMARY KEY (numeroTM);
ALTER TABLE ticketmesa ADD CONSTRAINT ticketmesaC_fkey FOREIGN KEY(curpc) REFERENCES cliente(curp);
ALTER TABLE ticketmesa ADD CONSTRAINT ticketmesaCm_fkey FOREIGN KEY(curpm) REFERENCES cliente(curp);
ALTER TABLE ticketmesa ADD CONSTRAINT ticketmesaS_fkey FOREIGN KEY(idSucursal) REFERENCES sucursal(idSucursal);

ALTER TABLE ticketAdomicilio ADD CONSTRAINT ticketAN_pkey PRIMARY KEY (numeroTM);
ALTER TABLE ticketAdomicilio ADD CONSTRAINT ticketAC_fkey FOREIGN KEY(curpc) REFERENCES cliente(curp);
ALTER TABLE ticketAdomicilio ADD CONSTRAINT ticketACm_fkey FOREIGN KEY(curpr) REFERENCES cliente(curp);
ALTER TABLE ticketAdomicilio ADD CONSTRAINT ticketAS_fkey FOREIGN KEY(idSucursal) REFERENCES sucursal(idSucursal);

ALTER TABLE tener  ADD CONSTRAINT tenerS_fkey FOREIGN KEY(idSucursal) REFERENCES sucursal(idSucursal);
ALTER TABLE tener  ADD CONSTRAINT tenerI_fkey FOREIGN KEY(idInventario) REFERENCES inventario(idInventario);

ALTER TABLE disponer  ADD CONSTRAINT disponerS_fkey FOREIGN KEY(idSucursal) REFERENCES sucursal(idSucursal);
ALTER TABLE disponer  ADD CONSTRAINT disponerI_fkey FOREIGN KEY(idIngrediente) REFERENCES ingrediente(idIngrediente);


ALTER TABLE consumirmesa ADD CONSTRAINT consumirmesaN_fkey FOREIGN KEY(numero) REFERENCES sucursal(idSucursal);
ALTER TABLE consumirmesa ADD CONSTRAINT consumirmesaP_fkey FOREIGN KEY(idProducto) REFERENCES producto(idProducto);

ALTER TABLE consumiraDomicilio ADD CONSTRAINT consumirAN_fkey FOREIGN KEY(numero) REFERENCES sucursal(idSucursal);
ALTER TABLE consumiraDomicilio ADD CONSTRAINT consumirAP_fkey FOREIGN KEY(idProducto) REFERENCES producto(idProducto);

ALTER TABLE surtir ADD CONSTRAINT surtir_fkey FOREIGN KEY(idIngrediente) REFERENCES ingrediente(idIngrediente);
ALTER TABLE surtir ADD CONSTRAINT surtirP_fkey FOREIGN KEY(rfc) REFERENCES proveedor(rfc);

ALTER TABLE integrar ADD CONSTRAINT integrarI_fkey FOREIGN KEY (idIngrediente) REFERENCES ingrediente(idIngrediente);
ALTER TABLE integrar ADD CONSTRAINT integrarP_fkey FOREIGN KEY (idProducto) REFERENCES producto(idProducto);

ALTER TABLE enviar ADD CONSTRAINT enviarI_fkey FOREIGN KEY (idInventario) REFERENCES inventario(idInventario);
ALTER TABLE enviar ADD CONSTRAINT enviarRFC_fkey FOREIGN KEY (rfc) REFERENCES proveedor(rfc);

ALTER TABLE recomendar ADD CONSTRAINT recomendarP_fkey FOREIGN KEY (idProducto) REFERENCES producto(idProducto);
ALTER TABLE recomendar ADD CONSTRAINT recomendarS_fkey FOREIGN KEY (idProducto) REFERENCES salsa(idProducto);
