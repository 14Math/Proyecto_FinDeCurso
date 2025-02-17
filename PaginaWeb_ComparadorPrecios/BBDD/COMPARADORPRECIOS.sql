create database Comparador_Precios;
use Comparador_Precios;

CREATE TABLE CLIENTES
(
ID_CLIENTE INT NOT NULL auto_increment primary KEY,
USERNAME VARCHAR(45) NOT NULL,
PASSWORD VARCHAR(200) NOT NULL,
EMAIL VARCHAR(100) NOT NULL UNIQUE,
NOMBRE VARCHAR(30) NOT NULL,
APELLIDOS VARCHAR(45) NOT NULL,
DIRECCION VARCHAR(100) NOT NULL,
ENABLED INT NOT NULL DEFAULT 1,
FECHA_REGISTRO DATE
);


CREATE TABLE PROVEDORES(
ID_PROVEDOR INT NOT NULL auto_increment primary KEY,
USERNAME VARCHAR(45) NOT NULL ,
PASSWORD VARCHAR(200) NOT NULL,
EMAIL VARCHAR(100) NOT NULL UNIQUE,
EMPRESA VARCHAR(45) NOT NULL UNIQUE,
FECHA_REGISTRO DATE
);


-- Insertar datos en la tabla CLIENTE
INSERT INTO CLIENTES (USERNAME, PASSWORD, EMAIL, NOMBRE, APELLIDOS, DIRECCION, FECHA_REGISTRO)
VALUES
('Matrix', 'Matrix1234', 'mathew@ifp.com', 'Mathew', 'Loor Muñoz', 'Paseo de la Castellana, 100', '2023-10-26'),
('Savg', 'Savg1234', 'alejandra@ifp.com', 'Alejandra', 'Villalva González', 'Calle de Alcalá, 50', '2023-10-25'),
('keven100', 'keven1234', 'keven@ifp.com', 'Keven', 'Pereira', 'Gran Vía, 25', '2023-10-24');

-- Insertar datos en la tabla PROVEDOR
INSERT INTO PROVEDORES (USERNAME, PASSWORD, EMAIL, EMPRESA, FECHA_REGISTRO)
VALUES
('Matrix7', 'Matrix1234', 'mathew@prov.com',  'La Fuente, S.A.', '2023-10-23'),
('Savg7', 'Savg1234', 'alejandra@prov.com', 'El Corte Inglés, S.A.', '2023-10-22'),
('keven7', 'keven1234', 'keven@prov.com', 'Almacén General, S.L.', '2023-10-21');


