package kr.co.infopub.chapter.s165;
// �޼���
public class ExchangeRate {
	//������ ������ �ݺ� -> �޼���� �����.
	public static double calculate(double krwMoney, double exchangeRatio){
		return krwMoney/exchangeRatio;
	}
	public static void main(String[] args) {
		final double USD=1113.00;    //�����
		final double JPY=10.0624;    //����� 
		double krw=1000000;          //������
		//���1 - �޼��� ȣ��
		double result=calculate(krw,USD);
		System.out.printf("��ȭ %.2f���� �̱��޷��� %.2f�޷� �Դϴ�.\n",krw,result);
		//���2 - �޼��� ȣ��
		result=calculate(krw,JPY);  //�Ϻ�100�� 1006.24��
		System.out.printf("��ȭ %.2f���� �Ϻ���ȭ�� %.2f�� �Դϴ�.\n",krw,result);
	}
}
