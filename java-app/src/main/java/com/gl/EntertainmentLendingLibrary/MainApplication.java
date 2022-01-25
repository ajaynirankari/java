package com.gl.EntertainmentLendingLibrary;

import java.time.LocalDate;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Welcome in Entertainment Lending Library");

        EntertainmentItem item1 = new EntertainmentItem("Item1", 105.50, null);
        EntertainmentItem item2 = new EntertainmentItem("Item2", 135, "benefactor1");
        EntertainmentItem item3 = new EntertainmentItem("Item3", 500, null);
        EntertainmentItem item4 = new EntertainmentItem("Item4", 96, "benefactor2");
        EntertainmentItem item5 = new EntertainmentItem("Item5", 825.5, null);
        EntertainmentItem item6 = new EntertainmentItem("Item6", 85.5, "benefactor3");
        EntertainmentItem item7 = new EntertainmentItem("Item7", 185.5, null);
        EntertainmentItem item8 = new EntertainmentItem("Item8", 300, null);

        ResidentMember residentMember1 = new ResidentMember("ResidentMember1", 300, "555-1231");
        ResidentMember residentMember2 = new ResidentMember("ResidentMember2", 400, "555-1232");
        ResidentMember residentMember3 = new ResidentMember("ResidentMember3", 500, "555-1233");
        System.out.println("residentMember1 = " + residentMember1);
        System.out.println("residentMember2 = " + residentMember2);
        System.out.println("residentMember3 = " + residentMember3);

        residentMember1.signOutItem(item1);
        residentMember1.signOutItem(item2);
        residentMember1.signOutItem(item3);
        residentMember1.signOutItem(item4);
        residentMember1.signOutItem(item5);
        residentMember1.signOutItem(item6);
        System.out.println("residentMember1 = " + residentMember1);
        boolean signOutItem = residentMember1.signOutItem(item7);
        System.out.println("signOutItem item7=" + signOutItem);

        signOutItem = residentMember1.signOutItem(item8);
        System.out.println("signOutItem item8=" + signOutItem);

        System.out.println("residentMember1 = " + residentMember1);

        boolean returnItem4 = residentMember1.returnItem(item4);
        System.out.println("returnItem item4 = " + returnItem4);
        System.out.println("residentMember1 = " + residentMember1);

        residentMember1.changeItem(item2, item8);
        System.out.println("residentMember1 = " + residentMember1);

        EntertainmentItem[] items = residentMember1.getAllItems();
        System.out.println("Arrays.toString(items) = " + Arrays.toString(items));

        ShortTermResidentMember shortTermResidentMember = new ShortTermResidentMember("ShortTermResidentMember", 345, "555-234", LocalDate.now());
        System.out.println("shortTermResidentMember = " + shortTermResidentMember);
        System.out.println("getFormattedDepartureDate = " + shortTermResidentMember.getFormattedDepartureDate());

        shortTermResidentMember.signOutItem(item1); // Allowed to sign out
        shortTermResidentMember.signOutItem(item2); // NOT Allowed to sign out
        shortTermResidentMember.setPhoneNumber("444-6543");
        System.out.println("shortTermResidentMember = " + shortTermResidentMember);

    }
}

