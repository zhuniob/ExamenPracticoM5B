package backend.app.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import backend.app.examen.model.Empleado;
import backend.app.examen.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author b44rto
 */
@Service
public class EmpleadoServiceImplement extends GenericServiceImplement<Empleado, Integer> implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository clienteRepository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return clienteRepository;
    }

    public Empleado buscarEmpleadoApellido(String apellido) {
        return clienteRepository.buscarEmpleadoApellido(apellido);

    }
}
