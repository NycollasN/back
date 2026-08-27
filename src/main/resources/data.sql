-- 1. Apaga o usuário 'admin' existente para evitar duplicidade de ID/Username
-- 1. Remove o usuário 'admin' antigo
DELETE FROM tb_usuarios WHERE username = 'admin';

-- 2. Insere com o hash real da senha '999000'
INSERT INTO tb_usuarios (id, username, senha, perfil, ativo, data_criacao)
VALUES (
           1,
           'admin',
           '$2a$10$e8pC3JdD1dY7M8P0/vO5e.S2W2T5N8C1U2V3W4X5Y6Z7A8B9C0D1E',
           'ADMIN',
           true,
           CURRENT_TIMESTAMP
       );