
package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.demo.model.Producto;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    List<Producto> findByNombre(@Param("nombre") String nombreDelProducto);

    /**
	 * @deprecated Use {@link #findByNombreNativeQuery(String,long, long)} instead
	 */
	@Query(value = "SELECT * FROM productos WHERE nombre = ?1", nativeQuery = true)
	List<Producto> findByNombreNativeQuery(@Param("nombre") String nombre);

	@Query(value = "SELECT * FROM productos WHERE nombre = :nombre", nativeQuery = true)
    List<Producto> findByNombreNativeQuery(@Param("nombre") String nombre, long numeroEan, long id);
}
