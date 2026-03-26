package model;

public class Complaint {
    private int id;
    private String name;
    private String issue;
    private String status;

    public Complaint(int id, String name, String issue, String status) {
        this.id = id;
        this.name = name;
        this.issue = issue;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getIssue() { return issue; }
    public String getStatus() { return status; }
}