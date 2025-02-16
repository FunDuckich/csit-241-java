package org.knit.lab1sem2;

class TopManagementHandler extends ComplaintHandler {
    @Override
    protected boolean canHandleComplaint(Complaint complaint) {
        return complaint.getComplexityLevel() == ComplexityLevel.FOURTH;
    }

    @Override
    protected void resolveComplaint(Complaint complaint) {
        System.out.println("Высшее руководство обработало жалобу: " + complaint);
    }
}
