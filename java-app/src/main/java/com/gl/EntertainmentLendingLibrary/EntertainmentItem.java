package com.gl.EntertainmentLendingLibrary;

/**
 * This class -EntertainmentItem is represented the item details
 */
public class EntertainmentItem {

    /**
     * This field contains value of item description
     */
    private final String description;
    /**
     * This field contains value of item originalPrice
     */
    private final double originalPrice;
    /**
     * This field contains value of item benefactor
     */
    private final String benefactor;

    /**
     * This the constructor for class - EntertainmentItem
     *
     * @param description   of item
     * @param originalPrice of item
     * @param benefactor    is the status of item
     */
    public EntertainmentItem(String description, double originalPrice, String benefactor) {
        this.description = description;
        this.originalPrice = originalPrice;
        this.benefactor = benefactor == null ? "" : benefactor;
    }

    /**
     * This method return the description of item
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method return the originalPrice of item
     *
     * @return the originalPrice
     */
    public double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * This method return the benefactor of item
     *
     * @return the benefactor
     */
    public String getBenefactor() {
        return benefactor;
    }

    @Override
    public String toString() {
        return "EntertainmentItem{" +
                "description='" + description + '\'' +
                ", originalPrice=" + originalPrice +
                ", benefactor='" + benefactor + '\'' +
                '}';
    }
}
