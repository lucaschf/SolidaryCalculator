package tsi.too.controller;

import tsi.too.model.WorkTrip;
import tsi.too.util.InputDialog;
import tsi.too.util.MessageDialog;

import java.math.BigDecimal;

import static tsi.too.Constants.*;

public class SolidaryTrack {
    private WorkTrip workTrip;

    public void readData() {
        BigDecimal literFuelPrice = InputDialog.showBigDecimalInputDialog(
                SOLIDARY_TRACK,
                LITER_FUEL_PRICE,
                input -> input.compareTo(BigDecimal.ZERO) > 0
        );
        if (literFuelPrice == null)
            return;

        Integer dailyMileage = InputDialog.showIntegerInputDialog(
                SOLIDARY_TRACK,
                DAILY_MILEAGE,
                input -> input > 0
        );
        if (dailyMileage == null)
            return;

        Double averageMileagePerLiter = InputDialog.showDoubleInputDialog(
                SOLIDARY_TRACK,
                MILEAGE_PER_LITER,
                input -> input > 0
        );
        if (averageMileagePerLiter == null)
            return;

        BigDecimal dailyParkingFee = InputDialog.showBigDecimalInputDialog(
                SOLIDARY_TRACK,
                DAILY_PARKING_FEE,
                input -> input.compareTo(BigDecimal.ZERO) > -1
        );
        if (dailyParkingFee == null)
            return;

        BigDecimal dailyToll = InputDialog.showBigDecimalInputDialog(
                SOLIDARY_TRACK,
                DAILY_TOLL,
                input -> input.compareTo(BigDecimal.ZERO) > -1
        );
        if (dailyToll == null)
            return;

        workTrip = new WorkTrip(
                dailyMileage,
                averageMileagePerLiter,
                literFuelPrice,
                dailyParkingFee,
                dailyToll
        );

    }

    public void showDailySpent() {
        if (workTrip == null) {
            MessageDialog.showAlertDialog(SOLIDARY_TRACK, NO_DATA_TO_SHOW);
            return;
        }

        String message = COST_PER_DAY_OF_DRIVING_TO_WORK
                .concat(String.format(" = R$%1.2f", workTrip.getDailySpentOnDriving()));

        MessageDialog.showInformationDialog(SOLIDARY_TRACK, message);
    }
}