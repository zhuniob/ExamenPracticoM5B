package backend.app.examen.controller;

import backend.app.examen.model.Empleado;
import backend.app.examen.service.IEmpleadoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author b44rto
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    IEmpleadoService empleadoService;

    @GetMapping("/listar")
    public ResponseEntity< List<Empleado>> listarEmpleados() {
        return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id_empleado}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Integer id_empleado) {
        empleadoService.delete(id_empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id_empleado}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id_empleado, @RequestBody Empleado e) {
        Empleado empleado = empleadoService.findById(id_empleado);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                empleado.setNombre(e.getNombre());
                empleado.setApellido(e.getApellido());
                empleado.setTelefono(e.getTelefono());
                empleado.setDireccion(e.getDireccion());
                empleado.setFecha_nacimiento(e.getFecha_nacimiento());
                empleado.setObservacion(e.getObservacion());
                empleado.setDias_trabajo(e.getDias_trabajo());
                empleado.setSueldo(e.getSueldo());
                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
