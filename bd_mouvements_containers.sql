create table containers
(
    idContainer varchar(20) not null
        primary key,
    idSociete   varchar(50) not null,
    contenu     varchar(40) not null,
    capacite    int         not null,
    dangers     varchar(40) not null,
    constraint containers_ibfk_1
        foreign key (idSociete) references societes (idSociete)
            on update cascade on delete cascade
)
    charset = utf8;

create index idSociete
    on containers (idSociete);

INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('2555', 'Cum Sociis LLC', 'scelerisque dui.', 4, 'condimentum.');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('3111', 'Cum Sociis LLC', 'luctus et', 10, 'ultrices a,');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('3491', 'Cum Sociis LLC', 'enim mi', 5, 'arcu et');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('3583', 'Cum Sociis LLC', 'Suspendisse', 10, 'non,');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('3665', 'Cum Sociis LLC', 'consequat dolor', 3, 'pellentesque. Sed dictum.');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('4344', 'Cum Sociis LLC', 'auctor', 4, 'Duis at');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('5300', 'Cum Sociis LLC', 'tellus.', 5, 'parturient montes, nascetur');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('6227', 'Cum Sociis LLC', 'orci quis', 4, 'fringilla');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('8126', 'Cum Sociis LLC', 'lectus sit amet', 6, 'id, libero.');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('8376', 'Cum Sociis LLC', 'adipiscing lobortis risus.', 2, 'nec,');
INSERT INTO bd_mouvements.containers (idContainer, idSociete, contenu, capacite, dangers) VALUES ('9955', 'Cum Sociis LLC', 'mauris', 6, 'iaculis odio.');