import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

// Personality quiz that determines what pigeon (Five Guys, Studious, Evil, Proud) you are out of 4 options. 
// Images are from me (pictures of pigeons on Pitt campus)
// the csv questions are always in the same order of corresponding pigeon type answers
public class PigeonQuiz {
    // initialize scores for each pigeon type
    private static int fiveGuysPigeonScore = 0;
    private static int studiousPigeonScore = 0;
    private static int evilPigeon = 0;
    private static int proudPigeonScore = 0;

    private static int currentQuestionIndex = 0;
    
    public static void main(String[] args) throws Exception {
        // read questions from csv
        List<Question> questions = readQuestionsFromCSV("src/questions.csv"); 
        
        // initialize a new view
        QuizView view = new QuizView();

        // load the current question into the view
        updateViewWithQuestion(view, questions.get(0));

        addButtonListeners(questions, view);
    }

    // from lab 12, unchanged
    private static void updateViewWithQuestion(QuizView view, Question question) {
        // display question
        question.display(view);
        
    }

    // from lab 12, adapted to not show a correct result & instead add to individual pigeon scores
    // Button listeners for tracking an answer and displaying the next question
    private static void addButtonListeners(List<Question> questions, QuizView view) {
        view.addNextButtonListener(_ -> {
            // Check if an answer has been selected
            char selectedAnswerChar = view.getSelectedAnswer(questions.get(currentQuestionIndex));
            if (selectedAnswerChar == ' ') {
                JOptionPane.showMessageDialog(view, "Please select an answer.");
                return;
            }

            // add to individual pigeon scores based on selected answers
            switch (selectedAnswerChar) {
                case 'A':
                    fiveGuysPigeonScore++;
                    break;
                case 'B':
                    studiousPigeonScore++;
                    break;
                case 'C':
                    evilPigeon++;
                    break;
                case 'D':
                    proudPigeonScore++;
                    break;
            }

            // Move to the next question
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                updateViewWithQuestion(view, questions.get(currentQuestionIndex));
                view.clearSelection();
            // show result if no more questions left
            } else {
                Pigeon result = determineAnswer();
                view.generateResultLayout(result);
            }
        });
    }

    // From lab 12, adapted to take in questions and 4 options in order (no correct answer in CSV)
    public static List<Question> readQuestionsFromCSV(String filename) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] cells = line.split(",");
                // CSV fields are: Question, Option A, Option B, Option C, Option D
                if (cells.length >= 5) {
                    String question = cells[0];
                    String[] options = { cells[1], cells[2], cells[3], cells[4] };

                    questions.add(new Question(question, options));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // returns pigeon with highest score, if there's tie return random pigeon among tied
    private static Pigeon determineAnswer(){
        int[] scores = {fiveGuysPigeonScore, studiousPigeonScore, evilPigeon, proudPigeonScore};
        int resultIndex;
        Random random = new Random();

        List<Integer> maxIndices = findMaxIndices(scores);
        // pick random result in event of tie
        if(maxIndices.size() > 1){
            resultIndex = maxIndices.get(random.nextInt(maxIndices.size()));
        } 
        // no tie
        else {
            resultIndex = maxIndices.get(0);
        }
        // return pigeon result based on index
        switch(resultIndex){
            case 0:
                return Pigeon.FIVE_GUYS_PIGEON;
            case 1:
                return Pigeon.STUDIOUS_PIGEON;
            case 2:
                return Pigeon.EVIL_PIGEON;
            case 3:
                return Pigeon.PROUD_PIGEON;
        }
        return Pigeon.FIVE_GUYS_PIGEON; // default in case of error 
    }

    // returns max indices of an array 
    private static List<Integer> findMaxIndices(int[] arr) {
        List<Integer> indices = new ArrayList<>();
        int max = 0;
        // iterate through array
        for (int i = 0; i < arr.length; i++) {
            // update max and reset indices if new max found
            if (arr[i] > max) {
                max = arr[i];
                indices.clear();
                indices.add(i);
            // add index if instance of max found
            } else if (arr[i] == max) {
                indices.add(i);
            }
        }
        return indices;
    }
}
