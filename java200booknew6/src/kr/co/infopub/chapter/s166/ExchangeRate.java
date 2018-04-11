package kr.co.infopub.chapter.s166;
import java.util.Scanner;
// if ���ǹ� -> 1�̸� USD�� 2�� JPY, 3�̸� CNY 1,2,3���� �ٸ����� ȯ���Ұ���
public class ExchangeRate {
	public static void main(String[] args) {
		double USD=1113.00;    //������
		double JPY=10.0624;    //������ 
		double CNY=164.1020;   //������ 
		double krw=1000000;    //�鸸�� -ȯ���Ϸ��� �ϴ� �ݾ�
		
		System.out.println("USD�� ȯ���Ϸ��� 1, JPY�� ȯ���Ϸ��� 2, CNY�� ȯ�� �Ϸ��� 3�� �Է��ϼ���.");
		Scanner scann=new Scanner(System.in);//Ű����
		int choice=scann.nextInt();//Ű����� ���� �Է�
		double result=0.0; //���� ����
		if(choice==1){
			result=calculate(krw,USD);   
			System.out.printf("��ȭ %.2f����  %.2f�޷��Դϴ�.\n",krw,result);
		}else if(choice==2){
			result=calculate(krw,JPY);
			System.out.printf("��ȭ %.2f����  %.2f�� �Դϴ�.\n",krw,result);
		}else if(choice==3){
			result=calculate(krw,CNY);
			System.out.printf("��ȭ %.2f���� %.2f���� �Դϴ�.\n",krw,result);
		}else{
			System.out.println("ȯ���� �� �����ϴ�.");
		}
	}
	// ������ ������ �ݺ� -> �޼���� �����.
	public static double calculate(double krwMoney, double exchangeRatio){
		return krwMoney/exchangeRatio;
	}
}