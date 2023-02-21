package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> listaFilas = new ArrayList<>();

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<Row> getListaFilas() {
        return listaFilas;
    }

    public void setListaFilas(List<Row> listaFilas) {
        this.listaFilas = listaFilas;
    }

    public void addFilas(Row fila){
        this.listaFilas.add(fila);
    }

    public Row getRowAt(int numeroLinea){
         return this.listaFilas.get(numeroLinea);
    }

}
