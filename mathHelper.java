import java.util.*;
import javax.swing.*;

public class mathHelper{//This program is a math tutor for children to practice basic arithmatic.
	public static void main(String[] args){
		String name, input;
		int math, level, score=0;
		int[] markA=new int[3];//Here, we're opening 4 arrays to store the marks of each excercise done.
		int[] markS=new int[3];
		int[] markM=new int[3];
		int[] markD=new int[3];
		boolean cont=true;
		name=JOptionPane.showInputDialog("Hello! This is your friendly Math Tutor. What is your name?");
		while(cont){
			math=Integer.parseInt(JOptionPane.showInputDialog("Hello "+name+"! What would you like to work on today? \nPlease type 1 for Additon, 2 for Subtraction, 3 for Multiplication or 4 for Division."));
			level=Integer.parseInt(JOptionPane.showInputDialog("Please select a difficulty:\nLevel 1 - Numbers between 0 and 10.\nLevel 2 - Numbers between 0 and 25.\nLevel 3 - Numbers between 0 and 50."));
			if(level>3||level<1){
				JOptionPane.showMessageDialog(null,"The number you entered is not a valid number. Please restart this program.");
				System.exit(0);
			}
			if(math==1){
				score=addQ(name, level);
				if(level==1)
					markA[0]=score;
				else if(level==2)
					markA[1]=score;
				else if(level==3)
					markA[2]=score;
			}
			else if(math==2){
				score=subQ(name, level);
				if(level==1)
					markS[0]=score;
				else if(level==2)
					markS[1]=score;
				else if(level==3)
					markS[2]=score;
			}
			else if(math==3){
				score=mulQ(name, level);
				if(level==1)
					markM[0]=score;
				else if(level==2)
					markM[1]=score;
				else if(level==3)
					markM[2]=score;
			}
			else if(math==4){
				score=divQ(name, level);
				if(level==1)
					markD[0]=score;
				else if(level==2)
					markD[1]=score;
				else if(level==3)
					markD[2]=score;
			}
			else{
				JOptionPane.showMessageDialog(null,"The number you entered is not a valid number. Please restart this program.");
				System.exit(0);
			}
			scoreCalc(score, level);
			input=JOptionPane.showInputDialog("Would you like to see your grades?\nType Yes or No.");
			if(input.equals("Yes")||input.equals("yes")){
				for(int i=0;i<markA.length;i++){
					int j=i+1;
					JOptionPane.showMessageDialog(null,"For Addition level "+j+", you got "+markA[i]);
				}
				for(int i=0;i<markS.length;i++){
					int j=i+1;
					JOptionPane.showMessageDialog(null,"For Subtraction level "+j+", you got "+markS[i]);
				}
				for(int i=0;i<markM.length;i++){
					int j=i+1;
					JOptionPane.showMessageDialog(null,"For Multiplication level "+j+", you got "+markM[i]);
				}
				for(int i=0;i<markD.length;i++){
					int j=i+1;
					JOptionPane.showMessageDialog(null,"For Division level "+j+", you got "+markD[i]);
				}
         }
			input=JOptionPane.showInputDialog("Would you like to continue?\nType Yes or No.");
			if(input.equals("No")||input.equals("no")){
				JOptionPane.showMessageDialog(null,"Thank you "+name+" for using this Math Tutor, Goodbye!");
				cont=false;
			}
		}
		System.exit(0);
	}
	
	public static void scoreCalc(int score, int l){//This method prints the score out of 10 and a message.
		if(score>=8&&l==3)
			JOptionPane.showMessageDialog(null,"You got "+score+" out of 10. Good job! Try a different excercise!");
		else if(score>=8&&l<3)
			JOptionPane.showMessageDialog(null,"You got "+score+" out of 10. Good job! Try the next level!");
		else if(score<8&&score>5)
			JOptionPane.showMessageDialog(null,"You got "+score+" out of 10. You should probably try again.");
		else if(score<5&&l>1)
			JOptionPane.showMessageDialog(null,"You got "+score+" out of 10. Please try a lower level.");
		else if(score<5&&l==1)
			JOptionPane.showMessageDialog(null,"You got "+score+" out of 10. Please look for help.");
	}
	
