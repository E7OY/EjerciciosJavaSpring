-- Insertar datos en la tabla alumnos
INSERT INTO alumnos (nombre, apellidos, edad) VALUES
('Juan', 'Pérez', 20),
('María', 'González', 22),
('Carlos', 'Sánchez', 19),
('Lucía', 'Ramírez', 21),
('Nini', 'Empanado', 23);

-- Insertar datos en la tabla asignaturas
INSERT INTO asignaturas (nombre) VALUES
('Matemáticas'),
('Historia'),
('Física'),
('Química'),
('Biología');

-- Insertar datos en la tabla matriculas
INSERT INTO matriculas (idalumno, idasignatura, curso, nota) VALUES
(1, 1, '2022-09-16', 2.50),
(1, 2, '2023-01-10', 7.00),
(1, 1, '2023-01-10', 8.50),
(2, 3, '2023-09-20', 8.75),
(2, 4, '2024-02-15', 9.50),
(4, 1, '2025-03-10', 8.00),
(4, 2, '2025-06-25', 8.00),
(5, 3, '2023-11-01', 9.00),
(5, 4, '2024-08-30', 8.00),
(5, 5, '2024-12-15', 9.00);