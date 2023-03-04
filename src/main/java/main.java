import Algoritmo.KNN;
import Modelo.Csv;
import Modelo.Table;
import Modelo.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class main {

    static Csv csv = new Csv();
    static Table tabla = new Table();
    static TableWithLabels tablaConEtiquetas = new TableWithLabels();
    static KNN algoritmo = new KNN();

    public static void main(String[] args) {

        Table tabla = csv.readTable("src/main/java/Ficheros/miles_dollars.csv");
        TableWithLabels tablaConEtiquetas = csv.readTableWithLabels("src/main/java/Ficheros/iris.csv");

        //Algoritmo
        algoritmo.train(tablaConEtiquetas);
        //Iris-setosa -> 1
        List<Double> florIrisSetosa = createflor(5.2,3.4,1.3,0.5);
        //System.err.println("PruebaIrisSetosa: " + algoritmo.estimate(florIrisSetosa));

        //Iris-versicolor -> 2
        List<Double> florIrisVersicolor = createflor(5.7,2.6,3.5,1.0);
        //System.err.println("PruebaIrisVersicolor: " + algoritmo.estimate(florIrisVersicolor));
        //Iris-virginica -> 3
        List<Double> florIrisVirginica = createflor(6.7,3.3,5.7,2.1);
        //System.err.println("PruebaIrisVirginica: " + algoritmo.estimate(florIrisVirginica));
    }

    private static List<Double> createflor(Double x, Double y, Double z, Double s){
        List<Double> listaCoordenadas = new ArrayList<>();
        listaCoordenadas.add(x);
        listaCoordenadas.add(y);
        listaCoordenadas.add(z);
        listaCoordenadas.add(s);
        return listaCoordenadas;
    }
}
