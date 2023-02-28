create table public.customer
(
    id        varchar(36)  not null,
    tenant_id varchar(255) not null,
    email     varchar(255),
    name      varchar(255),
    primary key (id, tenant_id)
);
