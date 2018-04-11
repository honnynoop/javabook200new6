package kr.co.infopub.chapter.s1742;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ExchangeLineChart extends Application{
  public static void main(String[] args) {
    launch(args);
  }
  int range=50;
  @Override
  public void start(Stage primaryStage) {
	primaryStage.setTitle("Exchange Rate");  
	String date=RestDay.todates();  // ����
	String base="USD";              // 1�޷��� ȯ��
	
	CategoryAxis xAxis = new CategoryAxis();         // X��-��¥
	NumberAxis yAxis = new NumberAxis(1000,1200,10); // Y��-ȯ��
	yAxis.setLabel("KRW / 1 "+base);   // Y�� ��
	xAxis.setLabel("Date");                          // X�� ��
	LineChart<String, Number> lineChart = 
			new LineChart<String, Number>(xAxis, yAxis); // ��ǥ
	lineChart.setTitle("Exchange Rate "+date);

	XYChart.Series<String, Number> series1 = 
			   new XYChart.Series<String, Number>(); //(X, Y) ����
	physicalChartData(series1,base, date);
	
	Scene scene = new Scene(lineChart, 1400, 800);
    lineChart.getData().addAll(series1);    // ��ǥ��  (X, y)�� �����غ� 
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public  void physicalChartData(
		  XYChart.Series<String, Number> series1, 
		  String base,String date ) {
    series1.setName("KRW");
    for (int i = -range; i < 1; i++) {
    	String todays=RestDay.toWantedDay(date,i);  // ���ÿ��� i������
    	if(!RestDay.isRest(todays)){     //��, �Ͽ��� ����
    		// ��¥�� ȯ������ ��ü ���
    		FixerRate fixerrate=FixerConvert.convert(todays,base);
	    	series1.getData().add(  // (X,Y)->(��¥, ȯ��) �� ���̱�
	    	new XYChart.Data<String, Number>(todays, fixerrate.krw));
    	}
    }
  }
}
