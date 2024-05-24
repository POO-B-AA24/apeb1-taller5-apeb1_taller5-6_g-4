
package ProblemaJava;

import java.time.LocalDate;


public class Problema05_Evento {
private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private String descripcion;
    private boolean usoArmasNucleares;
    private int bajas;

    public Problema05_Evento(String nombre, LocalDate fecha, String ubicacion, String descripcion, boolean usoArmasNucleares, int bajas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.usoArmasNucleares = usoArmasNucleares;
        this.bajas = bajas;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isUsoArmasNucleares() {
        return usoArmasNucleares;
    }

    public int getBajas() {
        return bajas;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Ubicación: " + ubicacion +
                ", Descripción: " + descripcion + ", Uso de Armas Nucleares: " + usoArmasNucleares +
                ", Bajas: " + bajas;
    }
}