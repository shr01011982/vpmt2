-- Insert Permissions First
INSERT INTO permissions (id, name) VALUES (1, 'REPORT');
INSERT INTO permissions (id, name) VALUES (2, 'DASHBOARD');

-- Insert Roles Next
INSERT INTO roles (id, name) VALUES (1, 'a');
INSERT INTO roles (id, name) VALUES (2, 'b');
INSERT INTO roles (id, name) VALUES (3, 'c');
INSERT INTO roles (id, name) VALUES (4, 'd');

-- Then Map Role-Permissions (after both roles and permissions exist)
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 1); -- a -> REPORT
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 2); -- b -> DASHBOARD
INSERT INTO role_permissions (role_id, permission_id) VALUES (3, 1); -- c -> REPORT
INSERT INTO role_permissions (role_id, permission_id) VALUES (3, 2); -- c -> DASHBOARD
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 1); -- d -> REPORT
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 2); -- d -> DASHBOARD
