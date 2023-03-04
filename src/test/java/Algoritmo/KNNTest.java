package Algoritmo;

import Modelo.Csv;
import Modelo.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KNNTest {

    private Csv lecturaFichero = new Csv();
    private KNN algoritmoKnn = new KNN();

    @Test
    void trainTest() {
        TableWithLabels tablaConEtiquetas = lecturaFichero.readTableWithLabels("src/main/java/Ficheros/iris.csv");
        algoritmoKnn.train(tablaConEtiquetas);
    }

    @Test
    void estimateTest() {
        trainTest();
        //Iris-setosa
        assertEquals(1,algoritmoKnn.estimate(crearPunto(5.1,3.3,1.7,0.5)));
        assertEquals(1,algoritmoKnn.estimate(crearPunto(4.92D,3.48D,1.5D,0.26D)));

        //Iris-versicolor
        assertEquals(2,algoritmoKnn.estimate(crearPunto(6.6,2.9,4.6,1.3)));
        assertEquals(2,algoritmoKnn.estimate(crearPunto(5.76D,2.64,4.13D,1.29D)));

        //Iris-virginica
        assertEquals(3,algoritmoKnn.estimate(crearPunto(6.5,3.0,5.2,2.0)));
        assertEquals(3,algoritmoKnn.estimate(crearPunto(6.52D,2.94D,5.56D,2.1D)));

        //Flor aleatoria
        assertEquals(2,algoritmoKnn.estimate(crearPunto(5.67D,3.02D,4.02D,1.20D)));
    }

    @Test
    void calcularMetricaEuclideaTest() {
        //Test Sin coordenadas
        assertEquals(Math.sqrt(0), algoritmoKnn.calcularMetricaEuclidea(new ArrayList<>(), new ArrayList<>()));

        //Test Puntos Dos coordenadas
        testDosCoordenadas();

        //Test Puntos Tres coordenadas
        testTresCoordenadas();

        //Test Puntos Cuatro coordenadas
        testCuatroCoordenadas();
    }

    private void testDosCoordenadas() {
        assertEquals(Math.sqrt(0), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,2D), crearPunto(1D,2D)));
        assertEquals(Math.sqrt(10), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,3D), crearPunto(2D,6D)));
        assertEquals(Math.sqrt(104), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,5D), crearPunto(1D,-5D)));
        assertEquals(Math.sqrt(25), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,-10D), crearPunto(-5D,-7D)));
    }

    private void testTresCoordenadas(){
        assertEquals(Math.sqrt(0), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,2D,3D), crearPunto(1D,2D,3D)));
        assertEquals(Math.sqrt(26), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,3D,5D), crearPunto(2D,6D,1D)));
        assertEquals(Math.sqrt(360), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,5D,7D), crearPunto(1D,-5D,-9D)));
        assertEquals(Math.sqrt(41), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,-10D, -4D), crearPunto(-5D,-7D, -8D)));
    }

    private void testCuatroCoordenadas(){
        assertEquals(Math.sqrt(0), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,2D,3D,4D), crearPunto(1D,2D,3D,4D)));
        assertEquals(Math.sqrt(30), algoritmoKnn.calcularMetricaEuclidea(crearPunto(1D,3D,5D,7D), crearPunto(2D,6D,1D,5D)));
        assertEquals(Math.sqrt(504), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,5D,7D,-9D), crearPunto(1D,-5D,-9D,3D)));
        assertEquals(Math.sqrt(66), algoritmoKnn.calcularMetricaEuclidea(crearPunto(-1D,-10D, -4D,-8D), crearPunto(-5D,-7D, -8D,-3D)));
    }

    private List<Double> crearPunto(Double x, Double y){
        List<Double> listaCoordenadas = new ArrayList<>();
        listaCoordenadas.add(x);
        listaCoordenadas.add(y);
        return listaCoordenadas;
    }

    private List<Double> crearPunto(Double x, Double y, Double z){
        List<Double> listaCoordenadas = crearPunto(x,y);
        listaCoordenadas.add(z);
        return listaCoordenadas;
    }

    private List<Double> crearPunto(Double x, Double y, Double z, Double s){
        List<Double> listaCoordenadas = crearPunto(x,y,z);
        listaCoordenadas.add(s);
        return listaCoordenadas;
    }
}