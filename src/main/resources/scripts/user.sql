/*Admin*/
INSERT INTO main.user (user_id,name,password,administrator,profile_image,code_verification,code_verification_created_at,mfa_is_email) VALUES ('11111111-1111-1111-1111-111111111111','admin','$2y$10$VQDgZPmoeLc1w13mdje.wOc1rlJyqjEeqDqgqKMQ1GKgdeonFi0cq',TRUE,'https://example.com/images/admin-profile.png',NULL,NULL,TRUE);
INSERT INTO main.person (user_id,first_name,last_name,document_number,address,phone,email) VALUES ('11111111-1111-1111-1111-111111111111','Juan','Administrador','100000001','Calle 1 #23-45','3001112233','admin@empresa.com');

/*User*/
INSERT INTO main.user (user_id,name,password,administrator,profile_image,code_verification,code_verification_created_at,mfa_is_email) VALUES ('22222222-2222-2222-2222-222222222222','sebast','$2y$10$VQDgZPmoeLc1w13mdje.wOc1rlJyqjEeqDqgqKMQ1GKgdeonFi0cq',FALSE,'https://example.com/images/user-profile.png',NULL,NULL,FALSE);
INSERT INTO main.person (user_id,first_name,last_name,document_number,address,phone,email) VALUES ('22222222-2222-2222-2222-222222222222','Carlos','Pérez','100000002','Carrera 10 #45-67','3012223344','carlos.perez@empresa.com');
