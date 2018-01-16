
package mycalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Rita
 */

public class MyCalculator extends JFrame implements ActionListener
{
    final static int w=350;
    final static int h=550;
    final static Font font=new Font("Helvetica",Font.BOLD+Font.ITALIC,15);
    final static Font myFont=new Font("MONOSPACE",Font.BOLD+Font.PLAIN,15);
    final static Color cc=Color.WHITE;
    static boolean b=true;
    boolean clear=false;
    ArrayList<String> signs=new ArrayList<>();
    ArrayList<String> numbers1=new ArrayList<>();
    ArrayList<String> numbers2=new ArrayList<>();
    ArrayList<String> result=new ArrayList<>();
    JPanel containerpanel=new JPanel();
        JPanel northpanel=new JPanel();
            JTextArea txtarea=new JTextArea(5,30);
            
        JPanel centerpanel=new JPanel();
            JPanel toppanel=new JPanel();
                JButton btnreset=new JButton("Reset");
                JButton btnon=new JButton("Off/On");
            JPanel buttonpanel=new JPanel();
                JPanel numberpanel=new JPanel();
                    JButton btn1=new JButton("1");JButton btn2=new JButton("2");JButton btn3=new JButton("3");
                    JButton btn4=new JButton("4");JButton btn5=new JButton("5");JButton btn6=new JButton("6");
                    JButton btn7=new JButton("7");JButton btn8=new JButton("8");JButton btn9=new JButton("9");
                    JButton btn0=new JButton("0");JButton btnpoint=new JButton(".");
                JPanel signspanel=new JPanel();
                    JButton btnadd=new JButton("+");JButton btnminus=new JButton("-");JButton btnmultiply=new JButton("*");
                    JButton btndivide=new JButton("/");JButton btndel=new JButton("Del");JButton btnequals=new JButton("=");
    
