import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

// base code from lab 12, adapted to get rid of check answer button and functionality, and instead count 
// scores for each pigeon type

public class QuizView extends JFrame {
    // Define UI elements
    private JLabel questionLabel;
    private JRadioButton[] radioButtons;
    private JButton nextButton;
    private ButtonGroup group;
    private JLabel resultLabel;

    // Constants
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 300;
    private static final String APP_NAME = "Pigeon Personality Quiz!";

    // colors!
    private static final Color backgroundColor = new Color(236, 196, 247); // pink

    public QuizView() {
        // Setup the frames
        setTitle(APP_NAME);
        // Default operation that will happen when the user closes this frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define the window's size
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        generateLayout();
        setVisible(true);
    }

    // Getters and setters
    // modified to account for randomized options
    public char getSelectedAnswer(Question question) {
        String[] options = question.getOptions();
        for (int i = 0; i < radioButtons.length; i++) {
            // check selected answer to corresponding pigeon option in CSV, return char for pigeon type
            if (radioButtons[i].isSelected()) {
                if(radioButtons[i].getText().equals(options[0])){
                    return 'A';
                }
                else if(radioButtons[i].getText().equals(options[1])){
                    return 'B';
                }
                else if(radioButtons[i].getText().equals(options[2])){
                    return 'C';
                }
                else if(radioButtons[i].getText().equals(options[3])){
                    return 'D';
                }
            }
        }
        return ' '; // return default ' ' if no char selected
    }

    public void setQuestion(String question) {
        // set the question label's text
        questionLabel.setText(question);
    }

    // adapted to randomize options
    public void setOptions(String[] options) {
        // set the text for the radio buttons to display the answer options
        Random random = new Random();
        int randomIndex;
        // make a copy of array to keep original order for answer checking later
        String[] copyOptions = options.clone();

        for(int i = 0; i < copyOptions.length; i++){
            // prevent duplicate options
            do{ // set random available option as next option
                randomIndex = random.nextInt(copyOptions.length);
            } while(copyOptions[randomIndex] == null);
            radioButtons[i].setText(copyOptions[randomIndex]);
            copyOptions[randomIndex] = null; 
        }
    }

    // generate new frame to display result
    public void generateResultLayout(Pigeon result){
        setVisible(false);
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT + 100);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(APP_NAME);

        // set result title label
        JLabel titleLabel = new JLabel("Your Pigeon Personality: " + result.name().replaceAll("_", " "));
        titleLabel.setBounds(50, 20, 450, 20);
        frame.add(titleLabel);

        // set image label 
        Image image = new ImageIcon("src/" + result.getImageName()).getImage();
        Image scaledImage = image.getScaledInstance(200,200,Image.SCALE_DEFAULT);
        Icon resultIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resultIcon);
        imageLabel.setBounds(50, 50, FRAME_WIDTH - 2*50, 200);
        frame.add(imageLabel);

        // set description label
        // textArea code: https://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
        JTextArea textArea = new JTextArea(2, 20);
        textArea.setText(result.getDescription());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(backgroundColor);
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setBorder(UIManager.getBorder("Label.border"));
        textArea.setBounds(50, 260, FRAME_WIDTH - 2*50, 100);
        frame.add(textArea);

        frame.setVisible(true);
    }

    // Setup the view's layout: Adds labels and buttons
    // added colors :)
    private void generateLayout() {
        setLayout(null);
        getContentPane().setBackground(backgroundColor);

        // Add question label
        questionLabel = new JLabel();
        questionLabel.setBounds(50, 20, 450, 20);
        add(questionLabel);

        // Add 4 radio buttons for answer options as a button group
        radioButtons = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setBounds(50, 50 + (i * 30), 450, 20);
            radioButtons[i].setBackground(backgroundColor); // add color
            group.add(radioButtons[i]);
            add(radioButtons[i]);
        }

        // Add result label
        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 170, 450, 20);
        add(resultLabel);

        nextButton = new JButton("Next");
        nextButton.setBounds(50, 200, 150, 30);
        nextButton.setBackground(new Color(130, 237, 176)); // light green
        add(nextButton);
    }

     // Button listeners (no need to change any code here!)

    public void addNextButtonListener(ActionListener listenForNextButton) {
        nextButton.addActionListener(listenForNextButton);
    }

    public void clearSelection() {
        group.clearSelection();
    }
}