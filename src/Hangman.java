import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Hangman implements KeyListener{
	
	public static void main(String[] args) {
		Hangman h = new Hangman();
		
	}
	
	String popped = "";
	String theString =  "";
	Hangman()
	{
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setVisible(true);
		panel.add(label);
		
		
		Stack<String> stack = new Stack<String>();
		ArrayList<String> words = new ArrayList<String>();
		String ans = JOptionPane.showInputDialog("How many words?");
		int num = Integer.parseInt(ans);
		FileReader fr;

		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/league/Desktop/Hangman/src/dictionary.txt"));
			String line = br.readLine();
			
			for(int i = 0; i < num; i++)
			{
				br.mark(1000000);
				int rand = (int) (Math.random()*2999);
				for(int j = 0; j < rand; j++)
				{
					br.readLine();
				}
				words.add(br.readLine());
				br.reset();
			}
			
			for (int i = 0; i < words.size(); i++) {
				stack.push(words.get(i));
			}
			
			for(int i = 0; i < num; i++)
			{
			String currentword = stack.pop();
			popped = currentword;
			theString = dashes(popped);
			System.out.println(popped);
			label.setText(theString);
			//frame.requestFocus();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public String dashes(String s)
	{
		String x = "";
		for (int i = 0; i < s.length(); i++) {
			x+="_";
		}
		return x;
		
	}
	public String newString(char key,String lastWord,int num)
	{
		System.out.println(lastWord.substring(0, num));
		System.out.println(lastWord.substring(num+1,lastWord.length()));
		String x = lastWord.substring(num) + key +lastWord.substring(num+1,lastWord.length());
		
		return x;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(theString);
		char key = e.getKeyChar(); 
		String temp = "";
		for (int i = 0; i < popped.length(); i++) {
			if(popped.charAt(i) == key) {
				temp+=popped.charAt(i);
				
			}
			else
			{
				temp+=theString.charAt(i);
			}
			
		}
		theString = temp;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
