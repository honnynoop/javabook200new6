package kr.co.infopub.chapter.s162;
import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class Biorythms extends Application{
 public static void main(String[] args) {
    launch(args);
  }
  int dayWith=25;   // �����Ͽ� ���Ͽ� �յڷ� 25�� ���̱�
  @Override
  public void start(Stage primaryStage) {
	// ����  
	int year=1971;
	int month=9;
	int day=28;
	long live=BioCalendar.days(year, month, day)  ;  // ���ñ��� ��ƿ³�
	
	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();
	yAxis.setLabel("Bio Power");
	xAxis.setLabel("Date");
	LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
	lineChart.setTitle("My Biorhythm");
    // ��ü���� 
	XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
	XYChart.Series<String, Number> series5 = new XYChart.Series<String, Number>();
	physicalChartData(series1,live);  // ��ü���� �׸���
	vertical(series5);                // ������ �׸���
	
	Scene scene = new Scene(lineChart, 1200, 600);
    lineChart.getData().addAll(series1,series5); // ������ ������ ����
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  // ���� ������
  public  void vertical(XYChart.Series<String, Number> series ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("Today");
    // ����- �ִ밪, �ּҰ��� ��������
    series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(todayCal), 125));
    series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(todayCal), -125));
  }
  // ��ü ���� �׸��� - ���鿬��
  public  void physicalChartData(XYChart.Series<String, Number> series, long live ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("PHYSICAL");
    for (int i = -dayWith; i < dayWith+1; i++) {
    	 Calendar bf15day=RestDay.dateAfOrBf(todayCal,i);  // ��ƿ³�
    	 double value=BioCalendar.getPhysical(live+i,100); // ��ü���� ��
    	 // ��¥�� ���Ͽ� ��ü�������� XY�� ���� ��� ����
    	 series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(bf15day), value));
    }
  }
}
