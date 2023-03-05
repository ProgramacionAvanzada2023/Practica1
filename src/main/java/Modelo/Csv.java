package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Csv {

    public static final String SEPARADOR = ",";

    public static Table readTable(String ruta){
        BufferedReader bufferLectura = null;
        Table tabla = new Table();
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(ruta));
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            //Primero llemos la cabecera si el fichero no esta vacio
            if(linea != null){
                List<String> headers = Arrays.stream(linea.split(SEPARADOR)).toList();
                tabla.setHeaders(headers);
                linea = bufferLectura.readLine();
            }
            while (linea != null) {
                // Introducir nueva fila en la tabla
                anyadirFilaEnTabla(tabla, linea);
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tabla;
    }

    private static void anyadirFilaEnTabla(Table tabla, String linea) {
        List<Double> listaCampos = Arrays.stream(linea.split(SEPARADOR))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Row fila = new Row(listaCampos);
        tabla.addFilas(fila);
    }

    public static TableWithLabels readTableWithLabels(String ruta){
        BufferedReader bufferLectura = null;
        TableWithLabels tabla = new TableWithLabels();
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(ruta));
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            //Primero llemos la cabecera si el fichero no esta vacio
            if(linea != null){
                List<String> headers = Arrays.stream(linea.split(SEPARADOR)).toList();
                tabla.setHeaders(headers);
                linea = bufferLectura.readLine();
            }

            int numElemCabecera = tabla.getHeaders().size();
            while (linea != null) {
                // Introducir nueva fila en la tabla
                anyadirFilaEnTableWithLabels(tabla, linea, numElemCabecera);
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tabla;
    }

    private static void anyadirFilaEnTableWithLabels(TableWithLabels tabla, String linea, int numElemCabecera) {
        String[] listaValores = linea.split(SEPARADOR);
        List<Double> dimensiones = new ArrayList<>();
        for (int i = 0; i < numElemCabecera -1; i++ ) {
            dimensiones.add(Double.parseDouble(listaValores[i]));
        }
        RowWithLabel fila = new RowWithLabel(dimensiones);

        String claseFlor = listaValores[numElemCabecera -1];
        tabla.getClasificacionFlores().putIfAbsent(claseFlor,tabla.getClasificacionFlores().size()+1);
        int numFlor = tabla.getClasificacionFlores().get(claseFlor);
        fila.setNumberClass(numFlor);

        tabla.addFilas(fila);
    }
}
