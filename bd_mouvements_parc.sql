create table parc
(
    coordonnees     varchar(10) not null
        primary key,
    idContainer     varchar(20) not null,
    etat            int         not null,
    dateReservation varchar(20) null,
    dateArrivee     varchar(20) not null,
    poids           int         not null,
    destination     varchar(30) not null,
    typeRetour      varchar(20) not null,
    constraint parc_ibfk_1
        foreign key (idContainer) references containers (idContainer)
            on update cascade on delete cascade,
    constraint parc_ibfk_2
        foreign key (destination) references destination (ville)
            on update cascade on delete cascade
)
    charset = utf8;

create index destination
    on parc (destination);

create index idContainer
    on parc (idContainer);

