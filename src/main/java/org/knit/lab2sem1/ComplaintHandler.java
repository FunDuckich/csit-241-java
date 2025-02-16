package org.knit.lab2sem1;

public abstract class ComplaintHandler {
    protected ComplaintHandler nextHandler;

    public void setNextHandler(ComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleComplaint(Complaint complaint) {
        if (canHandleComplaint(complaint)) {
            resolveComplaint(complaint);
        } else if (nextHandler != null) {
            nextHandler.handleComplaint(complaint);
        } else {
            System.out.println("Жалоба не может быть обработана.");
        }
    }

    protected abstract boolean canHandleComplaint(Complaint complaint);
    protected abstract void resolveComplaint(Complaint complaint);
}
