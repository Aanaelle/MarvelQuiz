import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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


        //création des labels
        this.lblA.setBounds(125, 100, 500, 100);
        this.lblA.setBackground(new Color(50,50,50));
        this.lblA.setForeground(new Color(45,21,140));
        this.lblA.setFont(new Font("MV Boli", Font.PLAIN, 35 ));


        this.lblB.setBounds(125, 200, 500, 100);
        this.lblB.setBackground(new Color(50,50,50));
        this.lblB.setForeground(new Color(45,21,140));
        this.lblB.setFont(new Font("MV Boli", Font.PLAIN, 35 ));

        this.lblC.setBounds(125, 300, 500, 100);
        this.lblC.setBackground(new Color(50,50,50));
        this.lblC.setForeground(new Color(45,21,140));
        this.lblC.setFont(new Font("MV Boli", Font.PLAIN, 35 ));

        this.lblD.setBounds(125, 400, 500, 100);
        this.lblD.setBackground(new Color(50,50,50));
        this.lblD.setForeground(new Color(45,21,140));
        this.lblD.setFont(new Font("MV Boli", Font.PLAIN, 35 ));

        //timer
        this.lblSec.setBounds(535,510,100,100);
        this.lblSec.setBackground(new Color(25,25,25));
        this.lblSec.setForeground(new Color(255,10,10));
        this.lblSec.setFont(new Font("Times New Roman", Font.BOLD, 60));
        this.lblSec.setBorder(BorderFactory.createBevelBorder(1));
        this.lblSec.setOpaque(true);
        this.lblSec.setHorizontalAlignment(JTextField.CENTER);
        this.lblSec.setText(String.valueOf(this.seconds));


        //label temps
        this.lblTime.setBounds(535,475,100,25);
        this.lblTime.setBackground(new Color(50,50,50));
        this.lblTime.setForeground(new Color(255,150,23));
        this.lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.lblTime.setHorizontalAlignment(JTextField.CENTER);
        this.lblTime.setText("timer");

        //label réponse corrects
        this.nbRight.setBounds(225,225,200,100);
        this.nbRight.setBackground(new Color(25,25,25));
        this.nbRight.setForeground(new Color(25,255,150));
        this.nbRight.setFont(new Font("Ink Free", Font.BOLD, 50));
        this.nbRight.setBorder(BorderFactory.createBevelBorder(1));
        this.nbRight.setHorizontalAlignment(JTextField.CENTER);
        this.nbRight.setEditable(false);
        
        //label pourcentage
        this.pourcent.setBounds(225,325,200,100);
        this.pourcent.setBackground(new Color(25,25,25));
        this.pourcent.setForeground(new Color(25,255,150));
        this.pourcent.setFont(new Font("Ink Free", Font.BOLD, 50));
        this.pourcent.setBorder(BorderFactory.createBevelBorder(1));
        this.pourcent.setHorizontalAlignment(JTextField.CENTER);
        this.pourcent.setEditable(false);


        //positionnement des composants
        this.frame.add(this.lblTime);
        this.frame.add(this.lblSec);

        this.frame.add(this.lblA);
        this.frame.add(this.lblB);
        this.frame.add(this.lblC);
        this.frame.add(this.lblD);

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
