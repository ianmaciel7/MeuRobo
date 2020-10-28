package ianmaciel;

import robocode.*;
import robocode.util.Utils;


public class T90 extends AdvancedRobot {
    private boolean peek;
    private HitByBulletEvent hitByBulletEvent;


    public void run() {

        double moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        peek = false;
        setAdjustGunForRobotTurn(false);
        peek = true;

        while (true) {
            peek = true;
            setAhead(moveAmount);
            setTurnGunLeft(360);
            peek = false;

            turnRight(60);
            setTurnGunLeft(360);

        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (peek) {
            scan();
        }
        double radarTurn = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();
        setTurnGunRightRadians(Utils.normalRelativeAngle(radarTurn));
        smartFire(e.getDistance());
    }

    private void smartFire(double robotDistance) {

        if ((robotDistance > 200 && getEnergy() > 30) || getEnergy() < 15) {
            setFire(1);
            setFire(1);
            setFire(1);
            setFire(1);

        } else if (robotDistance > 50) {
            setFire(2);
            setFire(2);
        } else {
            setFire(3);
        }
    }

    public void onHitRobot(HitRobotEvent e) {

        if (e.getBearing() > -90 && e.getBearing() < 90) {
            setBack(100);
        } else {
            setAhead(100);
        }

    }

    public void onHitByBullet(HitByBulletEvent e) {

        if (hitByBulletEvent != null) {

            if (hitByBulletEvent.getName().equalsIgnoreCase(e.getName())) {
                setTurnGunRightRadians(360);
            }
        }

        hitByBulletEvent = e;
    }

    public void onHitWall(HitWallEvent event) {
        double radarTurn = getHeadingRadians() + event.getBearingRadians() - getRadarHeadingRadians();


        if (getGunHeat() > 1.0) {
            setAhead(300);
        } else {
            setTurnGunRightRadians(Utils.normalRelativeAngle(radarTurn));
            setBack(300);
        }
    }
}
