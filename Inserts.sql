INSERT INTO rtienda.Tienda VALUES('1AA','SUPERMERCADO CHAPINMARKET');

INSERT INTO rtienda.Sucursal VALUES
('3','SUCURSAL NORTE','1AA'),
('2','SUCURSAL SUR','1AA'),
('1','SUCURSAL CENTRAL','1AA');

INSERT INTO rtienda.Empleado(CUI,Nombre,Apellido,Nacimiento,Telefono,Direccion,Sueldo,Sucursal) VALUES
('3307535761202','Jhony Roel','Fuentes Lopez','2002-01-19','42882130','San Marcos',3500,'1'),
('1205481236120','Luis Pedro','Garcia Fuentes','2000-01-25','15489675','Quetzaltenango',4500,'1'),
('1234567891023','Luis Carlos','Garcia Lopez','1998-01-25','15489875','Quiche',3500,'1'),
('4589768521459','Carlos Angel','Martinez','1980-02-25','12345678','Totonicapan',4500,'1'),
('0157894020132','Luis Alejandro','Monterroso Guzman','2002-01-25','15489673','Izabal',2500,'1'),
('1978654230789','Ernesto','Lopez Lopez','2000-01-25','15480275','Santa Rosa',3500,'1'),
('0105060708912','Alejandra','Fuentes Fuentes','2000-01-25','25489675','Santa Cruz,Quiche',1500,'1'),
('1234567898999','Angie ','Navarro Fuentes','2002-01-19','32882130','San Pedro',2500,'1'),
('0123457890125','Maria','Gomez Gomez','2000-01-25','55489675','Huehuetenango',3500,'1'),
('1478965236985','Ana','Orozco Fuentes','2000-01-25','65489675','Quetzaltenango',4500,'1'),
('4589768525459','Ana Maria','Fuentes Fuentes','2000-01-25','75489675','Quetzaltenango',5500,'1'),
('0157894023132','Maria Ana','Lopez Lopez','2000-01-25','15889675','Quetzaltenango',3600,'2'),
('2978654230789','Fernado','Garcia','2000-01-25','15489625','San Marcos',3800,'2'),
('3105060708912','Esteban','Fuentes Lopez','2000-01-25','15489275','Peten',3900,'2'),
('4307535761202','Rocio','Fuentes Lopez','2002-01-19','42882110','Peten',4500,'2'),
('6205481236120','Alejandra','Garcia Fuentes','2000-01-25','15789675','Quetzaltenango',3500,'2'),
('7205481236120','Monika','Fuentes Fuentes','2000-01-25','15486675','Quetzaltenango',4500,'2'),
('9234567891023','Gerson','Mendez Rivera','2000-01-25','15489475','Santa Lucia',5500,'2'),
('8589768521459','Gabriela','Rivera Mendez','2000-01-25','15409675','Tacana,San Marcos',6500,'2'),
('0157894520132','Gabriel','Orozco Fuentes','2000-01-25','15419675','Quetzaltenango',4500,'2'),
('1978654130789','Jose Luis','Escobar Escobar','2000-01-25','15480675','Jutiapa',5500,'2'),
('0105060208912','Luis Jose','Godinez Godinez','2000-01-25','15400675','Jalapa',3500,'2'),
('3307535361202','Marlon','Hernandez Lopez','2002-01-19','41882130','Santa Rosa',2500,'3'),
('1205481436120','Miguel Ange','Tul Fuentes','2000-01-25','10489675','Quetzaltenango',3500,'3'),
('1234567591023','Angel Miguel','Lopez Tul','2000-01-25','11489675','Quetzaltenango',2500,'3'),
('4589768621459','Josue','Alvarado Fuentes','2000-01-25','12489675','Quetzaltenango',4500,'3'),
('0157894720132','Jesus','Mazariegos Alvarado','2000-01-25','15489312','Quetzaltenango',5500,'3'),
('1978654830789','Emanuel Jesus','Ramirez Carreto','2000-01-25','12389675','Quetzaltenango',2500,'3'),
('0105060908912','Carlos Josue','Castro Godinez','2000-01-25','15489657','Quetzaltenango',1500,'3'),
('3307535761201','Carlos Roberto','Gonzales Escobar','2002-01-19','24882130','San Marcos',3500,'3'),
('1225481236120','Roberto Carlos','Lopez Quiroa','2000-01-25','24489675','Quetzaltenango',5500,'3'),
('3307535761200','Lionel Messi','Fuentes','2002-01-19','42882335','San Marcos',3300,'3'),
('1315481236120','Albert','Einstein','2000-01-25','15489672','Quetzaltenango',3590,'3'),
('3307535861202','Linus','Torvald','2002-01-19','42882131','San Marcos',3578,'1'),
('1215481236120','Richard','Stallman','2000-01-25','15489670','Quetzaltenango',3570,'1');

INSERT INTO rtienda.Usuario VALUES
('Jhony19','hola123',4,1,1),
('Luisl','pasdfax1',4,2,2),
('LuisC','ASDFD',4,3,3);
('Car1','holamundo',4,4,4),
('LuisM','archivos1235a',4,5,5),
('Ernesto','java_123',4,6,6),
('Ale2548','Aale_125',2,7),
('Angie12','password',2,8),
('MGomez','holamundoxt',2,9),
('Ana','supermarket__12',2,10),
('Maria2000','asdf1588',3,11),

('Fer1548','301asdfbde',4,12,1),
('_Esteban','admin1234admin',4,13,2),
('RocioGar','_RorcioO.F',4,14,3),
('AleF25','123456789',4,15,4),
('MonFuente','135AS',4,16,5),
('GerMendez','HOLAccdE1#15',4,17,6),
('GaRivera','13.ASD_AS',2,18),
('GaFuentes','12345__0',2,19),
('JoEscobar','12345',2,20),
('Luis1540','12345',2,21),
('Mar3307','12345',3,22),


('MigAnge','12345',4,23,1),
('Angel_1148','Angl__angel11',4,24,2),
('JoAlvarado','Alvarado_1548',4,25,3),
('JeMaza','JeMazaasdf',4,26,4),
('Ema123','12345ASDFAS',4,27,5),
('Carlos2000','asdf_ASd11',4,28,6);
('RobertoQ','Robert_asd_Q',2,29),
('LioMessi','LMessi10',2,30),
('Einstein12','Relatividad_s',2,31),
('LinuxT','Linux__TUX',2,32);
('GNURichard','esgnu_linuxnolinux',3,33),


//Producto

INSERT INTO manejoproducto.producto VALUES('AB','Jugo V8','FRUTAL','1',3.25,2);