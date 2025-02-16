package org.knit.lab2sem1;

class ManagerHandler extends ComplaintHandler {
    @Override
    protected boolean canHandleComplaint(Complaint complaint) {
        return complaint.getComplexityLevel() == ComplexityLevel.FIRST ||
                complaint.getComplexityLevel() == ComplexityLevel.SECOND ||
                complaint.getComplexityLevel() == ComplexityLevel.UNKNOWN;
    }

    @Override
    protected void resolveComplaint(Complaint complaint) {
        System.out.println("Менеджер обработал жалобу: " + complaint);
    }
}
