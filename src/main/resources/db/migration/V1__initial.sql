

create table POLL
(
    ID           int          not null primary key,
    TITLE        varchar(100) not null,
    DESCRIPTION  varchar(1000),
    TIME_START   timestamp    not null,
    TIME_END     timestamp    not null,
    CREATED timestamp    not null,
    UPDATED timestamp
);