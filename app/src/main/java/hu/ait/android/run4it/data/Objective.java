package hu.ait.android.run4it.data;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Jwatto01 on 5/20/16.
 */
public class Objective{
    @Override
    public String toString() {
        return "Objective{" +
                "objectiveName=" + objectiveName +
                "m=" + m +
                ", begin=" + begin +
                ", end=" + end +
                ", points=" + points +
                ", timeNumber=" + timeNumber +
                ", completed=" + completed +
                '}';
    }

    WorkoutMeasure m;
    Date begin;
    Date end;
    int points;
    int timeNumber;

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    String objectiveName;

    public WorkoutMeasure getM() {
        return m;
    }

    public void setM(WorkoutMeasure m) {
        this.m = m;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTimeNumber() {
        return timeNumber;
    }

    public void setTimeNumber(int timeNumber) {
        this.timeNumber = timeNumber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    boolean completed;

    public Objective(WorkoutMeasure m, Date begin, Date end, int points, int timeNumber, boolean completed, String objectiveName) {
        this.m = m;
        this.begin = begin;
        this.end = end;
        this.points = points;
        this.timeNumber = timeNumber;
        this.completed = completed;
        this.objectiveName = objectiveName;
    }

    public Objective(){

    }
}