package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class csv {

    public static final String SEPARADOR = ",";

    public static Table readTable(String ruta){
        BufferedReader bufferLectura = null;
        Table tabla = new Table();
        try {
            // Abrir el .csv en buffer de lectura

            bufferLectura = new BufferedReader(new FileReader(ruta));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();

            //Primero comprobamos si la primera linea no sea nula (El fichero no esta vacio) y la leemos
            if(linea != null){
                List<String> headers = Arrays.stream(linea.split(SEPARADOR)).toList();
                tabla.setHeaders(headers);
            }

            linea = bufferLectura.readLine();
            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                List<Double> listaCampos = Arrays.stream(linea.split(SEPARADOR))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
                RowWithLabel fila = new RowWithLabel(listaCampos);
                tabla.addFilas(fila);

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

    public static TableWithLabels readTableWithLabels(String ruta){
        BufferedReader bufferLectura = null;
        TableWithLabels tabla = new TableWithLabels();
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(ruta));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();

            //Primero comprobamos si la primera linea no sea nula (El fichero no esta vacio) y la leemos
            if(linea != null){
                List<String> headers = Arrays.stream(linea.split(SEPARADOR)).toList();
                tabla.setHeaders(headers);
            }

            linea = bufferLectura.readLine();
            int numElemCabecera = tabla.getHeaders().size();
            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] listaValores = linea.split(SEPARADOR);
                List<Double> listaCampos = new ArrayList<>();
                for (int i = 0; i < numElemCabecera-1; i++ ) {
                    listaCampos.add(Double.parseDouble(listaValores[i]));
                }
                String claseFlor = listaValores[numElemCabecera-1];
                int cantidadFlores = tabla.getClasificacionFlores().size() + 1;
                tabla.getClasificacionFlores().putIfAbsent(claseFlor,cantidadFlores);
                int numFlor = tabla.getClasificacionFlores().get(claseFlor);
                listaCampos.add(Double.valueOf(numFlor));

                Row fila = new Row(listaCampos);
                tabla.addFilas(fila);

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

    public static void main(String[] args) {

        //Table tabla = readTable("src/main/java/Ficheros/miles_dollars.csv");
        TableWithLabels tablaConEtiquetas = readTableWithLabels("src/main/java/Ficheros/iris.csv");
    }
}