CREATE TABLE CATEGORIAS (
  ID_CATEGORIA INT PRIMARY KEY AUTO_INCREMENT,
  NOMBRE VARCHAR(35) UNIQUE
);
-- Insertar categorías
INSERT INTO CATEGORIAS (NOMBRE) VALUES
('Teléfonos'),
('Auriculares'),
('Consolas'),
('Videojuegos'),
('Libros'),
('Perfumes'),
('Juguetes');
-- PEERFUMERIA,VIDEOJUEGOS,LIBROS,JUGUETES
-- Tabla PRODUCTOS
CREATE TABLE PRODUCTOS (
  ID_PRODUCTO INT NOT NULL PRIMARY KEY,
  NOMBRE VARCHAR(100) NOT NULL,
  MARCA VARCHAR(35) NOT NULL,
  AUTOR VARCHAR(35) NULL,
  DESCRIPCION VARCHAR(100) NOT NULL,
  PRECIO_VENTA DEC(9,2) NULL,
  ID_CATEGORIA INT not null,
  
  FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIAS(ID_CATEGORIA)
);
-- ELECTRONICA
	-- Teléfonos
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA,ID_CATEGORIA) VALUES
-- iPhones
(2460,'iPhone 14 Pro', 'Apple', 'Teléfono de alta gama con cámara avanzada y diseño elegante', 1099.00,1),
(3088,'iPhone 14', 'Apple', 'Teléfono con chip A15 Bionic y pantalla Super Retina XDR', 1009.00, 1),
(5791,'iPhone SE (2022)', 'Apple', 'Teléfono compacto con chip A15 Bionic y botón de inicio', 529.00, 1),
(0658,'iPhone 13 mini', 'Apple', 'Teléfono pequeño y potente con chip A15 Bionic', 809.00, 1),
(2877,'iPhone 12 Pro Max', 'Apple', 'Teléfono con triple cámara y pantalla Super Retina XDR', 1209.00, 1),
(6095,'iPhone 15 Pro', 'Apple', 'Teléfono de alta gama con cámara mejorada y diseño de titanio', 1329.00, 1),
(9653,'iPhone 15 Pro Max', 'Apple', 'Teléfono de alta gama con cámara periscópica y diseño de titanio', 1429.00, 1),
(3827,'iPhone 15', 'Apple', 'Teléfono con Dynamic Island y cámara de 48 MP', 959.00, 1),
(4962,'iPhone 15 Plus', 'Apple', 'Teléfono con Dynamic Island y batería de larga duración', 1059.00, 1),
-- iPhones
-- Samsung
(1607,'Galaxy S24 Ultra', 'Samsung', 'Teléfono de alta gama con cámara excepcional y S Pen', 1409.00, 1),
(9874,'Galaxy S24', 'Samsung', 'Teléfono de gama alta con diseño elegante y rendimiento potente', 969.00, 1),
(5256,'Galaxy Z Fold5', 'Samsung', 'Teléfono plegable innovador que se transforma en tableta', 1909.00, 1),
(8052,'Galaxy Z Flip5', 'Samsung', 'Teléfono plegable compacto y elegante', 1209.00, 1),
(7531,'Galaxy A54', 'Samsung', 'Teléfono de gama media con buena cámara y batería', 489.00, 1),
(3690,'Galaxy M14', 'Samsung', 'Teléfono con gran batería para una larga duración', 219.00, 1),
(2045,'Galaxy S23 Ultra', 'Samsung', 'Teléfono de alta gama con cámara de 200MP y S Pen', 1209.00, 1),
(3786,'Galaxy S23', 'Samsung', 'Teléfono de gama alta con diseño elegante y rendimiento potente', 859.00, 1),
(4183,'Galaxy Z Fold4', 'Samsung', 'Teléfono plegable innovador que se transforma en tableta', 1709.00, 1),
(3220,'Galaxy Z Flip4', 'Samsung', 'Teléfono plegable compacto y elegante', 1009.00, 1),
-- Samsung
-- OPPO
(6304,'Find X6 Pro', 'OPPO', 'Teléfono de alta gama con cámara Hasselblad de segunda generación', 1099.00, 1),
(2789,'Find N2', 'OPPO', 'Teléfono plegable innovador con diseño elegante y compacto', 1499.00, 1),
(1947,'Reno11 Pro', 'OPPO', 'Teléfono con diseño elegante, cámara versátil y rendimiento sólido', 599.00, 1),
(9152,'A98 5G', 'OPPO', 'Teléfono con gran batería, carga rápida y cámara de 64 MP', 399.00, 1),
(0921,'A1 Pro 5G', 'OPPO', 'Teléfono asequible con pantalla de 120 Hz y cámara de 108 MP', 299.00, 1),
(3498,'A57e', 'OPPO', 'Teléfono básico con diseño ligero, batería de 5000 mAh y carga rápida', 199.00, 1),
(2359,'Find X5 Pro', 'OPPO', 'Teléfono de alta gama con cámara Hasselblad y diseño elegante', 999.00, 1),
(8712,'Find N', 'OPPO', 'Teléfono plegable innovador con diseño compacto y funcional', 1299.00, 1),
(4096,'Reno10 Pro', 'OPPO', 'Teléfono con diseño elegante, cámara potente y rendimiento fluido', 499.00, 1);
-- OPPO

-- Cascos Apple
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA, ID_CATEGORIA) VALUES
(1357,'AirPods (2.ª generación)', 'Apple', 'Auriculares inalámbricos con sonido de alta calidad', 149.00, 2),
(9864,'AirPods (3.ª generación)', 'Apple', 'Auriculares inalámbricos con sonido espacial personalizado', 199.00, 2),
(5296,'AirPods Pro (2.ª generación)', 'Apple', 'Auriculares inalámbricos con cancelación de ruido y audio adaptativo', 299.00, 2),
(6890,'AirPods Max', 'Apple', 'Auriculares circumaurales con audio de alta fidelidad y cancelación de ruido', 629.00, 2),
-- Cascos Sony
(1023,'WH-1000XM5', 'Sony', 'Auriculares inalámbricos con cancelación de ruido', 349.00, 2),
(2345,'WH-1000XM4', 'Sony', 'Auriculares inalámbricos con cancelación de ruido', 279.00, 2),
(7214,'WH-CH720N', 'Sony', 'Auriculares inalámbricos con cancelación de ruido', 149.00, 2),
(8742,'WF-SP800N', 'Sony', 'Auriculares inalámbricos deportivos con cancelación de ruido', 179.00, 2),
(3068,'WF-SP900', 'Sony', 'Auriculares inalámbricos sumergibles para deportes acuáticos', 229.00, 2),
(7140,'WF-1000XM4', 'Sony', 'Auriculares inalámbricos True Wireless con cancelación de ruido', 249.00, 2),
(4952,'WF-C500', 'Sony', 'Auriculares inalámbricos True Wireless', 99.00, 2),
(9012,'INZONE H9', 'Sony', 'Auriculares inalámbricos para juegos con sonido espacial 360', 299.00, 2),
(4321,'INZONE H3', 'Sony', 'Auriculares con cable para juegos con sonido espacial 360', 99.00, 2);

