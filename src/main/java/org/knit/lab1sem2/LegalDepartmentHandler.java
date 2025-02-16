package org.knit.lab1sem2;

public class LegalDepartmentHandler extends ComplaintHandler {
    @Override
    protected boolean canHandleComplaint(Complaint complaint) {
        return complaint.getComplexityLevel() == ComplexityLevel.THIRD;
    }

    @Override
    protected void resolveComplaint(Complaint complaint) {
        System.out.println("Юридический отдел обработал жалобу: " + complaint);
    }
}
