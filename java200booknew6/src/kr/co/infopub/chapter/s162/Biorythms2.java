package kr.co.infopub.chapter.s162;
import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class Biorythms2 extends Application{
 public static void main(String[] args) {
    launch(args);
  }
  int dayWith=25;   // �����Ͽ� ���Ͽ� �յڷ� 25�� ���̱�
  @Override
  public void start(Stage primaryStage) {
	// ����  
	int year=191;
	int month=9;
	int day=28;
	// ���Ϻ��� ���ñ��� ���� ��Ҵ°�?
	long live=BioCalendar.days(year, month, day)  ;  //���ñ���
	
	CategoryAxis xAxis = new CategoryAxis(); // X��
	NumberAxis yAxis = new NumberAxis();     // Y��
	yAxis.setLabel("Bio Power");
	xAxis.setLabel("Date");
	// XY ��� �غ�
	LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
	lineChart.setTitle("My Biorhythm");
    // 1. ��ü, 2. ����, 3. ����, 4. (1+2+3)/3 ����, 5. ����
	XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>(); // 1
	XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>(); // 2
	XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>(); // 3
	XYChart.Series<String, Number> series4 = new XYChart.Series<String, Number>(); // 4
	XYChart.Series<String, Number> series5 = new XYChart.Series<String, Number>(); // 5
	physicalChartData(series1,live);
	emotionalChartData(series2,live);
	intellectualChartData(series3,live);
	compositeChartData(series4,live);
	vertical(series5);
	
	Scene scene = new Scene(lineChart, 1200, 600);
    lineChart.getData().addAll(series1, series2, series3,series4,series5);
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  // ���� ������
  public  void vertical(XYChart.Series<String, Number> series ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("Today");
    series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(todayCal), 125));
    series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(todayCal), -125));
  }
  // ��ü ���� �׸��� - ���鿬��
  public  void physicalChartData(XYChart.Series<String, Number> series, long live ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("PHYSICAL");
    for (int i = -dayWith; i < dayWith+1; i++) {
    	 Calendar bf15day=RestDay.dateAfOrBf(todayCal,i);
    	 double value=BioCalendar.getPhysical(live+i,100);
    	 series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(bf15day), value));
    }
  }
  // ���� ���� �׸���
  public  void emotionalChartData(XYChart.Series<String, Number> series, long live ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("EMOTIONAL");
    for (int i = -dayWith; i < dayWith+1; i++) {
    	 Calendar bf15day=RestDay.dateAfOrBf(todayCal,i);
    	 double value=BioCalendar.getEmotional(live+i,100);
    	 series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(bf15day), value));
    }
  }
  // ���� ���� �׸���
  public  void intellectualChartData(XYChart.Series<String, Number> series, long live ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("INTELLECTUAL");
    for (int i = -dayWith; i < dayWith+1; i++) {
    	 Calendar bf15day=RestDay.dateAfOrBf(todayCal,i);
    	 double value=BioCalendar.getIntellectual(live+i,100);
    	 series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(bf15day), value));
    }
  }
  // ���� (��ü+����+����)/3
  public  void compositeChartData(XYChart.Series<String, Number> series, long live ) {
	Calendar todayCal=Calendar.getInstance();
    series.setName("COMPOSITE");
    for (int i = -dayWith; i < dayWith+1; i++) {
    	 Calendar bf15day=RestDay.dateAfOrBf(todayCal,i);
    	 double value=BioCalendar.getIntellectual(live+i,100)
    			 +BioCalendar.getEmotional(live+i,100)
    			 +BioCalendar.getPhysical(live+i,100);
    	 series.getData().add(new XYChart.Data<String, Number>(RestDay.toStrDate(bf15day), value/3.0));
    }
  }
}
