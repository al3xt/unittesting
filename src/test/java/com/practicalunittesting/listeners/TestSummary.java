package com.practicalunittesting.listeners;

/**
 * Created by Alexey on 15.08.2015.
 */
public class TestSummary {

    private String clazz;

    private String name;

    private TestResult result;

    private long startTime;

    private long finishTime;

    protected enum TestResult {
        OK, FAILURE, IGNORED
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestResult getResult() {
        return result;
    }

    public void setResult(TestResult result) {
        this.result = result;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestSummary that = (TestSummary) o;

        if (!clazz.equals(that.clazz)) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = clazz.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClazz() + "." + getName() + " " + getResult();
    }
}
