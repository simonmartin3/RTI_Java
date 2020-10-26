create table mouvements
(
    idMouvement       int auto_increment
        primary key,
    idContainer       varchar(20) not null,
    idTransporteurIn  varchar(20) not null,
    dateArrivee       varchar(20) not null,
    idTransporteurOut varchar(20) not null,
    poids             int         not null,
    dateDepart        varchar(20) not null,
    destination       varchar(30) not null,
    constraint mouvements_ibfk_1
        foreign key (destination) references destination (ville)
            on update cascade on delete cascade,
    constraint mouvements_ibfk_2
        foreign key (idContainer) references containers (idContainer)
            on update cascade on delete cascade,
    constraint mouvements_ibfk_3
        foreign key (idTransporteurIn) references transporteurs (idTransporteur)
            on update cascade on delete cascade,
    constraint mouvements_ibfk_4
        foreign key (idTransporteurOut) references transporteurs (idTransporteur)
            on update cascade on delete cascade
)
    charset = utf8;

create index destination
    on mouvements (destination);

create index idContainer
    on mouvements (idContainer);

create index idTransporteurIn
    on mouvements (idTransporteurIn);

create index idTransporteurOut
    on mouvements (idTransporteurOut);

