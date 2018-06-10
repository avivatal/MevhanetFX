import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Model {

    private Connection connection;

    public Model(){
        connectToDb();
    }

    public User login(String username, String password){
        try{
            String statement = "SELECT * FROM Users WHERE username = '"+username+"' AND password = '" + password +"'";
            PreparedStatement ps = connection.prepareStatement(statement);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String userType = resultSet.getString(9);
                User user = null;
                switch(userType){
                    case "instructionemployee":
                        user = new InstructionEmployee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                                resultSet.getString(4),resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)
                        ,resultSet.getString(8));
                        break;

                    case "reception":
                        user = new Reception(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                                resultSet.getString(4),resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)
                                ,resultSet.getString(8));
                        break;
                }
                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void connectToDb(){

        try {
            String path ="src/Database.accdb";
            connection = DriverManager.getConnection("jdbc:ucanaccess://"+path);
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }

    public ArrayList<String> getCourses(String id){
        try{
            String statement = "SELECT * FROM CoursesStaff WHERE instructionemployeeid = '"+id+"'";
            PreparedStatement ps = connection.prepareStatement(statement);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<String> courses = new ArrayList<>();
            while(resultSet.next()){
                String courseId = resultSet.getString(2);
                String courseStatement = "SELECT * FROM Courses WHERE courseid = '"+courseId+"'";
                PreparedStatement coursePs = connection.prepareStatement(courseStatement);
                ResultSet courseResultSet = coursePs.executeQuery();
                if(courseResultSet.next()){
                    courses.add(courseResultSet.getString(1));
                }
            }
            return courses;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Semester getCurrentSemester(){
        Semester semester = new Semester();
        semester.setYear(Calendar.getInstance().get(Calendar.YEAR));
        int month = Calendar.getInstance().get(Calendar.MONTH);
        if(month>=10 && month<=12 || month>=1 && month<=3){
            semester.setSeason(Semester.season.Fall);
        }
        else if(month >=4 && month<=7){
            semester.setSeason(Semester.season.Spring);
        }
        else{
            semester.setSeason(Semester.season.Summer);
        }
        return semester;
    }

    public Course getCourseDetails(Course course) {
        try {
            String statement = "SELECT * FROM Courses WHERE coursename = '" + course.getCourseName() + "'";
            PreparedStatement ps = connection.prepareStatement(statement);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                course.setCourseNumber(resultSet.getString("courseid"));
            }

            String repoStatement = "SELECT * FROM Questions WHERE courseid = '" + course.getCourseNumber() + "'";
            PreparedStatement repoPs = connection.prepareStatement(repoStatement);
            ResultSet repoResultSet = repoPs.executeQuery();
            while (repoResultSet.next()) {
                Question question = new Question(repoResultSet.getString("questionid"), repoResultSet.getString("body"), Integer.parseInt(repoResultSet.getString("difficulty")), Double.parseDouble(repoResultSet.getString("timetosolve")));
                course.addQuestion(question);
            }

            for(Question q : course.getQuestionsRepository()){
                String commentStatement = "SELECT * FROM QuestionComments WHERE questionid = '" + q.getId() + "'";
                PreparedStatement commentsps = connection.prepareStatement(commentStatement);
                ResultSet commentresultSet = commentsps.executeQuery();
                while (commentresultSet.next()) {
                    Comment comment = new Comment(commentresultSet.getString("comment"));
                    q.addComment(comment);
                }

                String optionStatement = "SELECT * FROM Options WHERE questionid = '" + q.getId() + "'";
                PreparedStatement optionsps = connection.prepareStatement(optionStatement);
                ResultSet optionresultSet = optionsps.executeQuery();
                while (optionresultSet.next()) {
                    Option o = new Option(optionresultSet.getString("statement"), optionresultSet.getBoolean("iscorrect"));
                    q.addOption(o);
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return course;
    }

    public Pair<ArrayList<String>, InstructionEmployee> getAvailableActions(Course course, InstructionEmployee user){
        try {
            Semester currentSemester = getCurrentSemester();
            boolean isInstructorNow = false;
            String statement = "SELECT * FROM CoursesStaff WHERE courseid = '" + course.getCourseNumber() + "' AND instructionemployeeid = '" + user.getID() + "'";
            PreparedStatement ps = connection.prepareStatement(statement);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Semester s = new Semester(resultSet.getString("season"), resultSet.getString("year"));
                if(s.equals(currentSemester)){
                    isInstructorNow = true;
                }
                InstructionEmployee newUser = null;
                ArrayList<String> actions = new ArrayList<>();
                switch(resultSet.getString("stafftype")){
                    case "instructionemployee":
                        newUser = user;
                        actions.add("View Repository");
                        if(isInstructorNow)
                            actions.add("Create Question");
                        break;
                    case "lecturer":
                        actions.add("View Repository");
                        if(isInstructorNow)
                            actions.add("Create Question");
                        newUser = new Lecturer(user);
                        break;
                    case "headlecturer":
                        actions.add("View Repository");
                        if(isInstructorNow)
                            actions.add("Create Question");
                        newUser = new HeadLecturer(user);
                        break;
                }
            return new Pair<>(actions, newUser);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
