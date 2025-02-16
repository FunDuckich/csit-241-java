package org.knit.lab1sem2;

class CallCenterHandler extends ComplaintHandler {
    @Override
    protected boolean canHandleComplaint(Complaint complaint) {
        return complaint.getComplexityLevel() == ComplexityLevel.FIRST;
    }

    @Override
    protected void resolveComplaint(Complaint complaint) {
        System.out.println("Колл-центр обработал жалобу: " + complaint);
    }
}

