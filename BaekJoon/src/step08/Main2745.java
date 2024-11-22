package step08;

import java.io.IOException;
import java.util.Scanner;

public class Main2745 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        long result = 0;
        int idx = 0;// �� 0, 1, 2, 3 ....
        int num = 0;//����ϱ� ���� �� �ڸ� ���ڸ� 10������ �ٲ��ش�
        for (int i = n.length()-1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c>='0' && c<='9')
                num = c - '0';//0~9 ���̴� �״�� ���
            else
                num = c - 'A' + 10;//A~Z�� ���ڷ� ����
            result += num * Math.pow(b, idx++);
        }
        System.out.println(result);
        sc.close();
    }
}
