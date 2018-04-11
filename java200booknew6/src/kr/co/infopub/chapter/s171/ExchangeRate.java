package kr.co.infopub.chapter.s171;
import java.util.Scanner;
public class ExchangeRate {
	public static void main(String[] args) {
		System.out.println("USD�� ȯ���Ϸ��� 1, JPY�� ȯ���Ϸ��� 2, CNY�� ȯ�� �Ϸ��� 3�� �Է��ϼ���.");
		Scanner scann=new Scanner(System.in);//Ű����
		int choice=scann.nextInt();//Ű����� ���� �Է�
		String me="KRW";
		String you="USD";      // �̱� �޷� 
		String date=RestDay.todates();  // ���� ��¥�� ���ڿ��� "2017-06-22"
		double krw=1000000;    // 1000000��
		double result=0.0;     // ȯ�����
		FixerRate finance=null;
		if(choice==1){
			you="USD";   // USDKRW �̱��� �޷��� ��ȭ�� 
		}else if(choice==2){
			you="JPY";  // JPYKRW �Ϻ��� ���� ��ȭ�� 
		}else if(choice==3){
			you="CNY";  // CNYKRW �߱��� ������ ��ȭ��  
		}else{
			System.out.println("ȯ���� �� �����ϴ�.");
		}
		finance=FixerConvert.convert(date, you); //������ ��
		result=calculate(krw,finance.krw);       //���
		System.out.println(finance.date+"����");
		System.out.printf( "%.2f %s�� %.2f %s�Դϴ�.\n",krw,me,result,you);
	}
	//������ ������ �ݺ� -> �޼���� �����.
	public static double calculate(double krwMoney, double ratio){
		return krwMoney/ratio;
	}
}
