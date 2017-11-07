package mips;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class mips {
	
	static String[][] $s = { {"$s0",""}, {"$s1",""}, {"$s2",""}, {"$s3",""}, {"$s4",""} };
	
	public static void main(String args[]) {
		String LtorMt = null;
		String AorS = null;
		String tempCon = "";
		String tempLoop = "";
		String tempEqual = "";
		char CharValue;
		
		int value = 0;

		String path = "C:\\Users\\thawatkrit\\Desktop\\mips.txt";
		File file = new File(path);
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("int")) {
					
					$s[value][1] = String.valueOf(line.charAt(4));
					System.out.printf("\tlw %s,"+ $s[value][1] +"\n", $s[value][0]);
					value++;
					
				}
				if (line.startsWith("while") == true) {
					
					for (int i = 1; i < line.length() - 1; i++) {
						
						if (line.charAt(i) == '>') {
							LtorMt = "bgt";
							tempCon = LtorMt + " " + convertToRegister(line.charAt(i-1)) + "," + convertToRegister(line.charAt(i+1)) + ",";
						} else if (line.charAt(i) == '<') {
							LtorMt = "blt";
							tempCon = LtorMt + " " + convertToRegister(line.charAt(i-1)) + "," + convertToRegister(line.charAt(i+1)) + ",";
						}
					}
					
					System.out.println("loop0 : " + tempCon + "loop1");
					System.out.println("\tj out");

				}
			
				

				if (line.contains("=") && (line.contains("+") || line.contains("-"))) {
					
					for (int i = 1; i < line.length() - 1; i++) {
						if (line.charAt(i) == '=') {
							tempEqual = convertToRegister(line.charAt(i-1));
						}
						if (line.charAt(i) == '+') {
							AorS = "add";
							tempLoop += AorS + " " + tempEqual + "," + convertToRegister(line.charAt(i-1)) + "," + convertToRegister(line.charAt(i+1)) + "\n\t" + "sw " + tempEqual + "," + convertToVariable(tempEqual) + "\n\t";
							
						}else if (line.charAt(i) == '-') {
							AorS = "sub";
							tempLoop += AorS + " " + tempEqual + "," + convertToRegister(line.charAt(i-1)) + "," + convertToRegister(line.charAt(i+1)) + "\n\t" + "sw " + tempEqual + "," + convertToVariable(tempEqual) + "\n\t";
						}
					}
					
				}

			}
			System.out.print("loop1 : " + tempLoop);
			System.out.println("j loop0");
			System.out.println("out : ...");

			br.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}


	public static String convertToRegister(char s) {
		String temp = "";
		for(int i = 0; i < 5; i++) {
			if($s[i][1].equals( String.valueOf(s))) {
				temp =  $s[i][0];
				break;
			}
		}
		return temp;
	}
	
	public static String convertToVariable(String s) {
		String temp = "";
		for(int i = 0; i < 5; i++) {
			if($s[i][0].equals( String.valueOf(s))) {
				temp =  $s[i][1];
				break;
			}
		}
		return temp;
	}

}
