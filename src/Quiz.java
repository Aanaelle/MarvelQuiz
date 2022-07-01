import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener
{
    private String[]   questions = {
                                    "Quelle pierre se trouve sur Vision ?",
                                    "De qui Loki est-il le frere ?",
                                    "Comment s'appelle la planete de Thor ?",
                                    "Dans quelle team se trouve Black Widow(Natasha) ?"
                                   };
    private String[][] options   = {
                                    {"Temps", "Esprit", "Realite", "Espace" },
                                    {"Tony Stark", "Clint Barton", "Thor", "Heimdall"},
                                    {"Asgard", "Sakaar", "Terre", "Xandar"},
                                    {"Iron Man", "Captain America", "Les deux", "Aucune"}
                                   };
    private char[]     answers = {
                                'B', 
                                'C', 
                                'A',
                                'C'
                                 };
    private char guess;
    private char answer;
    private int  index;
    private int  correctGuesses = 0;
    private int  totalQuestions = questions.length;
    private int  result;
    private int  seconds=10;

    private JFrame     frame    = new JFrame();
    private JTextField txtfield = new JTextField();
    private JTextArea  txtArea  = new JTextArea();

    private JButton    btnA     = new JButton("A");
    private JButton    btnB     = new JButton("B");
    private JButton    btnC     = new JButton("C");
    private JButton    btnD     = new JButton("D");

    private JLabel     lblA     = new JLabel();
    private JLabel     lblB     = new JLabel();
    private JLabel     lblC     = new JLabel();
    private JLabel     lblD     = new JLabel();

    private JLabel     lblTime  = new JLabel();
    private JLabel     lblSec   = new JLabel();

    private JTextField nbRight  = new JTextField();
    private JTextField pourcent = new JTextField();


    public Quiz()
    {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(650,650);
        this.frame.getContentPane().setBackground(new Color(50,50,50));
        this.frame.setLayout(null);
        this.frame.setResizable(false);

        
        //création textfield
        this.txtfield.setBounds(0,0,650,50);
        this.txtfield.setBackground(new Color(25,25,25));
        this.txtfield.setForeground(new Color(150,200,200));
        this.txtfield.setFont(new Font("Ink Free", Font.PLAIN, 30));
        this.txtfield.setBorder(BorderFactory.createBevelBorder(1));
        this.txtfield.setHorizontalAlignment(JTextField.CENTER);
        this.txtfield.setEditable(false);

        //création textArea
        this.txtArea.setBounds(0,50,650,50);
        this.txtArea.setLineWrap(true);
        this.txtArea.setWrapStyleWord(true);
        this.txtArea.setBackground(new Color(25,25,25));
        this.txtArea.setForeground(new Color(150,200,200));
        this.txtArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.txtArea.setBorder(BorderFactory.createBevelBorder(1));
        this.txtArea.setEditable(false);


        //création des boutons
        this.btnA.setBounds(0, 100, 100,100);
        this.btnA.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnA.setFocusable(false);
        this.btnA.addActionListener(this);

        this.btnB.setBounds(0, 200, 100,100);
        this.btnB.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnB.setFocusable(false);
        this.btnB.addActionListener(this);

        this.btnC.setBounds(0, 300, 100,100);
        this.btnC.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnC.setFocusable(false);
        this.btnC.addActionListener(this);

        this.btnD.setBounds(0, 400, 100,100);
        this.btnD.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnD.setFocusable(false);
        this.btnD.addActionListener(this);

        
        this.frame.add(this.btnA);
        this.frame.add(this.btnB);
        this.frame.add(this.btnC);
        this.frame.add(this.btnD);
        this.frame.add(this.txtArea);
        this.frame.add(this.txtfield);
        this.frame.setVisible(true);
    }

    public void nextQuestion()
    {

    }

    public void displayAnswer()
    {

    }

    public void results()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }


}
