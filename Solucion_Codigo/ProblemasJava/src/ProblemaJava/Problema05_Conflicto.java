
package ProblemaJava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Problema05_Conflicto {
    private String nombre;
    private List<String> paisesInvolucrados;
    private LocalDate fechaInicio;
    private String estadoActual;
    private String detalles;
    private List<Problema05_Evento> eventos;

    public Problema05_Conflicto(String nombre, List<String> paisesInvolucrados, LocalDate fechaInicio, String detalles) {
        this.nombre = nombre;
        this.paisesInvolucrados = paisesInvolucrados;
        this.fechaInicio = fechaInicio;
        this.detalles = detalles;
        this.eventos = new ArrayList<>();
        this.estadoActual = "En curso";
    }

    public void agregarEvento(Problema05_Evento evento) {
        eventos.add(evento);
        actualizarEstado();
    }

    public List<Problema05_Evento> getEventos() {
        return eventos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getPaisesInvolucrados() {
        return paisesInvolucrados;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public String getDetalles() {
        return detalles;
    }

    private void actualizarEstado() {
        long totalPaises = 195; // Aproximado número de países en el mundo
        long paisesConBatallas = eventos.stream()
                                        .filter(e -> e.getDescripcion().toLowerCase().contains("batalla"))
                                        .map(Problema05_Evento::getUbicacion)
                                        .distinct()
                                        .count();

        boolean guerraMundial = eventos.stream().anyMatch(Problema05_Evento::isUsoArmasNucleares);

        if (paisesConBatallas > totalPaises * 0.5 || guerraMundial) {
            estadoActual = "Guerra Mundial";
        } else if (paisesConBatallas >= totalPaises * 0.3) {
            estadoActual = "Reunión Urgente ONU";
        }

        for (String pais : paisesInvolucrados) {
            long bajasTotales = eventos.stream()
                                       .filter(e -> e.getUbicacion().equalsIgnoreCase(pais))
                                       .mapToInt(Problema05_Evento::getBajas)
                                       .sum();
            if (bajasTotales >= (totalPaises * 0.5)) {
                estadoActual = "Reunión Urgente ONU";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conflicto: ").append(nombre)
          .append("\nPaises Involucrados: ").append(String.join(", ", paisesInvolucrados))
          .append("\nFecha de Inicio: ").append(fechaInicio)
          .append("\nEstado Actual: ").append(estadoActual)
          .append("\nDetalles: ").append(detalles)
          .append("\nEventos:\n");

        for (Problema05_Evento evento : eventos) {
            sb.append(evento.toString()).append("\n");
        }

        return sb.toString();
    }
}

