package Questions.AmazonLockerService.service;

import Questions.AmazonLockerService.model.Locker;

public class NotificationService {
    public static void sendLockerCode(Locker locker) {
        String code = generateCode();
        System.out.println("Locker code sent to customer: " + code);
    }

    private static String generateCode() {
        return String.valueOf((int) (Math.random() * 1000000));
    }
}
