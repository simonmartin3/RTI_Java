create table destination
(
    ville          varchar(30) not null
        primary key,
    distanceBateau float       not null,
    distanceTrain  float       not null,
    distanceRoute  float       not null
)
    charset = utf8;