	public static int addQ(String n, int l){//This method produces 10 addition questions at random.
		JOptionPane.showMessageDialog(null,"You have chosen level "+l+"\nGood Luck!");
		Random rn=new Random();
		int ans, score=0, num1, num2, max=0;
		if(l==1)
			max=10;
		else if(l==2)
			max=25;
		else if(l==3)
			max=50;
		for(int i=1;i<=10;i++){
			num1=rn.nextInt(max)+1;
			num2=rn.nextInt(max)+1;
			ans=Integer.parseInt(JOptionPane.showInputDialog("What is "+num1+" + "+num2+" ?"));
			if(ans==(num1+num2)){
				JOptionPane.showMessageDialog(null,"Correct!");
				score++;
			}
			else
				JOptionPane.showMessageDialog(null,"Sorry! That is incorrect. "+num1+" + "+num2+" = "+(num1+num2)+".");
		}
		return score;
	}
	
	public static int subQ(String n, int l){//This method produces 10 subtraction questions at random.
		JOptionPane.showMessageDialog(null,"You have chosen level "+l+"\nGood Luck!");
		Random rn=new Random();
		int ans, score=0, num1, num2, max=0;
		if(l==1)
			max=10;
		else if(l==2)
			max=25;
		else if(l==3)
			max=50;
		for(int i=1;i<=10;i++){
			num1=rn.nextInt(max)+1;
			num2=rn.nextInt(max)+1;
			ans=Integer.parseInt(JOptionPane.showInputDialog("What is "+num1+" - "+num2+" ?"));
			if(ans==(num1-num2)){
				JOptionPane.showMessageDialog(null,"Correct!");
				score++;
			}
			else
				JOptionPane.showMessageDialog(null,"Sorry! That is incorrect. "+num1+" - "+num2+" = "+(num1-num2)+".");
		}
		return score;
	}	
	
	public static int mulQ(String n, int l){//This method produces 10 multiplication questions at random.
		JOptionPane.showMessageDialog(null,"You have chosen level "+l+"\nGood Luck!");
		Random rn=new Random();
		int ans, score=0, num1, num2, max=0;
		if(l==1)
			max=10;
		else if(l==2)
			max=25;
		else if(l==3){
			max=50;
			JOptionPane.showMessageDialog(null,"You may want to have a pen and paper handy.");
		}
		for(int i=1;i<=10;i++){
			num1=rn.nextInt(max)+1;
			num2=rn.nextInt(max)+1;
			ans=Integer.parseInt(JOptionPane.showInputDialog("What is "+num1+" x "+num2+" ?"));
			if(ans==(num1*num2)){
				JOptionPane.showMessageDialog(null,"Correct!");
				score++;
			}
			else
				JOptionPane.showMessageDialog(null,"Sorry! That is incorrect. "+num1+" x "+num2+" = "+(num1*num2)+".");
		}
		return score;
	}	
	
	public static int divQ(String n, int l){//This method produces 10 division questions at random.
		JOptionPane.showMessageDialog(null,"You have chosen level "+l+"\nGood Luck!");
		Random rn=new Random();
		int ans, score=0, num1, num2, max=0;
		if(l==1)
			max=10;
		else if(l==2)
			max=25;
		else if(l==3){
			max=50;
			JOptionPane.showMessageDialog(null,"You may want to have a pen and paper handy.");
		}
		for(int i=1;i<=10;i++){
			num1=rn.nextInt(max)+1;
			num2=rn.nextInt(max)+1;
			if(num1%num2!=0)
				i--;
			else{
			ans=Integer.parseInt(JOptionPane.showInputDialog("What is "+num1+" / "+num2+" ?"));		
			if(ans==(num1/num2)){
				JOptionPane.showMessageDialog(null,"Correct!");
				score++;
			}
			else
				JOptionPane.showMessageDialog(null,"Sorry! That is incorrect. "+num1+" / "+num2+" = "+(num1/num2)+".");
			}
		}
		return score;
	}	
}
		