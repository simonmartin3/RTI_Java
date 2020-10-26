create table transporteurs
(
    idTransporteur  varchar(20) not null
        primary key,
    idSociete       varchar(50) not null,
    capacite        int         not null,
    caracteristique varchar(50) not null,
    constraint transporteurs_ibfk_1
        foreign key (idSociete) references societes (idSociete)
            on update cascade on delete cascade
)
    charset = utf8;

create index idSociete
    on transporteurs (idSociete);

INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-000-001', 'Pede Consulting', 1, 'Camion');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-000-002', 'Cum Sociis LLC', 1, 'Camion');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-000-003', 'Urna Nec PC', 1, 'Camion');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-000-004', 'Ipsum Consulting', 1, 'Camion');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-000-005', 'Quis Ltd', 1, 'Camion');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-001-000', 'Bibendum Sed Est Corp.', 5, 'Bateau');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-002-000', 'Elit Nulla Corporation', 8, 'Bateau');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-003-000', 'Urna Nec PC', 4, 'Bateau');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-004-000', 'Porta LLP', 6, 'Bateau');
INSERT INTO bd_mouvements.transporteurs (idTransporteur, idSociete, capacite, caracteristique) VALUES ('000-005-000', 'Quis Ltd', 10, 'Bateau');