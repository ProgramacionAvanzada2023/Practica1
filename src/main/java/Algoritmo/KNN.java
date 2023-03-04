package Algoritmo;

import Modelo.Row;
import Modelo.RowWithLabel;
import Modelo.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class KNN {
    private TableWithLabels tabla;
    public void train(TableWithLabels data){
        tabla = data;
    }

    public Integer estimate(List<Double> data){
        Integer tipoFlor = Integer.MAX_VALUE;
        List<Double> distancias = new ArrayList<>();
        for (RowWithLabel fila : tabla.getListaFilasConEtiqueta()) {
            List<Double> flor = fila.getFila();
            distancias.add(calcularMetricaEuclidea(flor,data));
        }
        Integer posMin = getPosicionMasCerca(distancias);
        if(!posMin.equals(Integer.MAX_VALUE)){
            RowWithLabel fila = tabla.getRowAt(posMin);
            tipoFlor = fila.getNumberClass();
        }
        return tipoFlor;

    }

    public Double calcularMetricaEuclidea(List<Double> flor1, List<Double> flor2){
        int pos = 0;
        Double suma = 0D;
        while ( pos < flor1.size()){
            suma += Math.pow(flor2.get(pos) - flor1.get(pos),2);
            pos++;
        }
        return Math.sqrt(suma);
    }

    private Integer getPosicionMasCerca(List<Double> distancias){
        Integer posMin = Integer.MAX_VALUE;
        Double min = Double.MAX_VALUE;

        if (distancias == null || distancias.size() == 0) {
            return posMin;
        }
        for (int i = 0; i < distancias.size(); i++) {
            Double distancia = distancias.get(i);
            if(min > distancia){
                min = distancia;
                posMin = i;
            }
        }
        return posMin;
    }
}
