package com.example.dangkao.model.entity;

/**
 * Created by luoluo on 2015/12/16.
 */
public class ChoiceQuestion {
    private int id;
    private int c_id;
    private String title;
    private String choice_A;
    private String choice_B;
    private String choice_C;
    private String choice_D;
    private String answer;
    private int is_wrong;
    private int is_save;

    public ChoiceQuestion(){}

    public ChoiceQuestion(int id, int c_id, String title, String choice_A, String choice_B, String choice_C, String choice_D, String answer, int is_wrong, int is_save) {
        this.id = id;
        this.c_id = c_id;
        this.title = title;
        this.choice_A = choice_A;
        this.choice_B = choice_B;
        this.choice_C = choice_C;
        this.choice_D = choice_D;
        this.answer = answer;
        this.is_wrong = is_wrong;
        this.is_save = is_save;
    }

    public int getIs_save() {
        return is_save;
    }

    public void setIs_save(int is_save) {
        this.is_save = is_save;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIs_wrong() {
        return is_wrong;
    }

    public void setIs_wrong(int is_wrong) {
        this.is_wrong = is_wrong;
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "id=" + id +
                ", c_id=" + c_id +
                ", title='" + title + '\'' +
                ", choice_A='" + choice_A + '\'' +
                ", choice_B='" + choice_B + '\'' +
                ", choice_C='" + choice_C + '\'' +
                ", choice_D='" + choice_D + '\'' +
                ", answer='" + answer + '\'' +
                ", is_wrong=" + is_wrong +
                ", is_save=" + is_save +
                '}';
    }
}
