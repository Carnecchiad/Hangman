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
	
	Hangman()
	{
	
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		frame.add(panel);
		
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
			System.out.println(popped);
			label.setText(dashes(popped));
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


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
		int key = e.getKeyChar();
		System.err.println(key);
		for (int i = 0; i < popped.length(); i++) {
			if(popped.charAt(i) == key) {
				System.out.println("e");
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
