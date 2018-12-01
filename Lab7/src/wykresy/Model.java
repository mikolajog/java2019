package wykresy;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.lang.Math;

import java.util.LinkedList;

public class Model {
    private double zakresOd;
    private double zakresDo;
    private double czestototoliwosc;
    private LinkedList<Integer> wspolczynniki;

    public Model(String wspolczynniki, String zakresOd, String zakresDo, String czestotliwosc){
        this.zakresOd = Double.parseDouble(zakresOd);
        this.zakresDo = Double.parseDouble(zakresDo);
        this.czestototoliwosc = Double.parseDouble(czestotliwosc);
        this.wspolczynniki=new LinkedList<>();
        String[] tab = wspolczynniki.split(" ");
        for(int i=0; i<tab.length; i++){
            this.wspolczynniki.add(Integer.parseInt(tab[i]));
        }
    }

    public double fuction(double val){
        double result = 0;
        for(int i=0; i<this.wspolczynniki.size(); i++){
            result+=this.wspolczynniki.get(i)*Math.pow(val, this.wspolczynniki.size()-1-i);
        }
        return result;
    }

    public void drawLineChart(AnchorPane anchorPane){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("X Values");
        yAxis.setLabel("Y Values");

        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Wykres");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        //populating the series with data

        for(double a=zakresOd; a < zakresDo; a+=czestototoliwosc){
            series.getData().add(new XYChart.Data(a, this.fuction(a)));
        }
        series.setName("Wielomian");
        lineChart.setMaxHeight(300);
        lineChart.setMaxWidth(400);
        lineChart.getData().add(series);

        anchorPane.getChildren().add(lineChart);
    }
}
