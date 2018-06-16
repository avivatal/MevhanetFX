public class Option {
    private String statement;
    private boolean isCorrect;

    public Option(String statement, boolean isCorrect) {
        this.statement = statement;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        String b = "False";
        if(isCorrect)
            b = "True";
        String str = statement + "\t" + b;
        return str;
    }

    public String getStatement() {
        return statement;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
