package backend.app.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author b44rto
 */
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Size(min = 1, max = 45, message = "Nro Caracteres maximo: 45")
    @NotEmpty(message = "*Campo Obligatorio")
    @Column(name = "apellido", length = 45, nullable = false)
    private String apellido;

    @Size(min = 1, max = 45, message = "Nro Caracteres maximo: 45")
    @NotEmpty(message = "*Campo Obligatorio")
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 15, nullable = false)
    @Size(min = 1, max = 15, message = "Nro Caracteres maximo: 15")
    @NotEmpty(message = "*Campo Obligatorio")
    private String telefono;

    @Column(name = "direccion", length = 45, nullable = false)
    @Size(min = 1, max = 45, message = "Nro Caracteres maximo: 45")
    @NotEmpty(message = "*Campo Obligatorio")
    private String direccion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;

    @Column(name = "observacion", nullable = false)
    private String observacion;

    @Column(name = "dias_trabajo", nullable = false)
    private Integer dias_trabajo;

    @Column(name = "sueldo", nullable = false)
    private Float sueldo;

    //  getters
    public Integer getId_empleado() {
        return id_empleado;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public Integer getDias_trabajo() {
        return dias_trabajo;
    }

    public Float getSueldo() {
        return sueldo;
    }

    //  setters
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setDias_trabajo(Integer dias_trabajo) {
        this.dias_trabajo = dias_trabajo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

}
