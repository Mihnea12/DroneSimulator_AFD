import java.util.Optional;
import java.util.Random;

public class Drone {
    public final int RANGE = 250;
    private boolean on = false;
    private int firstPower;
    private boolean diagnoza = false;
    private boolean repairDrone = false;
    private int battery;
    private boolean batteryCheck = true;
    private int x;
    private int y;
    private boolean coordinateDone = true;
    private boolean readX = false;
    private boolean readY = false;
    private int checkX;
    private int checkY;
    private boolean citireCoordonate = false;
    private double distance;
    private double maximumDistance;
    private boolean goodRoute;
    private boolean storageOpen;
    private boolean checkStorage = false;
    private int packageKg;
    private boolean readPackageKg = false;
    private boolean motors = false;
    private boolean takeOff = false;
    private boolean defection = false;
    private boolean findObstacle = false;
    private int obstacleLeftDistance;
    private int obstacleRightDistance;
    private boolean distanceDone = false;
    public final int OPTIMAL_ALTITUDE = 40;
    private int droneAltitude;
    private boolean wrongAltitude = false;
    private boolean newAltitude = false;
    private double returnDistance;
    private boolean middleDistance = false;
    private boolean finalLanding = false;
    private boolean pd = false;
    private boolean dgz = false;
    private boolean dcomp = false;
    private boolean icomp = false;
    private boolean pm = false;
    private boolean ra = false;
    private boolean adef = false;
    private boolean io = false;
    private boolean ca = false;
    private boolean a = false;
    private boolean sc = false;
    private int backToBase;

