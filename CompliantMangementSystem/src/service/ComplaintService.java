package service;

import dao.ComplaintDAO;

public class ComplaintService {
    ComplaintDAO dao = new ComplaintDAO();

    public void register(String name, String issue) {
        dao.addComplaint(name, issue);
    }

    public void display() {
        dao.viewComplaints();
    }

    public void update(int id, String status) {
        dao.updateStatus(id, status);
    }

    public void delete(int id) {
        dao.deleteComplaint(id);
    }
}