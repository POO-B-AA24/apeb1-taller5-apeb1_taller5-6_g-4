package ProblemaJava;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Problema04_CasoCorrupcion {
    private String nombre;
    private LocalDate fechaInicio;
    private String estado;
    private String detalles;
    private List<Problema04_Persona> personasImplicadas;

    public Problema04_CasoCorrupcion(String nombre, LocalDate fechaInicio, String detalles) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.detalles = detalles;
        this.personasImplicadas = new ArrayList<>();
        this.estado = determinarEstado();
    }

    public void agregarPersona(Problema04_Persona persona) {
        personasImplicadas.add(persona);
    }

    public List<Problema04_Persona> getPersonasImplicadas() {
        return personasImplicadas;
    }

    private String determinarEstado() {
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());
        if (diasTranscurridos > 14) {
            return "Urgente";
        } else if (diasTranscurridos > 7) {
            return "Alerta";
        } else {
            return "Iniciado";
        }
    }

    public void actualizarEstado() {
        this.estado = determinarEstado();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del Caso: ").append(nombre)
          .append("\nFecha de Inicio: ").append(fechaInicio)
          .append("\nEstado: ").append(estado)
          .append("\nDetalles: ").append(detalles)
          .append("\nPersonas Implicadas:\n");

        for (Problema04_Persona persona : personasImplicadas) {
            sb.append(persona.toString()).append("\n");
        }

        return sb.toString();
    }
}
