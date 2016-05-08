import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Map extends JPanel {

	public static JButton button[][];
	public static JButton reset,get;
	public static JTextField label1,label2,label3;
	public static int lane1[] = new int[10];
	public static int lane2[] = new int[10];
	public static int lane3[] = new int[10];
	public static int size = 30;

	public Map() {
		
		for(int i=0;i<10;i++){
			lane1[i]=0;
			lane2[i]=0;
			lane3[i]=0;
		}

		// set flow layout for the frame
		setLayout(null);
		button = new JButton[20][10];
		
		
		int x=0,y=0;
		int btn = 0;
		for(int i=0;i<10;i++){
			for(int j=0;j<20;j++){
				button[j][i] = new JButton(""+btn);
				button[j][i].setBounds(x,y,size,size);
				button[j][i].setBackground(Color.GREEN);
				button[j][i].addActionListener(new ButtonListener());
				y+=size;
				add(button[j][i]);
				btn++;
			}
			y=0;
			x+=size;
		}
		
		reset = new JButton("reset");
		reset.setBounds(10,600,100,20);
		reset.addActionListener(new ControlButtons());
		add(reset);
		get = new JButton("get");
		get.setBounds(200,600,100,20);
		get.addActionListener(new ControlButtons());
		add(get);
		label1 = new JTextField("one");
		label1.setBounds(10,630,400,20);
		add(label1);
		label2 = new JTextField("two");
		label2.setBounds(10,650,400,20);
		add(label2);
		label3 = new JTextField("three");
		label3.setBounds(10,670,400,20);
		add(label3);
	}
	
	public static void reset(){
		for(int i=0;i<10;i++){
			lane1[i]=0;
			lane2[i]=0;
			lane3[i]=0;
		}
		int x=0,y=0;
		for(int i=0;i<10;i++){
			for(int j=0;j<20;j++){
				button[j][i].setBackground(Color.GREEN);
			}
			y=0;
			x+=size;
		}
		
	
	}

	

	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		frame.getContentPane().add(new Map());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 800);
		frame.setVisible(true);
    }

}



class ButtonListener implements ActionListener {
  ButtonListener() {
  }

  public void actionPerformed(ActionEvent e) {
    //if (e.getActionCommand().equals("Button1")) {
    //  System.out.println("Button1 has been clicked");
    //}
	
	int a = Integer.parseInt(e.getActionCommand());
	int col = a/20;
	int row = a%20;
	
	if(Map.button[row][col].getBackground()==Color.GREEN){
		if(row<8){
			Map.lane1[col] = Map.lane1[col]|(1<<row);
		}
		else if(row<16){
			Map.lane2[col] = Map.lane2[col]|(1<<(row%8));
		}
		else if(row<20){
			Map.lane3[col] = Map.lane3[col]|(1<<(row%8));
		}
		Map.button[row][col].setBackground(Color.RED);
	}
	
	else if(Map.button[row][col].getBackground()==Color.RED){
		if(row<8){
				Map.lane1[col] = Map.lane1[col]& ~(1<<row);
		}
		else if(row<16){
			Map.lane2[col] = Map.lane2[col]& ~(1<<(row%8));
		}
		else if(row<20){
			Map.lane3[col] = Map.lane3[col]& ~(1<<(row%8));
		}
		Map.button[row][col].setBackground(Color.GREEN);
	}
	
  }
}


class ControlButtons implements ActionListener{
	ControlButtons(){}
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("reset")) {
			System.out.println("System Reset");
			Map.reset();
		}
		else if(e.getActionCommand().equals("get")){
			String text1 = "",text2="",text3="";
			for(int i=0;i<10;i++){
				text1 = text1+"0x"+Integer.toHexString(Map.lane1[i]);
				text2 = text2+"0x"+Integer.toHexString(Map.lane2[i]);
				text3 = text3+"0x"+Integer.toHexString(Map.lane3[i]);
				if(i<9){
					text1+=",";
					text2+=",";
					text3+=",";
				}
			}
			Map.label1.setText("{"+text1+"}");
			Map.label2.setText("{"+text2+"}");
			Map.label3.setText("{"+text3+"}");
		}
	}
}