-- Consolas PS5
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA,ID_CATEGORIA) VALUES
(6543,'PlayStation 5', 'Sony', 'Consola de sobremesa con gráficos 4K y mando DualSense', 499.00, 3),
(3210,'PlayStation 5 Digital Edition', 'Sony', 'Consola de sobremesa sin lector de discos', 399.00, 3),
(1928,'PlayStation 5 Pro', 'Sony', 'Consola de sobremesa con rendimiento mejorado y gráficos 8K', 799.99, 3),
(2817,'PlayStation 5 Slim', 'Sony', 'Consola de sobremesa más delgada y ligera', 449.99, 3),
(8351,'PlayStation 5 Edición Limitada Marvel\'s Spider-Man 2', 'Sony', 'Consola de sobremesa con diseño exclusivo', 549.00, 3),
(9416,'PlayStation 5 Edición Limitada God of War Ragnarök', 'Sony', 'Consola de sobremesa con diseño exclusivo', 549.00, 3),
(3746,'PlayStation 5 Edición Limitada Horizon Forbidden West', 'Sony', 'Consola de sobremesa con diseño exclusivo', 549.00, 3),
-- Consolas Xbox
(6158,'Xbox Series X', 'Microsoft', 'Consola de sobremesa con gráficos 4K y 120 FPS', 499.00, 3),
(0524,'Xbox Series S', 'Microsoft', 'Consola de sobremesa compacta y económica', 299.00, 3),
(8532,'Xbox One', 'Microsoft', 'Consola de sobremesa con gran variedad de juegos', 249.00, 3),
-- Consolas Nintendo
(1448,'Nintendo Switch', 'Nintendo', 'Consola híbrida con juegos exclusivos como Mario y Zelda', 299.00, 3),
(8526,'Nintendo Switch OLED', 'Nintendo', 'Consola híbrida con pantalla OLED y mejor calidad de imagen', 349.00, 3),
(4712,'Nintendo Switch Lite', 'Nintendo', 'Consola portátil ligera y compacta', 199.00, 3);

