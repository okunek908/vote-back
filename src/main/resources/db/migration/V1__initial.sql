create table POLL
(
    ID          int identity not null primary key,
    TITLE       varchar(100) not null,
    DESCRIPTION varchar(1000),
    TIME_START  timestamp    not null,
    TIME_END    timestamp    not null,
    CREATED     timestamp    not null,
    UPDATED     timestamp,
    QUESTIONS   varchar
);

insert into POLL
values (75, 'Title111', 'Descr111', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '[{"question":"Do you like me?", "options":["yes", "no", "stupid question"]}]');
