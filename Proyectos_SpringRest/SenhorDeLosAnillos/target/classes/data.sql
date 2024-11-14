INSERT INTO personajes (nombre, raza, alianza) VALUES
            ("aragorn", "HUMANO", "LA_COMUNIDAD"),
            ("gandal", "MAYAS", "LA_COMUNIDAD"),
            ("frodo", "HOBBIT", "LA_COMUNIDAD"),
            ("sauron", "MAYAS", "MORDOR"),
            ("bilbo", "HOBBIT", "AVENTURERO");

INSERT INTO artefactos(nombre, tipo) VALUES
            ("ARTEFACTO 1", "ANILLO"),
            ("ARTEFACTO 2", "BACULO"),
            ("ARTEFACTO 3", "ESPADA");

INSERT INTO posesiones (idPersonaje, idArtefacto, fechaInicio, fechaFin) VALUES
            (1, 1, "2024-08-12", "2024-10-20"),
            (2, 2, "2022-01-10", "2023-12-24"),
            (3, 3, "2019-04-17", "2020-10-09");