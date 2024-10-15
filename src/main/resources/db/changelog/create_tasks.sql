create table tasks
(
    id          serial constraint tasks_id primary key,
    description varchar(100) not null,
    status      integer      not null
);