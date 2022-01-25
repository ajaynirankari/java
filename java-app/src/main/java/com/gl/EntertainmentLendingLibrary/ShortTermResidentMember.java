package com.gl.EntertainmentLendingLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class - ShortTermResidentMember is represented the visiting friends and family of permanent residents
 */
public class ShortTermResidentMember extends ResidentMember {

    /**
     * This field record the departure date
     */
    private LocalDate departureDate;
    /**
     * This field is for formatted departure date
     */
    private String formattedDepartureDate;

    /**
     * This is constructor for the class ShortTermResidentMember
     *
     * @param fullName      of short term resident member
     * @param condoUnit     of short term resident member
     * @param phoneNumber   of short term resident member
     * @param departureDate of short term resident member
     */
    public ShortTermResidentMember(String fullName, int condoUnit, String phoneNumber, LocalDate departureDate) {
        super(fullName, condoUnit, phoneNumber);
        this.departureDate = departureDate;
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMMM dd,yyyy");
        this.formattedDepartureDate = FORMATTER.format(departureDate);
    }

    /**
     * This method for departureDate of short term resident member
     *
     * @return departureDate of short term resident member
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * This method for formattedDepartureDate of short term resident member
     *
     * @return formattedDepartureDate of short term resident member
     */
    public String getFormattedDepartureDate() {
        return formattedDepartureDate;
    }

    /**
     * This method allowed to sign-out item for short term resident member for those item which does not have benefactor
     *
     * @param item - short term resident member want to sign-out
     * @return boolean true if item is signed-out else return false
     */
    @Override
    public boolean signOutItem(EntertainmentItem item) {
        boolean result;
        if (item.getBenefactor().isEmpty()) {
            result = super.signOutItem(item);
        } else {
            System.out.println("For ShortTermResidentMember signOutItem() is not allowed. The item has benefactor exist");
            result = false;
        }
        return result;
    }
}
