#1

select * from producto p
inner join rubro r
on p.id_rubro = r.id_rubro
where r.rubro like '%libreria%';

#2

select c.nombre as nombre, sum(v.precio_unitario) as monto from venta v 
inner join cliente c
on v.id_cliente = c.id_cliente
group by nombre;


#3

select p.nombre as productos,sum(v.cantidad) as cantidad from venta v
inner join producto p 
on v.codigo_producto = p.codigo
group by productos;

#4

select c.nombre as nombre ,sum(v.cantidad) as cantidad from venta v
inner join producto p
on v.codigo_producto = p.codigo
inner join cliente c
on v.id_cliente = c.id_cliente
where v.fecha = curdate()
group by nombre;

#5

select * from venta v 
inner join producto p
on v.codigo_producto = p.codigo
inner join rubro r
on p.id_rubro = r.id_rubro
where r.rubro like '%bazar%' and v.cantidad >= 1;

#6

select r.rubro from rubro r 
inner join producto p
on r.id_rubro = p.id_rubro
inner join venta v 
on v.codigo_producto = p.id_rubro
where v.fecha < DATE_SUB(NOW(),INTERVAL 2 MONTH);

