/*1 Todos los productos del rubro "librería", creados hoy*/

SELECT * FROM producto
WHERE id_rubro = (
    SELECT id_rubro
    FROM rubro WHERE rubro = "libreria") AND fecha_creacion = current_date();


/*2 Monto total vendido por cliente (mostrar nombre del cliente y monto)*/

SELECT nombre, SUM(precio*cantidad) AS monto FROM venta
GROUP BY nombre;

/*3 Cantidad de ventas por producto*/

SELECT count(*) AS cantidad ,
       (SELECT nombre FROM producto WHERE codigo = codigo_producto) AS nombreProducto
FROM venta
GROUP BY codigo_producto ;

/* 4 Cantidad de productos comprados por cliente en el mes actual*/

SELECT count(*) as cantidadVendida , nombre AS fecha
FROM venta
WHERE month(fecha)= month(current_date())
GROUP BY id_cliente;

/* 5  Ventas que tienen al menos un producto del rubro "bazar"*/

SELECT v.*
FROM venta AS v
         INNER JOIN producto AS p ON p.codigo = v.codigo_producto
         INNER JOIN rubro AS r ON r.id_rubro = p.id_rubro
WHERE r.rubro = 'bazar' AND v.cantidad >= 1 ;

/* 6 Rubros que no tienen ventas en los últimos 2 meses */

SELECT r.rubro
FROM rubro AS r
         INNER JOIN producto AS p ON p.id_rubro = r.id_rubro
         INNER JOIN venta AS v ON v.codigo_producto = p.codigo
WHERE MONTH(fecha) < (MONTH(current_date()) - 2)
GROUP BY r.rubro;