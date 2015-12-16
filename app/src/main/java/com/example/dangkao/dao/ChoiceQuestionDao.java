package com.example.dangkao.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dangkao.db.DBManager;
import com.example.dangkao.model.entity.ChoiceQuestion;

import java.util.List;

public class ChoiceQuestionDao {
    private DBManager dbm;
    private SQLiteDatabase db;
    List<ChoiceQuestion> choiceQuestions;

    public ChoiceQuestionDao(Context context) {
        dbm = new DBManager(context);
    }

    /**
     * 获取所有选择题
     * @return List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryAllChoiceQuestions() {
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "select * from choice_question";
        ChoiceQuestion choiceQuestion = null;
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setId(cursor.getInt(0));
            choiceQuestion.setC_id(cursor.getInt(1));
            choiceQuestion.setTitle(cursor.getString(2));
            choiceQuestion.setChoice_A(cursor.getString(3));
            choiceQuestion.setChoice_B(cursor.getString(4));
            choiceQuestion.setChoice_C(cursor.getString(5));
            choiceQuestion.setChoice_D(cursor.getString(6));
            choiceQuestion.setIs_wrong(cursor.getInt(7));
            choiceQuestion.setIs_save(cursor.getInt(8));
            choiceQuestions.add(choiceQuestion);
        }
        cursor.close();
        dbm.closeConnect();
        return choiceQuestions;
    }

    /**
     * 根据章节获取选择题
     * @param c_id
     * @return List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryChoiceQuestionByChapterId(int c_id){
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "select * from choice_question where c_id=?";
        String[] params = {Integer.toString(c_id)};
        ChoiceQuestion choiceQuestion = null;
        Cursor cursor = db.rawQuery(sql,params);
        while (cursor.moveToNext()){
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setId(cursor.getInt(0));
            choiceQuestion.setC_id(cursor.getInt(1));
            choiceQuestion.setTitle(cursor.getString(2));
            choiceQuestion.setChoice_A(cursor.getString(3));
            choiceQuestion.setChoice_B(cursor.getString(4));
            choiceQuestion.setChoice_C(cursor.getString(5));
            choiceQuestion.setChoice_D(cursor.getString(6));
            choiceQuestion.setIs_wrong(cursor.getInt(7));
            choiceQuestion.setIs_save(cursor.getInt(8));
            choiceQuestions.add(choiceQuestion);
        }
        cursor.close();
        dbm.closeConnect();
        return choiceQuestions;
    }

    /**
     * 根据选择题id获取选择题
     * @param id
     * @return ChoiceQuestion
     */
    public ChoiceQuestion queryChoiceQuestion(int id){
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "select * from choice_question where id=?";
        String[] params = {Integer.toString(id)};
        ChoiceQuestion choiceQuestion = null;
        Cursor cursor = db.rawQuery(sql,params);
        while (cursor.moveToNext()){
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setId(cursor.getInt(0));
            choiceQuestion.setC_id(cursor.getInt(1));
            choiceQuestion.setTitle(cursor.getString(2));
            choiceQuestion.setChoice_A(cursor.getString(3));
            choiceQuestion.setChoice_B(cursor.getString(4));
            choiceQuestion.setChoice_C(cursor.getString(5));
            choiceQuestion.setChoice_D(cursor.getString(6));
            choiceQuestion.setIs_wrong(cursor.getInt(7));
            choiceQuestion.setIs_save(cursor.getInt(8));
        }
        cursor.close();
        dbm.closeConnect();
        return choiceQuestion;
    }

    /**
     * 获取错题
     * @return List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> queryWrongChoiceQuestions() {
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "select * from choice_question where is_wrong=1";
        ChoiceQuestion choiceQuestion = null;
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setId(cursor.getInt(0));
            choiceQuestion.setC_id(cursor.getInt(1));
            choiceQuestion.setTitle(cursor.getString(2));
            choiceQuestion.setChoice_A(cursor.getString(3));
            choiceQuestion.setChoice_B(cursor.getString(4));
            choiceQuestion.setChoice_C(cursor.getString(5));
            choiceQuestion.setChoice_D(cursor.getString(6));
            choiceQuestion.setIs_wrong(cursor.getInt(7));
            choiceQuestion.setIs_save(cursor.getInt(8));
            choiceQuestions.add(choiceQuestion);
        }
        cursor.close();
        dbm.closeConnect();
        return choiceQuestions;
    }

    /**
     * 获取收藏的选择题
     * @return List<ChoiceQuestion>
     */
    public List<ChoiceQuestion> querySaveChoiceQuestions() {
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "select * from choice_question where is_save=1";
        ChoiceQuestion choiceQuestion = null;
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setId(cursor.getInt(0));
            choiceQuestion.setC_id(cursor.getInt(1));
            choiceQuestion.setTitle(cursor.getString(2));
            choiceQuestion.setChoice_A(cursor.getString(3));
            choiceQuestion.setChoice_B(cursor.getString(4));
            choiceQuestion.setChoice_C(cursor.getString(5));
            choiceQuestion.setChoice_D(cursor.getString(6));
            choiceQuestion.setIs_wrong(cursor.getInt(7));
            choiceQuestion.setIs_save(cursor.getInt(8));
            choiceQuestions.add(choiceQuestion);
        }
        cursor.close();
        dbm.closeConnect();
        return choiceQuestions;
    }

    public void setIsWrong(int id, int is_wrong){
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "update choice_question set is_wrong="+is_wrong+" where id="+id;
        db.execSQL(sql);
    }

    public void setIsSave(int id, int is_save){
        if (db == null) {
            db = dbm.openConnect();
        }
        String sql = "update choice_question set is_wrong="+is_save+" where id="+id;
        db.execSQL(sql);
    }
}