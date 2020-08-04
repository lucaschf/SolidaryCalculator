package tsi.too;

import tsi.too.controller.SolidaryTrack;

public class Application {
    public static void main(String[] args) {
        SolidaryTrack solidaryTrack = new SolidaryTrack();
        solidaryTrack.readData();
        solidaryTrack.showDailySpent();
        System.exit(0);
    }
}
