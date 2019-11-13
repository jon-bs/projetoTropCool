INSERT INTO public.usuario(
	id, created, nome, cpf,login, ativo, email, perfil, senha, account_activate_token, account_activate_token_expiration, password_reset_token, password_reset_token_expiration
)
VALUES 
(1001, NOW(), 'Gabriel','11111111111', 'gabriel_adm', TRUE, 'gabriel@mailinator.com', 0, '$2a$10$bAdAVLvM.k3DqPaPYi0gnO1OffPSHLref8MElAk.u.fFQ17v9YKC2', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02'),
(1002, NOW(), 'GabrielUlisses','11111111122', 'adm_gabriel', TRUE, 'ulisses@mailinator.com', 0, '$2a$10$bAdAVLvM.k3DqPaPYi0gnO1OffPSHLref8MElAk.u.fFQ17v9YKC2', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02'),
(1003, NOW(), 'UlissesGabriel','11111111144', 'addmgabriel', TRUE, 'ulisses@mailinator.com', 0, '$2a$10$bAdAVLvM.k3DqPaPYi0gnO1OffPSHLref8MElAk.u.fFQ17v9YKC2', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02'),
(1004, NOW(), 'GabUlli','11111111133', 'adm_gabrielUli', TRUE, 'ulisses@mailinator.com', 0, '$2a$10$bAdAVLvM.k3DqPaPYi0gnO1OffPSHLref8MElAk.u.fFQ17v9YKC2', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02', 'f786c907-032e-451b-ac93-8508dec75a3d', '2019-12-02');

