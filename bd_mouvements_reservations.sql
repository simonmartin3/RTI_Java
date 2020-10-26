create table reservations
(
    idReservation  varchar(20) not null
        primary key,
    idContainer    varchar(50) not null,
    idSociete      varchar(50) not null,
    idTransporteur varchar(20) not null,
    constraint reservations_ibfk_1
        foreign key (idSociete) references societes (idSociete)
            on update cascade on delete cascade,
    constraint reservations_ibfk_3
        foreign key (idTransporteur) references transporteurs (idTransporteur)
            on update cascade on delete cascade
)
    charset = utf8;

create index idSociete
    on reservations (idSociete);

INSERT INTO bd_mouvements.reservations (idReservation, idContainer, idSociete, idTransporteur) VALUES ('R-000001', 'C-000-AAA', 'Pede Consulting', '000-000-001');
INSERT INTO bd_mouvements.reservations (idReservation, idContainer, idSociete, idTransporteur) VALUES ('R-000002', 'C-000-AAB', 'Quis Ltd', '000-000-005');
INSERT INTO bd_mouvements.reservations (idReservation, idContainer, idSociete, idTransporteur) VALUES ('R-000003', 'C-000-AAC', 'Pede Consulting', '000-000-001');
INSERT INTO bd_mouvements.reservations (idReservation, idContainer, idSociete, idTransporteur) VALUES ('R-000004', 'C-000-AAD', 'Ipsum Consulting', '000-000-004');
INSERT INTO bd_mouvements.reservations (idReservation, idContainer, idSociete, idTransporteur) VALUES ('R-000005', 'C-000-AAE', 'Urna Nec PC', '000-000-003');