package kr.co.infopub.chapter.s164;
// ������ ���
public class ExchangeRate {
	public static void main(String[] args) {
		final double USD=1113.00;    // �����
		final double JPY=10.0624;    // ����� 
		double krw=1000000;          // ������
		double result=krw/USD;       // ���� 1000000.00/1113.00
		System.out.printf(
		  "��ȭ %.2f���� �̱��޷��� %.2f�޷� �Դϴ�.\n",krw,result);
		result=krw/(JPY);  // �Ϻ�100�� 1006.24��
		System.out.printf(
		  "��ȭ %.2f���� �Ϻ���ȭ�� %.2f�� �Դϴ�.\n",krw,result);
	}
}