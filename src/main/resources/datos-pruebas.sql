/************** DATOS PARA EJERCICIOS ONE-TO-ONE ***************/

INSERT INTO datos_usuarios(id,biografia,fecha_registro) VALUES(DEFAULT,'Usuario ficticio 1 creado para el curso de Spring', '2013-10-20');
INSERT INTO usuarios(id, datos_autor_id, nombre, email, password) VALUES(DEFAULT,1,'juan', 'juan@email.com','1234');

INSERT INTO datos_usuarios(id,biografia,fecha_registro) VALUES(DEFAULT,'Usuario ficticio 2 creado para el curso de Spring', '2013-10-20');
INSERT INTO usuarios(id, datos_autor_id, nombre, email, password) VALUES(DEFAULT,2,'pepe', 'pepe@email.com','1234');

/************** DATOS PARA EJERCICIO ONE-TO-MANY ***************/

INSERT INTO posts VALUES(DEFAULT,1,'titulo post 1','contenido post 1','2013-10-24');
INSERT INTO posts VALUES(DEFAULT,1,'titulo post 2','contenido post 2','2013-10-24');
INSERT INTO comentarios VALUES(DEFAULT, 1, 'mi comentario 1','anonimo','2013-9-24');
INSERT INTO comentarios VALUES(DEFAULT, 1, 'mi comentario 2','anonimo','2013-11-24');

/************** DATOS PARA EJERCICIO MANY-TO-MANY ***************/

INSERT INTO categorias VALUES(DEFAULT, 'java');
INSERT INTO categorias VALUES(DEFAULT, 'linux');
INSERT INTO categorias VALUES(DEFAULT, 'spring');

INSERT INTO categorias_posts VALUES(1,1);
INSERT INTO categorias_posts VALUES(2,1);
INSERT INTO categorias_posts VALUES(3,1);

INSERT INTO categorias_posts VALUES(1,2);
INSERT INTO categorias_posts VALUES(2,2);