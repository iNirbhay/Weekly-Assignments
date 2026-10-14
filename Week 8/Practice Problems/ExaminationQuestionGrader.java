import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExamQuestion {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public ExamQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();
    public abstract double evaluateScore();
}

class MCQQuestion extends ExamQuestion {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "MCQ";
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim()) ? points : 0.0;
    }
}

class TFQuestion extends ExamQuestion {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "TF";
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim()) ? points : 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "ESSAY";
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            sc.close();
            return;
        }

        String nLine = sc.nextLine().trim();
        while (nLine.isEmpty() && sc.hasNextLine()) {
            nLine = sc.nextLine().trim();
        }
        if (nLine.isEmpty()) {
            sc.close();
            return;
        }

        int n = Integer.parseInt(nLine);
        List<ExamQuestion> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"(?:\\s+([0-9.]+))?");

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            while (line.isEmpty() && sc.hasNextLine()) {
                line = sc.nextLine().trim();
            }

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String qText = matcher.group(2);
                String correct = matcher.group(3);
                String student = matcher.group(4);
                double points = matcher.group(5) != null ? Double.parseDouble(matcher.group(5)) : 0.0;

                if ("MCQ".equalsIgnoreCase(type)) {
                    questions.add(new MCQQuestion(qText, correct, student, points));
                } else if ("TF".equalsIgnoreCase(type)) {
                    questions.add(new TFQuestion(qText, correct, student, points));
                } else if ("ESSAY".equalsIgnoreCase(type)) {
                    questions.add(new EssayQuestion(qText, correct, student, points));
                }
            }
        }

        double totalScore = 0;
        for (ExamQuestion q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}
