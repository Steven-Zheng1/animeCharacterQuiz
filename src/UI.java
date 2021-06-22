import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    //question
    String question = "Who is this character?";
    //answer choices
    String[][] options = {
        {"Nero", "B", "C", "Arthur"},
        {"Gon", "Killua", "Ichigo", "Kazuma"}
    };

    //answer key
    char[] answer = {
            'A',
            'B'
    };

    char guess;
    char choice;
    int index;
    int correctGuesses = 0;
    int totalQuestion = answer.length;
    int result;
    int seconds = 30;

    //frame declaration
    JFrame frame = new JFrame();

    //cardLayout
    CardLayout layout = new CardLayout();

    //creating panel
    JPanel panelContainer = new JPanel();
    JPanel panelStart = new JPanel();
    JPanel panelInfo = new JPanel();
    JPanel panelQuiz = new JPanel();
    JPanel panelResult = new JPanel();
    JPanel panelDownload = new JPanel();

    //Start Button
    JButton buttonStart = new JButton();

    //Info button
    JButton buttonInfo = new JButton();

    // Main Screen Button
    JButton buttonQuizA = new JButton();
    JButton buttonQuizB = new JButton();
    JButton buttonQuizC = new JButton();
    JButton buttonQuizD = new JButton();

    //Labels options for buttons
    JLabel optionA = new JLabel();
    JLabel optionB = new JLabel();
    JLabel optionC = new JLabel();
    JLabel optionD = new JLabel();

    //Main Screen Button Textfields;
    JTextField textfield = new JTextField();

    //Text Area
    JTextArea textArea = new JTextArea();
    JTextArea infoText = new JTextArea();

    //Result Screen
    JButton buttonScore = new JButton();

    //Last Screen
    JButton buttonDownload = new JButton();

    public UI (){
        //basic frame declaration
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);

        //info text
        infoText.setBounds(100, 100, 900, 500);
        infoText.setLineWrap(true); //if the text go off the screen, it will move to next line
        infoText.setWrapStyleWord(true);
        infoText.setBackground(Color.RED);
        infoText.setForeground(new Color(25, 25, 25));
        infoText.setFont(new Font("Pixal Font", Font.BOLD, 30));
        infoText.setEditable(false);
        infoText.setText("1)GUESS THE ANIME CHARACTER IN THE PICTURE.\n2)YOU WILL HAVE 30 SECONDS EACH QUESTION.\n3)GOOD LUCK.");

        //setting of textfield properties for main screen
        textfield.setBounds(0,0,500,50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Pixal Font", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        //text area properties
        textArea.setBounds(0, 60, 500, 50);
        textArea.setLineWrap(true); //if the text go off the screen, it will move to next line
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("Pixal Font", Font.BOLD, 30));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        //setting of button properties
        buttonStart.setBounds(420, 500, 160, 80);
        buttonStart.setFont(new Font("Pixal Font", Font.BOLD, 30));
        buttonStart.setText("BEGIN");

        buttonInfo.setBounds(420,500,160,80);
        buttonInfo.setFont(new Font("Pixal Font", Font.BOLD, 30));
        buttonInfo.setText("START");

        //setting panel colors to identify panels
        panelStart.setBackground(Color.orange);
        panelInfo.setBackground(Color.red);
        panelQuiz.setBackground(Color.BLUE);

        //adding button to frame
        panelStart.add(buttonStart);
        panelInfo.add(buttonInfo);
        panelInfo.add(infoText);
        //main screen starts
        panelQuiz.add(textfield);
        panelQuiz.add(textArea);
        panelQuiz.add(buttonQuizA);
        panelQuiz.add(buttonQuizB);
        panelQuiz.add(buttonQuizC);
        panelQuiz.add(buttonQuizD);
        //end of main screen
        panelResult.add(buttonScore);
        panelDownload.add(buttonDownload);



        //setting card layout
        panelContainer.setLayout(layout);

        //disabling default layout
        panelStart.setLayout(null);
        panelInfo.setLayout(null);
        panelQuiz.setLayout(null);
        panelResult.setLayout(null);
        panelDownload.setLayout(null);

        panelContainer.add(panelStart, "1");
        panelContainer.add(panelInfo, "2");
        panelContainer.add(panelQuiz, "3");
        panelContainer.add(panelResult, "4");
        panelContainer.add(panelDownload, "5");
        layout.show(panelContainer, "1");

        //button action listener for start, info, result, and download
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelContainer, "2");
            }
        });

        buttonInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });

        buttonScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelContainer, "5");
            }
        });

        frame.add(panelContainer);
        frame.setVisible(true); //<<this was moved here cuz the text wouldn't appear on screen4 
    }
    public void startQuiz() {

        //switching screen
        layout.show(panelContainer, "3");
        nextQuestion();


    }
    public void nextQuestion() {
        if(index >= totalQuestion) {
            layout.show(panelContainer, "4");
        }
        else {
            textfield.setText("Question " + (index + 1));
            textArea.setText(question);

        }
    }

}
