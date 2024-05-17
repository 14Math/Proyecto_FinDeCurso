package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;
import principales.GestionClientes;

public interface ProyectoConEmpleadoDao extends GestionClientes<Integer, ProyectoConEmpleado>{
    List<ProyectoConEmpleadoDao> empleadosByProyecto(String codigoProyecto);
    int asignarEmpleadosAProyecto(List<ProyectoConEmpleadoDao> empleados);
    int horasAsignadasAProyecto(String codigoProyecto);
    double costeActualDeProyecto(String codigoProyecto);
    double margenActualProyecto(String codigoProyecto);
}
