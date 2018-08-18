package tools;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* @author david */
public class Grafica {
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String titulo;
    private String tituloEjeX;
    private String tituloEjeY;

    public Grafica(String titulo, String tituloEjeX, String tituloEjeY) {
        this.titulo = titulo;
        this.tituloEjeX = tituloEjeX;
        this.tituloEjeY = tituloEjeY;
        this.grafica = null;
        this.series = new XYSeriesCollection();
    }
    
    public void agregarSerie(String id, Punto[] puntos) {
        XYSeries serie = new XYSeries(id);
        for (int i = 0; i < puntos.length; i++) {
            serie.add(puntos[i].getX(), puntos[i].getY());
        }
        this.series.addSeries(serie);
    }
    
    public void crearGrafica() {
        this.grafica = ChartFactory.createXYLineChart(titulo, tituloEjeX, 
            tituloEjeY, series);
        ChartFrame pane1 = new ChartFrame("Tiempos", grafica);
        pane1.setVisible(true);
    }
}
