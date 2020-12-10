package ar.com.grupoesfera.capacitacion.enviospostales.modelo;

import java.math.BigDecimal;
import java.util.List;

public class Envio {

    private List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> paquetes;
    private BigDecimal costo;
    private String direccionDeEntrega;
    private ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo transporte;

    public Envio(List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> paquetes, BigDecimal costo, String direccionDeEntrega, ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo transporte){
        this.paquetes = paquetes;
        this.costo = costo;
        this.direccionDeEntrega = direccionDeEntrega;
        this.transporte = transporte;
    }

    public List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> getPaquetes() {
        return paquetes;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public String getDireccionDeEntrega() {
        return direccionDeEntrega;
    }

    public ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo getTransporte() {
        return transporte;
    }
}
