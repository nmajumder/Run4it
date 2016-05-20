package hu.ait.android.run4it.data;

import java.util.Date;

/**
 * Created by Jwatto01 on 5/20/16.
 */
public class Competition {

    Date begin;
    Date end;
    int buyin;
    int numParticipants;
    String compName;

    public Competition() {
    }

    public Competition(Date begin, Date end, int buyin, int numParticipants, String compName) {

        this.begin = begin;
        this.end = end;
        this.buyin = buyin;
        this.numParticipants = numParticipants;
        this.compName = compName;
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

    public int getBuyin() {
        return buyin;
    }

    public void setBuyin(int buyin) {
        this.buyin = buyin;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }
}
