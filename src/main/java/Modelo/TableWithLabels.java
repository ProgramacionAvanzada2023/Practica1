package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {
    private List<RowWithLabel> filas = new ArrayList<>();
    private Map<String, Integer> clasificacionFlores = new HashMap<>();

    public List<RowWithLabel> getFilas() {
        return filas;
    }

    public void setFilas(List<RowWithLabel> filas) {
        this.filas = filas;
    }

    public Map<String, Integer> getClasificacionFlores() {
        return clasificacionFlores;
    }

    public void setClasificacionFlores(Map<String, Integer> clasificacionFlores) {
        this.clasificacionFlores = clasificacionFlores;
    }

    public void addFilas(RowWithLabel fila){
        this.filas.add(fila);
    }

    @Override
    public RowWithLabel getRowAt(int numeroLinea) {
        return filas.get(numeroLinea);
    }
}
