create table public.weather
(
    id   serial not null
        constraint status_pk
            primary key,
    city varchar,
    region varchar,
    temp varchar,
    humidity varchar,
    wind varchar
);