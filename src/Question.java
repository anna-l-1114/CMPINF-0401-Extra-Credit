// from lab 12 
public class Question {
    private final String question;
    private final String[] options;

    // Constructor & getters
    public Question(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    // from lab 12
    public void display(QuizView view){
        view.setQuestion(question);
        view.setOptions(options);
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

}
