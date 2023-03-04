package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {
    private List<RowWithLabel> listaFilasConEtiqueta;
    private Map<String, Integer> clasificacionFlores;

    public TableWithLabels (){
        super();
        this.listaFilasConEtiqueta = new ArrayList<>();
        this.clasificacionFlores = new HashMap<>();

        for (Row f : super.getListaFilas()) {
            RowWithLabel fila = new RowWithLabel(f.getFila());
            addFilas(fila);
        }
    }

    public List<RowWithLabel> getListaFilasConEtiqueta() {
        return listaFilasConEtiqueta;
    }

    public void setListaFilasConEtiqueta(List<RowWithLabel> listaFilasConEtiqueta) {
        this.listaFilasConEtiqueta = listaFilasConEtiqueta;
    }

    public Map<String, Integer> getClasificacionFlores() {
        return clasificacionFlores;
    }

    public void addFilas(RowWithLabel fila){
        this.listaFilasConEtiqueta.add(fila);
    }

    public void setClasificacionFlores(Map<String, Integer> clasificacionFlores) {
        this.clasificacionFlores = clasificacionFlores;
    }

    @Override
    public RowWithLabel getRowAt(int numeroLinea) {
        return this.listaFilasConEtiqueta.get(numeroLinea);
    }
}
