package gamepackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainGame extends JFrame implements ActionListener{

	static MainGame CurrentGame;
	
	private static final long serialVersionUID = -2027030840660932383L;
	final private static String gameTitle = "Memory Game by: gabanciano";
	final private int buttonArraySize = 16;
	
	private int correctCounter = 0;
	private int firstClickValue = -1;
	private int secondClickValue = -1;
 
	JButton ButtonSet[];
	JButton FirstRegisteredButton;
	JButton SecondRegisteredButton;
	ArrayList<JButton> BtnsList;
	
	Container GFContainer;
	
	private void InitFrameSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setTitle(gameTitle);
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 4));
		setVisible(true);
	}
	
	private void InitGameButtons() {
		ButtonSet = new JButton[buttonArraySize];
		BtnsList = new ArrayList<JButton>();
		for(int i=0;i<ButtonSet.length;i++) {
			ButtonSet[i] = new JButton("");
			ButtonSet[i].setBackground(Color.WHITE);
			BtnsList.add(ButtonSet[i]);
			ButtonSet[i].addActionListener(this);
		}
		Collections.shuffle(BtnsList);
		for(int i=0;i<ButtonSet.length;i++) {
			GFContainer.add((JButton)BtnsList.get(i));
			
		}
	}
	
	private Color InitButtonColors(int buttonIndex) {
		if(buttonIndex >= 0 && buttonIndex < 4) {
			return Color.red;
		} else if (buttonIndex >= 4 && buttonIndex < 8) {
			return Color.green;
		} else if (buttonIndex >= 8 && buttonIndex < 12) {
			return Color.blue;
		} else if (buttonIndex >= 12 && buttonIndex < 16) {
			return Color.yellow;
		}
		else {
			return Color.black;
		}
	}
	
	public MainGame() { 
		GFContainer = getContentPane();
		InitGameButtons();
		InitFrameSettings();
	}
	
	public static void main(String[] args) {
		CurrentGame = new MainGame();
	}

	@Override //Button Functions
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ButtonSet[0]) {// 0
			RegisterFirstBtnClicked(0);
			RegisterButton0(0);
			ChangeButtonColor(0);
		}
		if(event.getSource() == ButtonSet[1]) { 
			RegisterFirstBtnClicked(1);
			RegisterButton0(1);
			ChangeButtonColor(1);
		}
		if(event.getSource() == ButtonSet[2]) {
			RegisterFirstBtnClicked(2);
			RegisterButton0(2);
			ChangeButtonColor(2);
		}
		if(event.getSource() == ButtonSet[3]) {
			RegisterFirstBtnClicked(3);
			RegisterButton0(3);
			ChangeButtonColor(3);
		}
		if(event.getSource() == ButtonSet[4]) {// 1
			RegisterFirstBtnClicked(4);
			RegisterButton1(4);
			ChangeButtonColor(4);
		}
		if(event.getSource() == ButtonSet[5]) { 
			RegisterFirstBtnClicked(5);
			RegisterButton1(5);
			ChangeButtonColor(5);
		}
		if(event.getSource() == ButtonSet[6]) {
			RegisterFirstBtnClicked(6);
			RegisterButton1(6);
			ChangeButtonColor(6);
		}
		if(event.getSource() == ButtonSet[7]) {
			RegisterFirstBtnClicked(7);
			RegisterButton1(7);
			ChangeButtonColor(7);
		}
		if(event.getSource() == ButtonSet[8]) { // 2
			RegisterFirstBtnClicked(8);
			RegisterButton2(8);
			ChangeButtonColor(8);
		}
		if(event.getSource() == ButtonSet[9]) { 
			RegisterFirstBtnClicked(9);
			RegisterButton2(9);
			ChangeButtonColor(9);
		}
		if(event.getSource() == ButtonSet[10]) {
			RegisterFirstBtnClicked(10);
			RegisterButton2(10);
			ChangeButtonColor(10);
		}
		if(event.getSource() == ButtonSet[11]) {
			RegisterFirstBtnClicked(11);
			RegisterButton2(11);
			ChangeButtonColor(11);
		}
		if(event.getSource() == ButtonSet[12]) { // 3
			RegisterFirstBtnClicked(12);
			RegisterButton3(12);
			ChangeButtonColor(12);
		}
		if(event.getSource() == ButtonSet[13]) {
			RegisterFirstBtnClicked(13);
			RegisterButton3(13);
			ChangeButtonColor(13);
		}
		if(event.getSource() == ButtonSet[14]) {
			RegisterFirstBtnClicked(14);
			RegisterButton3(14);
			ChangeButtonColor(14);
		}
		if(event.getSource() == ButtonSet[15]) {
			RegisterFirstBtnClicked(15);
			RegisterButton3(15);
			ChangeButtonColor(15);
		}
	}
	
	public void RegisterFirstBtnClicked(int buttonIndex) {
		if(firstClickValue == -1) {
			FirstRegisteredButton = ButtonSet[buttonIndex];
		} else if (firstClickValue != -1) {
			if(secondClickValue == -1) {
				SecondRegisteredButton = ButtonSet[buttonIndex];
			}
		}
	}
	
	public void ChangeButtonColor(int buttonIndex) {
		if(firstClickValue != -1) {
			ButtonSet[buttonIndex].setBackground(InitButtonColors(buttonIndex));
			ButtonSet[buttonIndex].setOpaque(true);
		} 
	}
	
	public void RegisterButton0(int buttonIndex) {
		ButtonSet[buttonIndex].setEnabled(false);
		if(firstClickValue != -1) {
			secondClickValue = 0;
		} else if (firstClickValue == -1) {
			firstClickValue = 0;
		}
		if(firstClickValue != -1 && secondClickValue != -1) {
			boolean result = CompareValues(firstClickValue, secondClickValue);
			if(result) {
				ButtonSet[buttonIndex].setEnabled(false);
				FirstRegisteredButton.setBackground(InitButtonColors(buttonIndex));
				ChangeButtonColor(buttonIndex);
				ShowPlayAgainDialogBox();
			} else {
				ButtonSet[buttonIndex].setEnabled(true);
				FirstRegisteredButton.setEnabled(true);
				FirstRegisteredButton.setBackground(Color.WHITE);
			}
			firstClickValue = -1;
			secondClickValue = -1;
		} 
	}
	public void RegisterButton1(int buttonIndex) {
		ButtonSet[buttonIndex].setEnabled(false);
		if(firstClickValue != -1) {
			secondClickValue = 1;
		} else if (firstClickValue == -1) {
			firstClickValue = 1;
		}
		if(firstClickValue != -1 && secondClickValue != -1) {
			boolean result = CompareValues(firstClickValue, secondClickValue);
			if(result) {
				ButtonSet[buttonIndex].setEnabled(false);
				FirstRegisteredButton.setBackground(InitButtonColors(buttonIndex));
				ChangeButtonColor(buttonIndex);
				ShowPlayAgainDialogBox();
			} else {
				ButtonSet[buttonIndex].setEnabled(true);
				FirstRegisteredButton.setEnabled(true);
				FirstRegisteredButton.setBackground(Color.WHITE);
			}
			firstClickValue = -1;
			secondClickValue = -1;
		} 
	}
	public void RegisterButton2(int buttonIndex) {
		ButtonSet[buttonIndex].setEnabled(false);
		if(firstClickValue != -1) {
			secondClickValue = 2;
		} else if (firstClickValue == -1) {
			firstClickValue = 2;
		}
		if(firstClickValue != -1 && secondClickValue != -1) {
			boolean result = CompareValues(firstClickValue, secondClickValue);
			if(result) {
				ButtonSet[buttonIndex].setEnabled(false);
				FirstRegisteredButton.setBackground(InitButtonColors(buttonIndex));
				ChangeButtonColor(buttonIndex);
				ShowPlayAgainDialogBox();
			} else {
				ButtonSet[buttonIndex].setEnabled(true);
				FirstRegisteredButton.setEnabled(true);
				FirstRegisteredButton.setBackground(Color.WHITE);
			}
			firstClickValue = -1;
			secondClickValue = -1;
		} 
	}
	public void RegisterButton3(int buttonIndex) {
		ButtonSet[buttonIndex].setEnabled(false);
		if(firstClickValue != -1) {
			secondClickValue = 3;
		} else if (firstClickValue == -1) {
			firstClickValue = 3;
		}
		if(firstClickValue != -1 && secondClickValue != -1) {
			boolean result = CompareValues(firstClickValue, secondClickValue);
			if(result) {
				ButtonSet[buttonIndex].setEnabled(false);
				FirstRegisteredButton.setBackground(InitButtonColors(buttonIndex));
				ChangeButtonColor(buttonIndex);
				ShowPlayAgainDialogBox();
			} else {
				ButtonSet[buttonIndex].setEnabled(true);
				FirstRegisteredButton.setEnabled(true);
				FirstRegisteredButton.setBackground(Color.WHITE);
			}
			firstClickValue = -1;
			secondClickValue = -1;
		} 
	}
	
	public void ShowPlayAgainDialogBox() {
		correctCounter++;
		if(correctCounter >= 8) {
			int playerChoice = JOptionPane.showConfirmDialog(this, "Congratulation! You won the game!\nStart a new game?","Memory Game",JOptionPane.YES_NO_OPTION);
			if(playerChoice == JOptionPane.YES_OPTION) {
				CurrentGame.setVisible(false);
				CurrentGame = new MainGame();
			} else if (playerChoice == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}
	}
	
	public boolean CompareValues(int value1, int value2) {
		if(value1 == value2) {
			return true;
		} else if (value1 != value2) {
			return false;
		} else {
			return false;
		}
	}
}
