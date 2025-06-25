package step11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //��ȯ�� �տ� ���ִ� �л� ��

        int[] lineStack = new int[N]; //��ȯ�� �տ� ���ִ� �л����� ����ŭ ���� �����ϴ� �迭

        //��ȯ�� �տ� ���ִ� ��� �л����� ��ȣǥ �� -> �ڷ� �־���
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            lineStack[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(solution(lineStack));
        bw.flush();
        bw.close();
    }

    //��ȯ�̰� ���� �� �ִ��� Ȯ���Ͽ� ���(���� �� ������ Nice, �ƴϸ� Sad)�� ��ȯ�ϴ� �޼���
    static String solution(int[] stack){
        int orderValue = 1; //ù��°�� �̾ƾ��ϴ� ��

        // �ش� ���� �ٸ���� �ӽ÷� ������ stack
        Stack<Integer> tmpStack = new Stack<>();

        // stack.length : ��ȯ�� �տ� �ִ� �л� ��
        for(int i = 0; i < stack.length; i++){
            if(stack[i] != orderValue){ //ã�� ��ȣ�� �ƴ� ���
                //�ӽ� ��������� ������� �����鼭 ���� �ֱٿ� �� ��Ұ� ã�� ��ȣ�� ���
                if(!tmpStack.isEmpty() && tmpStack.peek() == orderValue){
                    tmpStack.pop();
                    i--; //�ӽ� ����ҿ� �־��� stack�̶�� ������ �־��� ���� �ƴϹǷ� �ѹ��� �ݺ��ؾ��Ѵ�.
                    orderValue++;
                }else{ //ã�� ��ȣ�� �ƴ� ��� �ӽ�����ҿ� �ִ´�
                    tmpStack.push(stack[i]);
                }
            }else{ //ã�� ��ȣ�� ���
                orderValue++; //ã�� ���� ��ȣ�� �Ѿ��.
            }
        }

        boolean result = true; //��� ��ȿ�� �˻�

        //stack.length�� �� ����, �ӽ�����Ҵ� ������� ���� �� �ִ�.
        for(int i = 0; i < tmpStack.size(); i++){
            int tValue = tmpStack.pop(); //�ӽ�����ҿ� �ֱٿ� �� ��ȣ

            if(tValue == orderValue){ //ã������ ��ȣ �̾ ����
                orderValue++;
            }else{ //ã������ ��ȣ�� �ƴϸ� ������ ������ ���� �� �����Ƿ�
                result = false;
                break; //���̻� �ݺ�X
            }
        }

        return result ? "Nice" : "Sad";
    }
}