package backend.app.examen.repository;

import backend.app.examen.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author b44rto
 */
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "Select * from empleados e where e.apellido = :apellido", nativeQuery = true)
    public Empleado buscarEmpleadoApellido(String apellido);
}
