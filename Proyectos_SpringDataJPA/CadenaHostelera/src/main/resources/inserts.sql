INSERT INTO clientes (nombre, apellido1, apellido2, fecha_nacimiento, telefono, categoria) VALUES 
            ('ELOY', 'GARCIA', 'MARTINEZ', '2013-01-12', 123456789, "VIP"),
            ('JUAN', 'GARCIA', 'MARTINEZ', '2013-01-12', 123456789, "REGULAR"),
            ('PEDRO', 'GARCIA', 'MARTINEZ', '2013-01-12', 123456789, "INVITADO"),
            ('JUAN', 'GARCIA', 'MARTINEZ', '2013-01-12', 123456789, "CASUAL"),
            ('PEDRO', 'GARCIA', 'MARTINEZ', '2003-01-12', 123456789, "VIP");

INSERT INTO locales (nombre, aforo_maximo, metros_cuadrados) VALUES
            ('LOCAL A', 63, 344.3),
            ('LOCAL B', 599, 744),
            ('LOCAL C', 499, 144.50),
            ('LOCAL D', 299, 244.3),
            ('LOCAL E', 99, 144.3);

INSERT INTO empleados (nombre, apellido1, apellido2, fecha_nacimiento, telefono, cargo, local) VALUES
                    ('EDUARDOR', 'CAMAVINGA', 'GOMEZ', '2012-12-02', 123456789, 'CAMARERO', 1),
                    ('CRISTIANO', 'RONALDO', 'SIU', '2004-12-02', 123456789, 'SECURATA', 2),
                    ('LIONEL', 'MESSI', 'SIU', '2004-12-02', 123456789, 'LIMPIADOR', 3),
                    ('SERGIO', 'RAMOS', 'SIU', '2004-12-02', 123456789, 'COCINERO', 4),
                    ('LUIS', 'SUAREZ', 'SIU', '2004-12-02', 123456789, 'CAMARERO', 5);

INSERT INTO clientes_locales (Local_id, Cliente_id) VALUES
                            (1, 1),
                            (2, 1),
                            (3, 2),
                            (4, 3),
                            (5, 4);