
package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.demo.model.Producto;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.nombreDelProducto = :nombreDelProducto")
    List<Producto> findByNombreDelProducto(@Param("nombreDelProducto") String nombreDelProducto);

    /**
	 * @deprecated Use {@link #findByNombreDelProductoNativeQuery(String,long, long)} instead
	 */
	@Query(value = "SELECT * FROM productos WHERE nombreDelProducto = ?1", nativeQuery = true)
	List<Producto> findByNombreDelProductoNativeQuery(@Param("nombreDelProducto") String nombreDelProducto);

	@Query(value = "SELECT * FROM productos WHERE nombre = :nombreDelProducto", nativeQuery = true)
    List<Producto> findByNombreDelProductoNativeQuery(@Param("nombreDelProducto") String nombreDelProducto, long numeroEan, long id);
}
