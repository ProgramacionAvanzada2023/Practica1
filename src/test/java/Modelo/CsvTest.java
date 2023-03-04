package Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvTest {

    Csv csv = new Csv();
    Table tabla = new Table();
    TableWithLabels tablaConEtiquetas = new TableWithLabels();

    @Test
    public void readTableTest() {
        String ruta = "src/main/java/Ficheros/miles_dollars.csv";
        Table tabla = csv.readTable(ruta);
        //El número de ejemplares (filas) leído es correcto
        comprobarCantidadFilasTabla(tabla, 25);
        //El número de columnas es correcto.
        comprobarCantidadCabeceraTabla(tabla,2);
        //El nombre de las etiquetas de las cabeceras es correcto.
        comprobarCabeceraTabla(tabla);
        //El número que se asigna a cada fila es correcto.
        //Las filas que guardas en una tabla puedes recuperarlas conteniendo los mismos valores que guardaste.
        comprobarFilaTabla(tabla);
    }



    private static void comprobarCantidadFilasTabla(Table tabla, int cantFilasOriginal) {
        int cantFilasTabla = tabla.getListaFilas().size();
        assertEquals(cantFilasOriginal, cantFilasTabla);
    }
    private static void comprobarCantidadCabeceraTabla(Table tabla, int cantColumnasOriginal) {
        int cantColumnasTabla = tabla.getHeaders().size();
        assertEquals(cantColumnasOriginal, cantColumnasTabla);
    }
    private static void comprobarCabeceraTabla(Table tabla) {
        List<String> cabeceraOriginal = new ArrayList<>();
        cabeceraOriginal.add("Miles");
        cabeceraOriginal.add("Dollars");
        List<String> cabeceraTabla = tabla.getHeaders();
        assertEquals(cabeceraOriginal, cabeceraTabla );
    }
    private static void comprobarFilaTabla(Table tabla) {
        List<Double> datos = new ArrayList<>();
        datos.add(1687D);
        datos.add(2511D);
        assertEquals(datos, tabla.getRowAt(3).getFila());
    }

    @Test
    public void readTableWithLabelsTest() {
        String ruta = "src/main/java/Ficheros/iris.csv";
        TableWithLabels tabla = csv.readTableWithLabels(ruta);
        //El número de ejemplares (filas) leído es correcto
        comprobarCantidadFilasTablaEtiquetas(tabla, 150);
        //El número de columnas es correcto.
        comprobarCantidadCabeceraTablaEtiquetas(tabla,5);
        //El nombre de las etiquetas de las cabeceras es correcto.
        comprobarCabeceraTablaEtiquetas(tabla);
        //El número que se asigna a cada fila es correcto.

        //Las filas que guardas en una tabla puedes recuperarlas conteniendo los mismos valores que guardaste.
        comprobarFilaTablaEtiquetas(tabla);
    }

    private static void comprobarCantidadFilasTablaEtiquetas(TableWithLabels tabla, int cantFilasOriginal) {
        int cantFilasTabla = tabla.getListaFilasConEtiqueta().size();
        assertEquals(cantFilasOriginal, cantFilasTabla);
    }
    private static void comprobarCantidadCabeceraTablaEtiquetas(TableWithLabels tabla, int cantColumnasOriginal) {
        int cantColumnasTabla = tabla.getHeaders().size();
        assertEquals(cantColumnasOriginal, cantColumnasTabla);
    }
    private static void comprobarCabeceraTablaEtiquetas(TableWithLabels tabla) {
        List<String> cabeceraOriginal = new ArrayList<>();
        cabeceraOriginal.add("sepal length");
        cabeceraOriginal.add("sepal width");
        cabeceraOriginal.add("petal length");
        cabeceraOriginal.add("petal width");
        cabeceraOriginal.add("class");
        List<String> cabeceraTabla = tabla.getHeaders();
        assertEquals(cabeceraOriginal, cabeceraTabla );
    }

    private static void comprobarFilaTablaEtiquetas(TableWithLabels tabla) {
        List<Double> datos = new ArrayList<>();
        datos.add(5.1);
        datos.add(3.5);
        datos.add(1.4);
        datos.add(0.2);
        datos.add(1D);
        assertEquals(datos, tabla.getRowAt(3).getFila());
    }
}