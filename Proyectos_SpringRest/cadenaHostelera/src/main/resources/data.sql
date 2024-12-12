INSERT INTO `locales` (`aforo_maximo`, `metros_cuadrados`, `nombre`) VALUES
(50, 12.50, 'Bar El Encuentro'),
(100, 25.75, 'Discoteca Nocturna'),
(80, 18.00, 'Restaurante Gourmet'),
(30, 70.25, 'Café Moderno');

-- Insertando datos en la tabla `clientes`
INSERT INTO `clientes` (`fecha_nacimiento`, `telefono`, `apellido1`, `apellido2`, `nombre`, `categoria`) VALUES
('1990-05-15', 123456789, 'Gómez', 'Pérez', 'Juan', 'VIP'),
('1985-10-20', 987654321, 'López', NULL, 'María', 'REGULAR'),
('2000-08-30', 654321987, 'Martínez', 'Díaz', 'Carlos', 'CASUAL'),
('1995-12-25', 789456123, 'Fernández', 'García', 'Ana', 'INVITADO');

-- Insertando datos en la tabla `clientes_locales`
INSERT INTO `clientes_locales` (`cliente_id`, `local_id`) VALUES
(1, 1), -- Juan Gómez visita el Bar El Encuentro
(2, 2), -- María López visita la Discoteca Nocturna
(3, 3), -- Carlos Martínez visita el Restaurante Gourmet
(4, 4); -- Ana Fernández visita el Café Moderno

-- Insertando datos en la tabla `miembros`
INSERT INTO `miembros` (`fecha_nacimiento`, `telefono`, `apellido1`, `apellido2`, `cargo`, `local`) VALUES
('1980-03-01', 321654987, 'Pérez', 'Sánchez', 'CAMARERO', 1), -- Camarero en el Bar El Encuentro
('1992-07-14', 147852369, 'González', NULL, 'COCINERO', 3), -- Cocinero en el Restaurante Gourmet
('1988-11-22', 963852741, 'Ramírez', 'Hernández', 'SECURATA', 2), -- Seguridad en la Discoteca Nocturna
('1990-06-30', 852963741, 'Domínguez', NULL, 'LIMPIADOR', 4); -- Limpiador en el Café Moderno