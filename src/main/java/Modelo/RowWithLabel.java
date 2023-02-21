package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RowWithLabel extends Row{
    private int numberClass;

    public RowWithLabel(List<Double> data) {
        super(data);
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }

}
