package step07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11718 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String temp = br.readLine();
        while (temp != null) {
        	bw.write(temp);
            bw.newLine();
        	temp = br.readLine();
		}
        
        bw.flush();
        bw.close();
	}
}
