package mips;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String args[]) {
		String LtorMt = null;
		String AorS = null;

		String path = "C:\\Users\\thawatkrit\\Desktop\\testwhile.txt";
		File file = new File(path);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("int")) {
					for (int i = 1; i < line.length() - 1; i++) {
						if ((line.charAt(i) == 'a') && (line.charAt(i + 1) == '=')) {
							System.out.println("\tlw $s0," + line.substring(i, i + 1));
						}
					}
					for (int i = 1; i < line.length() - 1; i++) {
						if ((line.charAt(i) == 'b') && (line.charAt(i + 1) == '=')) {
							System.out.println("\tlw $s1," + line.substring(i, i + 1));
						}
					}
					for (int i = 1; i < line.length() - 1; i++) {
						if ((line.charAt(i) == 'c') && (line.charAt(i + 1) == '=')) {
							System.out.println("\tlw $s2," + line.substring(i, i + 1));
						}
					}
				}
				if (line.startsWith("while") == true) {
					for (int i = 1; i < line.length() - 1; i++) {
						if ((line.charAt(i) == '>')) {
							LtorMt = "bgt";
						} else if ((line.charAt(i) == '<')) {
							LtorMt = "blt";
						}
					}
					System.out.println("loop0 : " + LtorMt + " $s0,$s1" + ",loop1");
					System.out.println("\tj out");

				}
				if (line.contains("+")) {
					AorS = "add";
				} else if (line.contains("-")) {
					AorS = "sub";
				}

				if (line.contains("a") && line.contains("b") && line.contains("c")) {
					System.out.println("loop1 : " + AorS + " $s0,$s1,$s2");
					System.out.println("\tsw $s0,a");
				}

			}
			System.out.println("\tj loop0");
			System.out.println("out : ...");
			br.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
