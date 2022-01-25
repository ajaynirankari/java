package com.gl.EntertainmentLendingLibrary;

import java.util.Arrays;

/**
 * The ResidentMember class represents a resident of the condo who has signed up
 * for the building's lending library
 */
public class ResidentMember {
    /**
     * The full name of resident
     */
    private final String fullName;
    /**
     * The condo unit number of resident
     */
    private final int condoUnit;
    /**
     * The phone number of resident
     */
    private String phoneNumber;
    /**
     * The unique membership number of each resident
     */
    private final int membershipNumber;
    /**
     * The items are an array data structure, which hold item signed out at any
     * given time by resident
     */
    private final EntertainmentItem[] items = new EntertainmentItem[7];

    /**
     * The itemIndex is the total no of items that the resent holding currently
     */
    private int itemIndex = 0;
    /**
     * For to generate the membership unique number, that start from 500000
     */
    private static int membershipNumberCounterStart = 500000;

    /**
     * This is parameterized constructor for class ResidentMember
     *
     * @param fullName    of new resident member
     * @param condoUnit   of new resident member
     * @param phoneNumber of new resident member
     */
    public ResidentMember(String fullName, int condoUnit, String phoneNumber) {
        this.fullName = fullName;
        this.condoUnit = condoUnit;
        this.phoneNumber = phoneNumber;
        membershipNumber = membershipNumberCounterStart++;
    }

    /**
     * The method return the full name of resident member
     *
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * The method return the condo unit of resident member
     *
     * @return condoUnit
     */
    public int getCondoUnit() {
        return condoUnit;
    }

    /**
     * The method return the phone number of resident member
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method update the existing phone number with new phone number
     *
     * @param phoneNumber is new phone number for update old phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * The method return the membership number of resident member
     *
     * @return membershipNumber
     */
    public int getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * This method for getting all the items that is currently holing by the resident member
     *
     * @return copy of the items[]
     */
    public EntertainmentItem[] getAllItems() {
        EntertainmentItem[] copyItems = new EntertainmentItem[itemIndex];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                copyItems[i] = items[i];
            }
        }
        return copyItems;
    }

    /**
     * This method allowed to sign-out item for the resident member
     *
     * @param item - the resident member want to sign-out
     * @return boolean true if item is signed-out else return false
     */
    public boolean signOutItem(EntertainmentItem item) {
        if (itemIndex < items.length) {
            items[itemIndex] = item;
            itemIndex = itemIndex + 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method for returning the item by resident member
     *
     * @param item which resident member want to return
     * @return true it item returned else return false
     */
    public boolean returnItem(EntertainmentItem item) {
        for (int i = 0; i < itemIndex; i++) {
            EntertainmentItem temp = items[i];
            if (temp != null && compareTwoItems(temp, item)) {
                while (i < itemIndex - 1) {
                    items[i] = items[i + 1];
                    i = i + 1;
                }
                items[i] = null;
                itemIndex = itemIndex - 1;
                return true;
            }
        }
        return false;
    }

    /**
     * This is method for replacing the old item with new item
     *
     * @param old_item which replaced with new item
     * @param new_item for change old item
     * @return true if item changed else return false
     */
    public boolean changeItem(EntertainmentItem old_item, EntertainmentItem new_item) {
        for (int i = 0; i < items.length; i++) {
            EntertainmentItem temp = items[i];
            if (compareTwoItems(old_item, temp)) {
                items[i] = new_item;
                return true;
            }
        }
        return false;
    }

    /**
     * This method is compare two items
     *
     * @param item1 for compare
     * @param item2 for compare
     * @return true if both items have same description,original price and benefactor else return false
     */
    private boolean compareTwoItems(EntertainmentItem item1, EntertainmentItem item2) {
        return item1.getDescription().equals(item2.getDescription()) &&
                item1.getOriginalPrice() == item2.getOriginalPrice() &&
                item1.getBenefactor().equals(item2.getBenefactor());
    }

    @Override
    public String toString() {
        return "ResidentMember{" +
                " membershipNumber=" + membershipNumber +
                ", fullName='" + fullName + '\'' +
                ", condoUnit=" + condoUnit +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", \nitems[" + itemIndex + "]=>" + Arrays.toString(items) +
                '}';
    }

}