-- Juegos PS5
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA, ID_CATEGORIA) VALUES
(6087,'Marvel\'s Spider-Man 2', 'Insomniac Games', 'Juego exclusivo de PS5 con acción y aventura', 79.99, 4),
(7194,'God of War Ragnarök', 'Santa Monica Studio', 'Juego exclusivo de PS5 con acción y aventura épica', 79.99, 4),
(6194,'Horizon Forbidden West', 'Guerrilla Games', 'Juego exclusivo de PS5 con aventura y mundo abierto', 79.99, 4),
(9253,'Ratchet & Clank: Una Dimensión Aparte', 'Insomniac Games', 'Juego exclusivo de PS5 con acción y plataformas', 69.99, 4),
(1468,'Returnal', 'Housemarque', 'Juego exclusivo de PS5 con acción y ciencia ficción', 69.99, 4),
(3601,'Demon\'s Souls', 'Bluepoint Games', 'Remake del clásico juego de PS3 con acción y rol', 69.99, 4),
(8238,'Astro\'s Playroom', 'Team Asobi', 'Juego preinstalado en PS5 con plataformas y exploración', 0.00, 4),
(1593,'The Last of Us Parte I', 'Naughty Dog', 'Remake del aclamado juego de PS3 con acción y drama', 79.99, 4),
(8241,'Gran Turismo 7', 'Polyphony Digital', 'Juego de carreras exclusivo de PS5 con simulación', 79.99, 4),
-- Juegos Xbox
(16449,'Halo Infinite', '343 Industries', 'Juego exclusivo de Xbox con acción y ciencia ficción', 69.99, 4),
(8372,'Forza Horizon 5', 'Playground Games', 'Juego exclusivo de Xbox con carreras y mundo abierto', 69.99, 4),
(3105,'Gears 5', 'The Coalition', 'Juego exclusivo de Xbox con acción y disparos', 69.99, 4),
(7584,'Sea of Thieves', 'Rare', 'Juego multijugador de Xbox con piratas y aventuras', 39.99, 4),
(5026,'Fable', 'Playground Games', 'Juego exclusivo de Xbox con rol y aventura', 69.99, 4),
(2963,'Cyberpunk 2077', 'CD Projekt Red', 'Juego multiplataforma con rol y mundo abierto', 69.99, 4),
(9417,'Elden Ring', 'FromSoftware', 'Juego multiplataforma con acción y rol', 69.99, 4),
(4850,'Assassin\'s Creed Valhalla', 'Ubisoft', 'Juego multiplataforma con acción y aventura', 69.99, 4),
(6238,'Call of Duty: Modern Warfare II', 'Infinity Ward', 'Juego multiplataforma con acción y disparos', 69.99, 4),
(0791,'FIFA 23', 'EA Sports', 'Juego multiplataforma con simulación de fútbol', 69.99, 4),
-- Juegos Nintendo Switch
(1295,'The Legend of Zelda: Tears of the Kingdom', 'Nintendo', 'Juego exclusivo de Switch con aventura y exploración', 69.99, 4),
(8537,'Super Mario Bros. Wonder', 'Nintendo', 'Juego exclusivo de Switch con plataformas y novedades', 59.99, 4),
(3041,'Pokémon Escarlata', 'Nintendo', 'Juego exclusivo de Switch con rol y mundo abierto', 59.99, 4),
(7689,'Pokémon Púrpura', 'Nintendo', 'Juego exclusivo de Switch con rol y mundo abierto', 59.99, 4),
(5123,'Splatoon 3', 'Nintendo', 'Juego exclusivo de Switch con acción y disparos', 59.99, 4),
(9860,'Animal Crossing: New Horizons', 'Nintendo', 'Juego exclusivo de Switch con simulación y vida social', 59.99, 4),
(4702,'Mario Kart 8 Deluxe', 'Nintendo', 'Juego exclusivo de Switch con carreras y multijugador', 59.99, 4),
(6318,'Super Smash Bros. Ultimate', 'Nintendo', 'Juego exclusivo de Switch con lucha y multijugador', 69.99, 4);

-- Libros
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, AUTOR, DESCRIPCION, PRECIO_VENTA, ID_CATEGORIA) VALUES
(2459,'Cien años de soledad', 'Literatura', 'Gabriel García Márquez', 'Novela clásica latinoamericana', 19.99, 5),
(0974,'El Quijote', 'Literatura', 'Miguel de Cervantes', 'Obra cumbre de la literatura española', 24.99, 5),
(1307,'Sapiens: De animales a dioses', 'Ensayo', 'Yuval Noah Harari', 'Historia de la humanidad desde sus orígenes', 29.99, 5),
(9804,'El poder del ahora', 'Autoayuda', 'Eckhart Tolle', 'Libro sobre el presente y la conciencia', 14.99, 5);

-- Perfumes
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA, ID_CATEGORIA) VALUES
(2468,'Chanel N°5', 'Chanel', 'Perfume floral aldehído para mujer', 129.99, 6),
(7131,'Dior J\'adore', 'Dior', 'Perfume floral y luminoso para mujer', 119.99, 6),
(3090,'Acqua di Giò', 'Giorgio Armani', 'Perfume fresco y acuático para hombre', 99.99, 6),
(6925,'1 Million', 'Paco Rabanne', 'Perfume dulce y seductor para hombre', 89.99, 6);

-- Juguetes
INSERT INTO PRODUCTOS (ID_PRODUCTO,NOMBRE, MARCA, DESCRIPCION, PRECIO_VENTA, ID_CATEGORIA) VALUES
(4180,'LEGO City Police Station', 'LEGO', 'Set de construcción de la estación de policía', 99.99, 7),
(8852,'Barbie Dreamhouse', 'Mattel', 'Casa de muñecas de Barbie con accesorios', 149.99, 7),
(5290,'Hasbro Nerf Ultra One', 'Hasbro', 'Lanzador de dardos motorizado', 49.99, 7),
(0741,'Hot Wheels City Ultimate Garage', 'Mattel', 'Garaje gigante para coches Hot Wheels', 79.99, 7);


CREATE TABLE PRODUCTOS_PROVEDORES (
	ID_PRO INT NOT NULL auto_increment UNIQUE primary KEY,
	ID_PRODUCTO INT NOT NULL,
    ID_PROVEDOR INT NOT NULL,
    PRECIO_PROVEDOR DEC(9,2),
  FOREIGN KEY (ID_PROVEDOR) REFERENCES PROVEDORES(ID_PROVEDOR),
  FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO)
);
-- Insertar datos en la tabla PRODUCTOS_PROVEEDORES
INSERT INTO PRODUCTOS_PROVEDORES (ID_PRODUCTO, ID_PROVEDOR, PRECIO_PROVEDOR) VALUES

