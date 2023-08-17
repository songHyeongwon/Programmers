package OUTTER;
import java.util.Scanner;

public class Main17478 {
	// ���� �̸� ���������� �������־ recurTap�� �ʱ�ȭ ������ ���� �ʾ� "��� �亯�Ͽ���" �κп��� ���� ������ �� �Ǿ���.
	// ���������� �������� �ʰ� ���������� �����Ͽ� ��½� line 9���� ������ �޾� ����� ��µ��� �ʴ´�. 
	static String recurTap = "";
	public static void recursive(int n) {
		// ó������ ������ ����.
		String tap = recurTap;
		
		// 0�� �Ǹ� ����ϰ� ��� ����
		if(n == 0) {
			System.out.println(tap + "\"����Լ��� ������?\"");
			System.out.println(tap +"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(tap + "��� �亯�Ͽ���.");
			return;
		}
		// 0�� �Ǳ� �������� ��� �ݺ�
		System.out.println(tap + "\"����Լ��� ������?\"");
		System.out.println(tap + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(tap + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(tap + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		// ��͸� ���� ���� ��ĭ ����� �÷��ش�.
		recurTap += "____";
		recursive(n - 1);
		// ��Ϳ��� ���������鼭 ���� ū ����(������ ����) ���� ���� ��µȴ�.
		System.out.println(tap + "��� �亯�Ͽ���.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursive(n);
		sc.close();
	}
}