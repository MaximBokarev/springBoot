create table actor_roles
(
    actor_id bigserial
        constraint actor_roles_actor_id_fk
            references actor,
    role_id bigserial
        constraint actor_roles_roles_id_fk
            references roles
);