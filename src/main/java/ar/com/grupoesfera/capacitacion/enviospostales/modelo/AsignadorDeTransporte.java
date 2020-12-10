package ar.com.grupoesfera.capacitacion.enviospostales.modelo;

import ar.com.grupoesfera.capacitacion.enviospostales.modelo.excepciones.ExcepcionAsignadorDeTransporte;

import java.util.List;

public class AsignadorDeTransporte {

    // Ojo con la ubicuidad del concepto, si Vehiculo y Transporte son
    // el mismo concepto para el modelo entonces conviene elegir
    // un solo nombre y usar ese en todos los lugares (clases, métodos, paquetes, etc)
    public ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo asignarTransporte(List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> paquetes){
        ar.com.grupoesfera.capacitacion.enviospostales.modelo.Vehiculo vehiculo = null;

        if(paquetes.isEmpty()){
            throw new ExcepcionAsignadorDeTransporte("No se puede asignar vehiculo", null);
        }
        Double pesoTotal = pesoTotal(paquetes);
        if(pesoTotal <= 5){
            vehiculo =  new Bicicleta();
        } else if(pesoTotal <= 50){
            vehiculo = new Auto();
        } else if(pesoTotal <= 150){
            vehiculo = new Camioneta();
        } else {
            throw new ExcepcionAsignadorDeTransporte("No se puede asignar vehiculo", pesoTotal);
        }
        return vehiculo;
    }

    private Double pesoTotal(List<ar.com.grupoesfera.capacitacion.enviospostales.modelo.Paquete> paquetes) {
        return paquetes.stream().mapToDouble(i -> i.getPeso()).sum();
    }
}
