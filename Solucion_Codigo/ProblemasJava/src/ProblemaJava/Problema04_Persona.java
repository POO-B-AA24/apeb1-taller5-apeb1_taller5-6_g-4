package ProblemaJava;

public class Problema04_Persona {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;

    public Problema04_Persona(String nombre, int edad, String ocupacion, String nivelImplicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getNivelImplicacion() {
        return nivelImplicacion;
    }

    public boolean puedeAcogerseReduccionPena() {
        return nivelImplicacion.equalsIgnoreCase("acusado");
    }

    public boolean puedePagarFianza(double sentenciaAnios, double dañoEconomico) {
        return nivelImplicacion.equalsIgnoreCase("acusado") && sentenciaAnios < 1 && (dañoEconomico * 0.5) > 0;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Ocupación: " + ocupacion + ", Nivel de Implicación: " + nivelImplicacion;
    }
}