    Drone() {
        Random rand = new Random();
        firstPower = 0;
        battery = rand.nextInt(100) + 1;
        x = 0;
        y = 0;
        checkX = 0;
        checkY = 0;
        pd = true;
        backToBase = 0;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getFirstPower() {
        return firstPower;
    }

    public void setFirstPower(int firstPower) {
        this.firstPower = firstPower;
    }

    public boolean isDiagnoza() {
        return diagnoza;
    }

    public void setDiagnoza(boolean diagnoza) {
        this.diagnoza = diagnoza;
        Random rand = new Random();
        int number = rand.nextInt(3);
        if (number == 0) {
            setRepairDrone(true);
        } else {
            setRepairDrone(false);
        }
    }

    public boolean isRepairDrone() {
        return repairDrone;
    }

    public void setRepairDrone(boolean repairDrone) {
        this.repairDrone = repairDrone;
    }

    public boolean checkBattery() {
        if (battery >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public boolean isBatteryCheck() {
        return batteryCheck;
    }

    public void setBatteryCheck(boolean batteryCheck) {
        this.batteryCheck = batteryCheck;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isCoordinateDone() {
        return coordinateDone;
    }

    public void setCoordinateDone(boolean coordinateDone) {
        this.coordinateDone = coordinateDone;
    }

    public boolean isReadX() {
        return readX;
    }

    public void setReadX(boolean readX) {
        this.readX = readX;
    }

    public boolean isReadY() {
        return readY;
    }

    public void setReadY(boolean readY) {
        this.readY = readY;
    }

    public int getCheckX() {
        return checkX;
    }

    public void setCheckX(int checkX) {
        this.checkX = checkX;
    }

    public int getCheckY() {
        return checkY;
    }

    public void setCheckY(int checkY) {
        this.checkY = checkY;
    }

    public boolean isCitireCoordonate() {
        return citireCoordonate;
    }

    public void setCitireCoordonate(boolean citireCoordonate) {
        this.citireCoordonate = citireCoordonate;
    }

    public void findDistance() {
        distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        returnDistance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMaximumDistance() {
        return maximumDistance;
    }

    public void setMaximumDistance(double maximumDistance) {
        this.maximumDistance = maximumDistance;
    }

    public void checkRoute() {
        maximumDistance = RANGE * battery / 100;
        if (maximumDistance >= 2 * distance) {
            goodRoute = true;
        } else {
            goodRoute = false;
        }
    }

    public boolean isGoodRoute() {
        return goodRoute;
    }

    public void setGoodRoute(boolean goodRoute) {
        this.goodRoute = goodRoute;
    }

    public boolean isStorageOpen() {
        return storageOpen;
    }

    public void setStorageOpen(boolean storageOpen) {
        this.storageOpen = storageOpen;
    }

    public boolean isCheckStorage() {
        return checkStorage;
    }

    public void setCheckStorage(boolean checkStorage) {
        this.checkStorage = checkStorage;
    }

    public int getPackageKg() {
        return packageKg;
    }

    public void setPackageKg(int packageKg) {
        this.packageKg = packageKg;
    }

    public boolean isReadPackageKg() {
        return readPackageKg;
    }

    public void setReadPackageKg(boolean readPackageKg) {
        this.readPackageKg = readPackageKg;
    }

    public boolean isMotors() {
        return motors;
    }

    public void setMotors(boolean motors) {
        this.motors = motors;
    }

    public boolean isTakeOff() {
        return takeOff;
    }

    public void setTakeOff(boolean takeOff) {
        this.takeOff = takeOff;
    }

    public boolean isDefection() {
        return defection;
    }

    public void setDefection(boolean defection) {
        this.defection = defection;
    }

    public void randomDefection() {
        Random rand = new Random();
        int aux = rand.nextInt(11);
        if (aux == 0) {
            defection = true;
        }
    }

    public boolean isFindObstacle() {
        return findObstacle;
    }

    public void setFindObstacle(boolean findObstacle) {
        this.findObstacle = findObstacle;
    }

    public int getObstacleLeftDistance() {
        return obstacleLeftDistance;
    }

    public void setObstacleLeftDistance(int obstacleLeftDistance) {
        this.obstacleLeftDistance = obstacleLeftDistance;
    }

    public int getObstacleRightDistance() {
        return obstacleRightDistance;
    }

    public void setObstacleRightDistance(int obstacleRightDistance) {
        this.obstacleRightDistance = obstacleRightDistance;
    }

    public boolean isDistanceDone() {
        return distanceDone;
    }

    public void setDistanceDone(boolean distanceDone) {
        this.distanceDone = distanceDone;
    }

    public int getDroneAltitude() {
        return droneAltitude;
    }

    public void setDroneAltitude(int droneAltitude) {
        this.droneAltitude = droneAltitude;
    }

    public boolean isWrongAltitude() {
        return wrongAltitude;
    }

    public void setWrongAltitude(boolean wrongAltitude) {
        this.wrongAltitude = wrongAltitude;
    }

    public void checkAltituide(){
        if(droneAltitude > OPTIMAL_ALTITUDE){
            wrongAltitude = false;
            System.out.println("Drona zboara la o altitudine prea mare!");
            System.out.println("Drona coboara");
        }
        if(droneAltitude < OPTIMAL_ALTITUDE){
            wrongAltitude = false;
            System.out.println("Drona zboara la o altitudine prea mica!");
            System.out.println("Drona se ridica");
        }
    }

    public boolean isNewAltitude() {
        return newAltitude;
    }

    public void setNewAltitude(boolean newAltitude) {
        this.newAltitude = newAltitude;
    }

    public double getReturnDistance() {
        return returnDistance;
    }

    public void setReturnDistance(double returnDistance) {
        this.returnDistance = returnDistance;
    }

    public void move(){
        distance-= 10;
    }
    public void checkLocation(){
        if(distance < 0){
            System.out.println("Drona a ajuns la destinatie");
            System.out.println("Drona miscoreaza viteza motoarelor");
            System.out.println("Drona gaseste un loc pentru a ateriza");
            takeOff = false;
            a = true;
            ca = false;
            io = false;
            adef = false;
            backToBase ++;
            print();
        }
        if (!middleDistance) {
            if (distance <= (returnDistance / 2)) {
                System.out.println("Drona a ajuns la jumatatea drumului");
                middleDistance = true;
            }
        }
    }

    public boolean isFinalLanding() {
        return finalLanding;
    }

    public void setFinalLanding(boolean finalLanding) {
        this.finalLanding = finalLanding;
    }

    public boolean isPd() {
        return pd;
    }

    public void setPd(boolean pd) {
        this.pd = pd;
    }

    public boolean isDgz() {
        return dgz;
    }

    public void setDgz(boolean dgz) {
        this.dgz = dgz;
    }

    public boolean isDcomp() {
        return dcomp;
    }

    public void setDcomp(boolean dcomp) {
        this.dcomp = dcomp;
    }

    public boolean isIcomp() {
        return icomp;
    }

    public void setIcomp(boolean icomp) {
        this.icomp = icomp;
    }

    public boolean isPm() {
        return pm;
    }

    public void setPm(boolean pm) {
        this.pm = pm;
    }

    public boolean isRa() {
        return ra;
    }

    public void setRa(boolean ra) {
        this.ra = ra;
    }

    public boolean isAdef() {
        return adef;
    }

    public void setAdef(boolean adef) {
        this.adef = adef;
    }

    public boolean isIo() {
        return io;
    }

    public void setIo(boolean io) {
        this.io = io;
    }

    public boolean isCa() {
        return ca;
    }

    public void setCa(boolean ca) {
        this.ca = ca;
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean isSc() {
        return sc;
    }

    public void setSc(boolean sc) {
        this.sc = sc;
    }
    public void print(){
        if(backToBase == 2){
            System.out.println("Drona a juns la sediu");
        }
    }

    public int getBackToBase() {
        return backToBase;
    }

    public void setBackToBase(int backToBase) {
        this.backToBase = backToBase;
    }
}