    public MyCalculator()
    {
        setSize(w,h);
        setTitle("My Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        add(containerpanel,"Center");
        
        containerpanel.setLayout(new BorderLayout());
        containerpanel.add(northpanel,"North");
        containerpanel.add(centerpanel,"Center");
            northpanel.setLayout(new BorderLayout());
            northpanel.add(txtarea,"Center");
            txtarea.setLineWrap(true);
            txtarea.setEditable(false);
            txtarea.setBackground(cc);
            txtarea.setFont(myFont);
         centerpanel.setLayout(new BorderLayout());
         centerpanel.add(toppanel,"North");
         centerpanel.add(buttonpanel,"Center");
            toppanel.setLayout(new GridLayout(1,3,5,5));
            toppanel.add(new JLabel(""));toppanel.add(new JLabel());
            toppanel.add(btnreset);toppanel.add(btnon);
                     btnreset.setFont(font);
                    btnon.setFont(font);
            btnreset.addActionListener(this);
            btnon.addActionListener(this);
            
            buttonpanel.setLayout(new BorderLayout());
            buttonpanel.add(numberpanel,BorderLayout.CENTER);
            buttonpanel.add(signspanel,BorderLayout.EAST);
            
            numberpanel.setLayout(new GridLayout(4,3,20,20));
            numberpanel.add(btn7);numberpanel.add(btn8);numberpanel.add(btn9);
            numberpanel.add(btn4);numberpanel.add(btn5);numberpanel.add(btn6);
            numberpanel.add(btn1);numberpanel.add(btn2);numberpanel.add(btn3);
            numberpanel.add(btn0);numberpanel.add(btnpoint);
            btn1.addActionListener(this);
            btn2.addActionListener(this);
            btn3.addActionListener(this);
            btn4.addActionListener(this);
            btn5.addActionListener(this);
            btn6.addActionListener(this);
            btn7.addActionListener(this);
            btn8.addActionListener(this);
            btn9.addActionListener(this);
            btn0.addActionListener(this);
            btnpoint.addActionListener(this);
            
            signspanel.setLayout(new GridLayout(4,2,5,45));
            signspanel.setBorder(new TitledBorder(""));
            signspanel.add(btnadd);signspanel.add(btnminus);
            signspanel.add(btnmultiply);signspanel.add(btndivide);
            signspanel.add(new JLabel());signspanel.add(new JLabel());
            signspanel.add(btndel);signspanel.add(btnequals);
            btnadd.addActionListener(this);
            btnminus.addActionListener(this);
            btnmultiply.addActionListener(this);
            btndivide.addActionListener(this);
            btndel.addActionListener(this);
            btnequals.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String action=evt.getActionCommand();
            if(action.equals("Off/On"))
            {
              on_off();
            }
            else if(action.equals("Reset"))
            {
                txtarea.setText("");
                reset();
            }
            else if(action.equals("1") || action.equals("2")|| action.equals("3"))
            {
                buttonsClicked(action);
            }
            else if(action.equals("4") || action.equals("5")|| action.equals("6"))
            {
                buttonsClicked(action);
            }
            else if(action.equals("7") || action.equals("8")|| action.equals("9"))
            {
                buttonsClicked(action);
            }
            else if(action.equals("+") || action.equals("-")|| action.equals("/") || action.equals("*"))
            {
                signClicked(action);
            }
            else if( action.equals(".") || action.equals("0"))
            {
               buttonsClicked(action);
            }
            else if(action.equals("Del"))
            {
               String d=del(txtarea.getText().trim()); 
               txtarea.setText(d);
            }
            else if(action.equals("="))
            {
                String n=txtarea.getText().trim();
                signClicked(action);
               
              //  sum();
            }
    }
    public void signClicked(String n)
    {
        String j=txtarea.getText();
        int k=j.length();
        String is=j.substring(k);
        if(j.equals(""))
        {
            
        }
         else if(is.equals("+") &&(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") )){
             
         }
         else if(is.equals("-") &&(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") )){
             
         }
         else if(is.equals("*") &&(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") )){
             
         }
         else if(is.equals("/") &&(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") )){
             
         }
        else if(numbers1.size()==0){
      String quiz=txtarea.getText();
      
      numbers1.add(quiz);
     
      signs.add(n);
      
      txtarea.setText(quiz+n);
      
      result.add(quiz+n);
        }
        else{
            
            String quiz2=txtarea.getText();
            
            String quizcomp=result.get(0);
            
            int quizcompl=quizcomp.length();
            
            String d=quiz2.substring(quizcompl);
            
            numbers1.add(d);
         
            signs.add(n);
            
           
            result.set(0, quiz2+n);
            
            txtarea.setText(quiz2+n);
            if(n.equals("="))
            {
                sum();
            }
        }
       
    }
    public void buttonsClicked(String n)
    {
            if(clear)
            {
                txtarea.setText("");
                String v=txtarea.getText()+n;
            txtarea.setText(v); 
            clear=false;
            }
            else{
                String v=txtarea.getText()+n;
            txtarea.setText(v); 
            }
    }
    public String del(String k){
        int n=k.length();
        String newstring="";
        if(n!=0)
        {
             newstring=k.substring(0, (n-1)); 
        }
        return newstring;
    }
    
    public void on_off()
    {
        if(b)
        {
            b=false;reset();
            txtarea.setText("SHUTING DOWN...\nSTATUS: OFF");
            disable_enable(b);
        }
        else{
            b=true;
            txtarea.setText("STARTING UP...\nSTATUS: ON");
            Thread t=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                    txtarea.setText("");
                }catch(Exception ex){
                    
                }
            }
            });t.start();
            
            disable_enable(b);
        }
    }
    public void disable_enable(boolean b){
       btn1.setEnabled(b);btn2.setEnabled(b);btn3.setEnabled(b);btn4.setEnabled(b);btn5.setEnabled(b);
       btn5.setEnabled(b);btn6.setEnabled(b);btn7.setEnabled(b);btn8.setEnabled(b);btn9.setEnabled(b);
       btn0.setEnabled(b);btnpoint.setEnabled(b);btnreset.setEnabled(b);btnadd.setEnabled(b);btnminus.setEnabled(b);
       btnmultiply.setEnabled(b);btndivide.setEnabled(b);btndel.setEnabled(b);btnequals.setEnabled(b);
    }
   
    public static void main(String [] args)
    {
      try{
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            MyCalculator m=new MyCalculator();
           m.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void reset(){
      //  txtarea.setText("");
        numbers1.clear();
        signs.clear();
        result.clear();
        numbers2.clear();
    }
     public void sum()
    {
      if(numbers1.size()<2){
          JOptionPane.showMessageDialog(null,"Please enter at least a number, sign and number to calculate","FORMAT ERROR",JOptionPane.WARNING_MESSAGE);
//       JOptionPane.showMessageDialog(null,"Signs "+signs.toString());
      }
        else
        {
            while(numbers1.size()!=1){
            double d1=Double.parseDouble(numbers1.get(0));
            double d2=Double.parseDouble(numbers1.get(1));
            double d3;
            String operand=signs.get(0);
            if(operand.equals("+"))
            {
                d3=d1+d2;
            }else if(operand.equals("-"))
            {
                d3=d1-d2;
            }
            else if(operand.equals("/"))
            {
                d3=d1/d2;
            }
            else{
                d3=d1*d2;
            }
            numbers1.remove(0);
            String d3s=d3+"";
            numbers1.set(0, d3s);
            signs.remove(0);
        }
        txtarea.setText(result.get(0)+"\n"+numbers1.get(0));
        
      reset();
      clear=true;
        }
    }
    
}

