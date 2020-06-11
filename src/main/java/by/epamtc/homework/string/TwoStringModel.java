package by.epamtc.homework.string;

public class TwoStringModel {
    private String firstString;
    private String secondString;

    public TwoStringModel(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }

    @Override
    public String toString() {
        return "by.epamtc.homework.string.TwoStringModel{" +
                "firstString='" + firstString + '\'' +
                ", secondString='" + secondString + '\'' +
                '}';
    }
}
