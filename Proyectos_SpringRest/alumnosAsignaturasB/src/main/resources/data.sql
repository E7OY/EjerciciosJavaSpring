INSERT INTO alumnos (nombre, edad, dni) VALUES
                ("alumno1", 29, "1234578O"),
                ("alumno2", 18, "9876542P"),
                ("alumno3", 17, "8765432S"),
                ("alumno4", 26, "2345678L"),
                ("alumno5", 31, "7654321Q"),
                ("alumno6", 21, "3456789W"),
                ("alumno7", 19, "1234567C");

INSERT INTO asignaturas (nombre, horas) VALUES 
                        ("DWES", 28),
                        ("DWEC", 32),
                        ("DIW", 16),
                        ("DAW", 30);

INSERT INTO matriculas (id_alumno, id_asignatura, nota, curso) VALUES    
    (1, 2, 2.50, 2023),
    (1, 3, 8.50, 2023),
    (2, 1, 5.50, 2024),
    (2, 4, 6.50, 2024),
    (3, 1, 9.50, 2023),
    (3, 2, 10.00, 2023);