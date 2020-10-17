package com.as;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class AppendToFileExample {
	public static void main(String[] args) {
//      try { 
//         String data = " Tutorials Point is a best website in the world";
//         File f1 = new File("abc.txt");
//         if(!f1.exists()) {
//            f1.createNewFile();
//         } 
//         FileWriter fileWritter = new FileWriter(f1.getName(),true);
//         BufferedWriter bw = new BufferedWriter(fileWritter);
//         bw.write("\n"+data);
//         bw.close();
//         System.out.println("Done");
//      } catch(IOException e){
//         e.printStackTrace();
//      }

		try {
			FileInputStream fis = new FileInputStream("abc.txt");
			Scanner sc = new Scanner(fis);
			StringBuffer sb=new StringBuffer();
			while (sc.hasNextLine()) {
				sb.append("=>"+sc.nextLine());
				sb.append("\n");
			}
			System.out.println(sb);
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}