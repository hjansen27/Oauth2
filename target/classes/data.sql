insert into users (username, password, enabled) values ('bob', '$2a$10$/ns.CwZ9sdhQaVjw/bwBQeelnmTZTI19trLtyY/bjbIVUokAckX8y', true);
insert into authorities (username, authority) values ('bob', 'ROLE_USER');

insert into users (username, password, enabled) values ('sara', '$2a$10$WPDbKLCRnV0UrkEs2IEtUejsZiicxt0/GhUcOkg2.UscjBi8tOmxa', true);
insert into authorities (username, authority) values ('sara', 'ROLE_ADMIN');