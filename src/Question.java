import java.util.ArrayList;

public class Question {
    private String id;
    private String body;
    private int difficulty;
    private double timeToSolve;
    private Comment[] comments;
    private ArrayList<Option> options;
    private int commentCounter;

    public Question(String id, String body, int difficulty, double timeToSolve) {
        this.id = id;
        this.body = body;
        this.difficulty = difficulty;
        this.timeToSolve = timeToSolve;
        this.comments = new Comment[10];
        this.options = new ArrayList<>();
        commentCounter = 0;
    }

    public void addComment(Comment comment){
        if(commentCounter<10){
            comments[commentCounter] = comment;
            commentCounter++;
        }
    }

    public void addOption(Option o){
        options.add(o);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public double getTimeToSolve() {
        return timeToSolve;
    }

    public void setTimeToSolve(double timeToSolve) {
        this.timeToSolve = timeToSolve;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
}
