package hu.ait.android.run4it.data;

import java.util.Date;

public class Competition {

    Date begin;
    Date end;
    int buyin;
    int winnings1st;
    int winnings2nd;
    int winnings3rd;
    int numParticipants;
    String compName;
    String description;
    boolean entered;

    public Competition() {
    }

    public Competition(Date begin, Date end, int buyin, int numParticipants,
                       String name, String description,
                       int firstPlace, int secondPlace, int thirdPlace) {

        this.begin = begin;
        this.end = end;
        this.buyin = buyin;
        this.winnings1st = firstPlace;
        this.winnings2nd = secondPlace;
        this.winnings3rd = thirdPlace;
        this.numParticipants = numParticipants;
        this.compName = name;
        this.description = description;
        this.entered = false;
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

    public int getWinnings1st() {
        return winnings1st;
    }

    public void setWinnings1st(int winnings1st) {
        this.winnings1st = winnings1st;
    }

    public int getWinnings2nd() {
        return winnings2nd;
    }

    public void setWinnings2nd(int winnings2nd) {
        this.winnings2nd = winnings2nd;
    }

    public int getWinnings3rd() {
        return winnings3rd;
    }

    public void setWinnings3rd(int winnings3rd) {
        this.winnings3rd = winnings3rd;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }
}
