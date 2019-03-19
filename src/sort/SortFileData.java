package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortFileData {

	public static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"file.txt"));
			String lineStr = reader.readLine();
			ArrayList<Line> ar = new ArrayList<Line>();
			
			while (lineStr != null) {
				System.out.println(lineStr);
				String[] words = lineStr.split(" ");
				Line line = new Line(words.length, lineStr);
				ar.add(line);
				lineStr = reader.readLine();
			}
			
			Collections.sort(ar, new SortbyWords()); 
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			for(Line line : ar)	{
				writer.write(line.getLine());
				writer.newLine();
				System.out.println(line.getLine());
			}
			
			writer.flush();
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Line {
	
	private int wordCount;
	private String line;
	
	public Line(int wordCount, String line)	{
		this.wordCount = wordCount;
		this.line = line;
	}
	
	public int getWordCount() {
		return wordCount;
	}
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
}

class SortbyWords implements Comparator<Line> {
    public int compare(Line a, Line b) {
        return b.getWordCount() - a.getWordCount(); 
    } 
} 








