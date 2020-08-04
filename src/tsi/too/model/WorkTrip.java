package tsi.too.model;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class WorkTrip {
    private int dailyMileage;

    private double averageMileagePerLiter;

    private BigDecimal literFuelPrice;
    private BigDecimal dailyParkingFee;
    private BigDecimal dailyToll;

    public WorkTrip(
            int dailyMileage,
            double averageMileagePerLiter,
            @NotNull BigDecimal literFuelPrice,
            @NotNull BigDecimal dailyParkingFee,
            @NotNull BigDecimal dailyToll
    ) {
        this.dailyMileage = dailyMileage;
        this.averageMileagePerLiter = averageMileagePerLiter;
        this.literFuelPrice = literFuelPrice;
        this.dailyParkingFee = dailyParkingFee;
        this.dailyToll = dailyToll;
    }

    public int getDailyMileage() {
        return dailyMileage;
    }

    public void setDailyMileage(int dailyMileage) {
        this.dailyMileage = dailyMileage;
    }

    public double getAverageMileagePerLiter() {
        return averageMileagePerLiter;
    }

    public void setAverageMileagePerLiter(double averageMileagePerLiter) {
        this.averageMileagePerLiter = averageMileagePerLiter;
    }

    public BigDecimal getLiterFuelPrice() {
        return literFuelPrice;
    }

    public void setLiterFuelPrice(BigDecimal literFuelPrice) {
        this.literFuelPrice = literFuelPrice;
    }

    public BigDecimal getDailyParkingFee() {
        return dailyParkingFee;
    }

    public void setDailyParkingFee(BigDecimal dailyParkingFee) {
        this.dailyParkingFee = dailyParkingFee;
    }

    public BigDecimal getDailyToll() {
        return dailyToll;
    }

    public void setDailyToll(BigDecimal dailyToll) {
        this.dailyToll = dailyToll;
    }

    public BigDecimal getDailySpentOnFuel() {
        return BigDecimal.valueOf(getDailyFuelSpent()).multiply(literFuelPrice);
    }

    public double getDailyFuelSpent() {
        return dailyMileage / averageMileagePerLiter;
    }

    public BigDecimal getDailySpentOnDriving() {
        return getDailySpentOnFuel().add(dailyToll).add(dailyParkingFee);
    }

    @Override
    public String toString() {
        return "SolidarityTrack{" +
                "dailyMileage=" + dailyMileage +
                ", mileagePerLiter=" + averageMileagePerLiter +
                ", literGasolinePrice=" + literFuelPrice +
                ", dailyParkingFee=" + dailyParkingFee +
                ", dailyToll=" + dailyToll +
                '}';
    }
}
