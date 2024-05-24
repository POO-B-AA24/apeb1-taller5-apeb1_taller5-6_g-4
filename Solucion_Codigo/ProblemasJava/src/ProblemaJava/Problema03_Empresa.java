
package ProblemaJava;

import java.util.ArrayList;
import java.util.List;

public class Problema03_Empresa {
private String nombre;
    private String ruc;
    private String direccion;
    private List<Problema03_Departamento> departamentos;

    public Problema03_Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Problema03_Departamento departamento) {
        departamentos.add(departamento);
    }

    public List<Problema03_Departamento> getDepartamentos() {
        return departamentos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa: ").append(nombre)
          .append("\nRUC: ").append(ruc)
          .append("\nDirección: ").append(direccion)
          .append("\nDepartamentos:\n");

        for (Problema03_Departamento dept : departamentos) {
            sb.append(dept.toString()).append("\n");
        }

        return sb.toString();
    }
}