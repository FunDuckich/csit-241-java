package org.knit.lab1sem2;

public class Task1 {
    public static void execute() {
        ComplaintHandler callCenter = new CallCenterHandler();
        ComplaintHandler manager = new ManagerHandler();
        ComplaintHandler legalDepartment = new LegalDepartmentHandler();
        ComplaintHandler topManagement = new TopManagementHandler();

        callCenter.setNextHandler(manager);
        manager.setNextHandler(legalDepartment);
        legalDepartment.setNextHandler(topManagement);

        Complaint firstLevelComplaint = new Complaint("Не приходит смс бро!", ComplexityLevel.FIRST);
        Complaint secondLevelComplaint = new Complaint("Как перевести деньги другу?", ComplexityLevel.SECOND);
        Complaint thirdLevelComplaint = new Complaint("Куда пропали деньги с карты? :(", ComplexityLevel.THIRD);
        Complaint fourthLevelComplaint = new Complaint("Мошенничество!!!!", ComplexityLevel.FOURTH);
        Complaint unknownComplaint = new Complaint("Непонятная ошибка в приложении...", ComplexityLevel.UNKNOWN);

        System.out.println("Обработка жалобы первого уровня:");
        callCenter.handleComplaint(firstLevelComplaint);
        System.out.println("\nОбработка жалобы второго уровня:");
        callCenter.handleComplaint(secondLevelComplaint);
        System.out.println("\nОбработка жалобы третьего уровня:");
        callCenter.handleComplaint(thirdLevelComplaint);
        System.out.println("\nОбработка жалобы четвертого уровня:");
        callCenter.handleComplaint(fourthLevelComplaint);
        System.out.println("\nОбработка жалобы с неизвестным уровнем сложности:");
        callCenter.handleComplaint(unknownComplaint);
    }
}
