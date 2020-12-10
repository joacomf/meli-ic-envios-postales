package ar.com.grupoesfera.capacitacion.enviospostales.modelo;

import java.math.BigDecimal;
import java.util.List;

public class DespachadorDeEnvios {

    private ar.com.grupoesfera.capacitacion.enviospostales.modelo.CalculadorDeCostosDeEnvio calculadorDeCostosDeEnvio;
    private AsignadorDeTransporte asignadorDeTransporte;
    private Integer contadorDeEnvios = 0;

    public DespachadorDeEnvios(ar.com.grupoesfera.capacitacion.enviospostales.modelo.CalculadorDeCostosDeEnvio calculadorDeCostosDeEnvio, AsignadorDeTransporte asignadorDeTransporte){
        this.asignadorDeTransporte = asignadorDeTransporte;
        this.calculadorDeCostosDeEnvio = calculadorDeCostosDeEnvio;
    }

    public Envio despachar(List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> paquetes, String direccionDeEntrega){
        try{
            BigDecimal costo = calculadorDeCostosDeEnvio.calcularCosto(paquetes.size());
            ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo vehiculo = asignadorDeTransporte.asignarTransporte(paquetes);
            return new Envio(paquetes, calcularImpuesto(costo), direccionDeEntrega, vehiculo);
        } catch (Exception e){
            return null;
        }
    }

    private BigDecimal calcularImpuesto(BigDecimal costo){
        if(contadorDeEnvios == 10){
            costo = costo.multiply(new BigDecimal("1.1"));
        } else {
            contadorDeEnvios++;
        }
        return costo;
    }
}
