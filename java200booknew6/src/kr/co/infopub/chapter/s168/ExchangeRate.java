package kr.co.infopub.chapter.s168;
public class ExchangeRate {
	public static void main(String[] args) {
		// ȯ�������� ��ü�� ����
		FixerRate finance =new FixerRate();
		finance.base="USD";
		finance.date="2017-06-08";
		finance.usd=1;
		finance.jpy=110.22;
		finance.cny=6.7978;
		finance.krw=1123.3;
		finance.eur=0.89055;
		System.out.println( finance);
		//ȯ�������� �̿��Ͽ� ���
		double krw=1000000;
		double ratio=finance.krw;
		double result=ExchangeRate.calculate(krw,ratio);
		System.out.printf("%.2fKRW�� %.2f%s�Դϴ�.\n",krw, result,finance.base);
	}
	//������ ������ �ݺ� -> �޼���� �����.
	public static double calculate(double krwMoney, double exchangeRatio){
		return krwMoney/exchangeRatio;
	}
}