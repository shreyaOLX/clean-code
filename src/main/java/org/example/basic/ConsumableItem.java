package org.example.basic;

import java.time.LocalDate;

public class ConsumableItem {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public ConsumableItem(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return expirationDate.isAfter(LocalDate.now()) && approvedForConsumption && inspectorId != null;
    }

    public static void main(String[] args) {

            ConsumableItem item = new ConsumableItem(LocalDate.of(2025, 5, 1),true, 123);
            System.out.println("Is item edible? " + item.isEdible());
    }
}