-- Proveedor "La Fuente, S.A." (ID_PROVEDOR = 1)
(2460, 1, 1050.00), -- iPhone 14 Pro
(3088, 1, 950.00), -- iPhone 14
(5791, 1, 500.00), -- iPhone SE (2022)
(0658, 1, 780.00), -- iPhone 13 mini
(2877, 1, 1150.00), -- iPhone 12 Pro Max
(6095, 1, 1300.00), -- iPhone 15 Pro
(9653, 1, 1400.00), -- iPhone 15 Pro Max
(3827, 1, 900.00), -- iPhone 15
(4962, 1, 1000.00), -- iPhone 15 Plus
(1357, 1, 140.00), -- AirPods (2.ª generación)
(6543, 1, 480.00), -- PlayStation 5
(6087, 1, 75.00), -- Marvel's Spider-Man 2
(2459, 1, 18.00), -- Cien años de soledad
(2468, 1, 120.00), -- Chanel N°5
(4180, 1, 90.00), -- LEGO City Police Station

-- Proveedor "El Corte Inglés, S.A." (ID_PROVEDOR = 2)
(1607, 2, 1350.00), -- Galaxy S24 Ultra
(9874, 2, 920.00), -- Galaxy S24
(5256, 2, 1800.00), -- Galaxy Z Fold5
(8052, 2, 1150.00), -- Galaxy Z Flip5
(7531, 2, 450.00), -- Galaxy A54
(3690, 2, 200.00), -- Galaxy M14
(2045, 2, 1150.00), -- Galaxy S23 Ultra
(3786, 2, 800.00), -- Galaxy S23
(4183, 2, 1600.00), -- Galaxy Z Fold4
(3220, 2, 950.00), -- Galaxy Z Flip4
(1023, 2, 330.00), -- WH-1000XM5
(1448, 2, 280.00), -- Nintendo Switch
(1295, 2, 65.00), -- The Legend of Zelda: Tears of the Kingdom
(0974, 2, 22.00), -- El Quijote
(7131, 2, 110.00), -- Dior J'adore
(8852, 2, 130.00), -- Barbie Dreamhouse

-- Proveedor "Almacén General, S.L." (ID_PROVEDOR = 3)
(6304, 3, 1000.00), -- Find X6 Pro
(2789, 3, 1400.00), -- Find N2
(1947, 3, 550.00), -- Reno11 Pro
(9152, 3, 380.00), -- A98 5G
(0921, 3, 280.00), -- A1 Pro 5G
(3498, 3, 180.00), -- A57e
(2359, 3, 950.00), -- Find X5 Pro
(8712, 3, 1200.00), -- Find N
(4096, 3, 450.00), -- Reno10 Pro
(9864, 3, 190.00), -- AirPods (3.ª generación)
(3210, 3, 380.00), -- PlayStation 5 Digital Edition
(8537, 3, 55.00), -- Super Mario Bros. Wonder
(1307, 3, 27.00), -- Sapiens: De animales a dioses
(3090, 3, 90.00), -- Acqua di Giò
(5290, 3, 45.00); -- Hasbro Nerf Ultra One





CREATE TABLE CLIENTES_PRODUCTOS(
ID_CLIPROD INT NOT NULL auto_increment UNIQUE primary KEY,
ID_CLIENTE INT NOT NULL,
ID_PRODUCTO INT NOT NULL,
OPINION VARCHAR(70) NOT NULL,
VALORACION int NOT NULL,
FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE),
FOREIGN KEY(ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO),
check(VALORACION between 1 and 5)
);

-- Tabla CLIENTE_PRODUCTOS
INSERT INTO CLIENTES_PRODUCTOS (ID_CLIENTE, ID_PRODUCTO, OPINION, VALORACION) VALUES
(1, 1295, 'Excelente teléfono, la cámara es increíble', 5),  
(1, 6238, 'Muy potente y versátil', 4), 
(2, 2468, 'Me encantan estos auriculares, la cancelación de ruido es top', 5), 
(2, 2817, 'Una consola muy potente, los juegos se ven espectaculares', 5), 
(3, 4180, 'Un juego muy divertido para jugar con amigos', 4),
(3, 0974, 'Un libro muy interesante, me ha hecho reflexionar mucho', 4);
