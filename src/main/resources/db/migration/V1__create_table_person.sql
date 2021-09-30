CREATE TABLE person (
    id          char(36) NOT NULL,
    name        char(255) NOT NULL,
    cpf         char(255) NOT NULL,
    city        char(255),
    StreetName  char(255),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

