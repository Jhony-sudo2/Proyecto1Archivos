--REPORTE 1

SELECT p.Sucursal, p.Nombre AS NombreProducto, d.Producto, SUM(d.Cantidad) AS TotalProductosVendidos
FROM ventas.Descripcion AS d
JOIN manejoproducto.Producto AS p ON d.Producto = p.Id
GROUP BY p.Sucursal, p.Nombre, d.Producto
ORDER BY TotalProductosVendidos DESC;
