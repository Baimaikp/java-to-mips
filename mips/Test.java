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
		String[] $s = { "$s0", "$s1", "$s2", "$s4","$s5","$s6","$s7","$s8","$s9" };
		int value = 0;

		String path = "C:\\Users\\thawatkrit\\Desktop\\mips.txt";
		File file = new File(path);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("int")) {
					
					System.out.printf("\tlw %s,\n", $s[value]);
					value++;
					
				}
				if (line.startsWith("while") == true) {
					
					for (int i = 1; i < line.length() - 1; i++) {
						if ((line.charAt(i) == '>')) {
							LtorMt = "bgt";
						} else if ((line.charAt(i) == '<')) {
							LtorMt = "blt";
						}
					}
					System.out.printf("loop0 : " + LtorMt + " %s,%s",$s[value],$s[value] + ",loop1\n");
					System.out.println("\tj out");

				}
				if (line.contains("+")) {
					AorS = "add";
				} else if (line.contains("-")) {
					AorS = "sub";
				}

				if (line.contains("=") && (line.contains("+") || line.contains("-"))) {
					System.out.printf("loop1 : " + AorS + " %s,%s,%s\n",$s[value],$s[value],$s[value]);
					System.out.printf("\tsw %s,\n",$s[value]);
				}

			}
			System.out.println("\tj loop0");
			System.out.println("out : ...");
			br.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private static String charAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
