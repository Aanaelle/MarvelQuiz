//@author Anaëlle Mimifir
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener
{
    private String[]   questions = {
                                    "Quelle pierre se trouve sur Vision ?",
                                    "De qui Loki est-il le frere ?",
                                    "Comment s'appelle la planete de Thor ?",
                                    "Dans quelle team se trouve Black Widow(Natasha) ?",
                                    "Comment se nomme le marteau de Thor ?",
                                    "De quelle couleur est Gamora ?"
                                   };

    private String[][] options   = {
                                    {"Temps", "Esprit", "Realite", "Espace" },
                                    {"Tony Stark", "Clint Barton", "Thor", "Heimdall"},
                                    {"Asgard", "Sakaar", "Terre", "Xandar"},
                                    {"Iron Man", "Captain America", "Les deux", "Aucune"},
                                    {"Mjölnir", "MewMew", "Jonathan", "Miljonir"},
                                    {"Jaune", "Bleue", "Verte", "Violette"}
                                   };

    private char[]     answers = {
                                'B', 
                                'C', 
                                'A',
                                'C',
                                'A',
                                'C'
                                 };

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

    private JLabel     lblSec   = new JLabel();

    private JTextField nbRight  = new JTextField();
    private JTextField pourcent = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            seconds--;
            lblSec.setText(String.valueOf(seconds));
            if (seconds <=0)
            {
                displayAnswer();
            }
        }
    });


    public Quiz()
    {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(650,650);
        this.frame.getContentPane().setBackground(new Color(242,244,244));
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
        this.btnA.setBackground(new Color(153,163,164));

        this.btnB.setBounds(0, 200, 100,100);
        this.btnB.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnB.setFocusable(false);
        this.btnB.addActionListener(this);
        this.btnB.setBackground(new Color(153,163,164));

        this.btnC.setBounds(0, 300, 100,100);
        this.btnC.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnC.setFocusable(false);
        this.btnC.addActionListener(this);
        this.btnC.setBackground(new Color(153,163,164));

        this.btnD.setBounds(0, 400, 100,100);
        this.btnD.setFont(new Font("MV Boli", Font.BOLD, 35));
        this.btnD.setFocusable(false);
        this.btnD.addActionListener(this);
        this.btnD.setBackground(new Color(153,163,164));


        //création des labels
        this.lblA.setBounds(125, 100, 500, 100);
        this.lblA.setBackground(new Color(242,244,244));
        this.lblA.setForeground(new Color(88,214,141));
        this.lblA.setFont(new Font("MV Boli", Font.PLAIN, 35 ));


        this.lblB.setBounds(125, 200, 500, 100);
        this.lblB.setBackground(new Color(242,244,244));
        this.lblB.setForeground(new Color(88,214,141));
        this.lblB.setFont(new Font("MV Boli", Font.PLAIN, 35 ));

        this.lblC.setBounds(125, 300, 500, 100);
        this.lblC.setBackground(new Color(242,244,244));
        this.lblC.setForeground(new Color(88,214,141));
        this.lblC.setFont(new Font("MV Boli", Font.PLAIN, 35 ));

        this.lblD.setBounds(125, 400, 500, 100);
        this.lblD.setBackground(new Color(242,244,244));;
        this.lblD.setForeground(new Color(88,214,141));
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

        this.nextQuestion();
    }

    public void nextQuestion()
    {
        if(this.index >= this.totalQuestions)
        {
            this.results();
        }
        else
        {
            this.txtfield.setText("Question " + (this.index+1));
            this.txtArea.setText(questions[this.index]);
            this.lblA.setText(options[index][0]);
            this.lblB.setText(options[index][1]);
            this.lblC.setText(options[index][2]);
            this.lblD.setText(options[index][3]);

            timer.start(); //lancement du timer à chaque quetions
        }
    }

    public void displayAnswer()
    {
        timer.stop(); // arrêt du timer

        this.btnA.setEnabled(false); 
        this.btnB.setEnabled(false);
        this.btnC.setEnabled(false);
        this.btnD.setEnabled(false);  

        if(this.answers[this.index] != 'A')
        {
            this.lblA.setForeground(new Color(255,20,0));
        }

        if(this.answers[this.index] != 'B')
        {
            this.lblB.setForeground(new Color(255,20,0));
        }

        if(this.answers[this.index] != 'C')
        {
            this.lblC.setForeground(new Color(255,20,0));
        }

        if(this.answers[this.index] != 'D')
        {
            this.lblD.setForeground(new Color(255,20,0));
        }

        Timer pause = new Timer(2000, new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                lblA.setForeground(new Color(88,214,141));
                lblB.setForeground(new Color(88,214,141));
                lblC.setForeground(new Color(88,214,141));
                lblD.setForeground(new Color(88,214,141));

                answer = ' ';
                seconds = 10;
                lblSec.setText(String.valueOf(seconds));

                btnA.setEnabled(true); 
                btnB.setEnabled(true);
                btnC.setEnabled(true);
                btnD.setEnabled(true);

                index++;
                nextQuestion();

            }
        });
        pause.setRepeats(false);
        pause.start(); 
    }

    public void results()
    {
        this.btnA.setEnabled(false); 
        this.btnB.setEnabled(false);
        this.btnC.setEnabled(false);
        this.btnD.setEnabled(false);

        this.result = (int)((this.correctGuesses/(double)this.totalQuestions)*100);

        this.txtfield.setText("RESULTATS!");
        this.txtArea.setText("");
        this.lblA.setText("");
        this.lblB.setText("");
        this.lblC.setText("");
        this.lblD.setText("");

        this.nbRight.setText("(" + this.correctGuesses + "/" + this.totalQuestions + ")");
        this.pourcent.setText(this.result + "%");

        this.frame.add(this.pourcent);
        this.frame.add(this.nbRight);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.btnA.setEnabled(false); 
        this.btnB.setEnabled(false);
        this.btnC.setEnabled(false);
        this.btnD.setEnabled(false);   

        if (e.getSource()==this.btnA)
        {
            this.answer='A';
            if(this.answer == this.answers[index])
            {
                this.correctGuesses++;
            }
        }

        if (e.getSource()==this.btnB)
        {
            this.answer='B';
            if(this.answer == this.answers[index])
            {
                this.correctGuesses++;
            }
        }

        if (e.getSource()==this.btnC)
        {
            this.answer='C';
            if(this.answer == this.answers[index])
            {
                this.correctGuesses++;
            }
        }

        if (e.getSource()==this.btnD)
        {
            this.answer='D';
            if(this.answer == this.answers[index])
            {
                this.correctGuesses++;
            }
        }

        this.displayAnswer();
        
    }


}
