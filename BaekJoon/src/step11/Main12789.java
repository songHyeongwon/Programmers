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

        int N = Integer.parseInt(br.readLine()); //승환이 앞에 서있는 학생 수

        int[] lineStack = new int[N]; //승환이 앞에 서있는 학생들의 수만큼 순서 저장하는 배열

        //승환이 앞에 서있는 모든 학생들의 번호표 앞 -> 뒤로 주어짐
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            lineStack[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(solution(lineStack));
        bw.flush();
        bw.close();
    }

    //승환이가 받을 수 있는지 확인하여 결과(받을 수 있으면 Nice, 아니면 Sad)를 반환하는 메서드
    static String solution(int[] stack){
        int orderValue = 1; //첫번째로 뽑아야하는 값

        // 해당 값이 다를경우 임시로 저장할 stack
        Stack<Integer> tmpStack = new Stack<>();

        // stack.length : 승환이 앞에 있는 학생 수
        for(int i = 0; i < stack.length; i++){
            if(stack[i] != orderValue){ //찾는 번호가 아닐 경우
                //임시 저장공간이 비어있지 않으면서 가장 최근에 들어간 요소가 찾는 번호일 경우
                if(!tmpStack.isEmpty() && tmpStack.peek() == orderValue){
                    tmpStack.pop();
                    i--; //임시 저장소에 있었지 stack이라는 공간에 있었던 것은 아니므로 한번더 반복해야한다.
                    orderValue++;
                }else{ //찾는 번호가 아닐 경우 임시저장소에 넣는다
                    tmpStack.push(stack[i]);
                }
            }else{ //찾는 번호일 경우
                orderValue++; //찾을 다음 번호로 넘어간다.
            }
        }

        boolean result = true; //결과 유효성 검사

        //stack.length를 다 비우고, 임시저장소는 비어있지 않을 수 있다.
        for(int i = 0; i < tmpStack.size(); i++){
            int tValue = tmpStack.pop(); //임시저장소에 최근에 들어간 번호

            if(tValue == orderValue){ //찾으려는 번호 이어서 저장
                orderValue++;
            }else{ //찾으려는 번호가 아니면 나오는 순서가 맞을 수 없으므로
                result = false;
                break; //더이상 반복X
            }
        }

        return result ? "Nice" : "Sad";
    }
}