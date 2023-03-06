import java.util.Scanner;

public class MultiThreading extends Thread {
    private boolean flag = true;
    private Drone myDrone;

    public void stopRunning() {
        flag = false;
    }

    MultiThreading(Drone myDrone) {
        this.myDrone = myDrone;

    }

    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
            Scanner sc = new Scanner(System.in);
            String command = new String();
            int coord = 0;
            if (Thread.currentThread().getId() == 15) {
                while (flag) {
                    if (!myDrone.isFinalLanding()) {
                        if (!myDrone.isCitireCoordonate()) {
                            command = sc.nextLine();
                        }
                    }
                    if (myDrone.getFirstPower() == 0) {
                        if (myDrone.isPd()){
                            if (command.equals("pd")) {
                                myDrone.setOn(true);
                                myDrone.setFirstPower(myDrone.getFirstPower() + 1);
                                command = "";
                                myDrone.setPd(false);
                                myDrone.setDgz(true);
                            }
                        }
                    } else {
                        if (myDrone.isDgz()){
                            if (command.equals("dgz")) {
                                myDrone.setDiagnoza(true);
                                myDrone.setCitireCoordonate(true);
                                command = "";
                            }
                        }
                        if (myDrone.isReadX()) {
                            System.out.print("X = ");
                            coord = sc.nextInt();
                            myDrone.setX(coord);
                            myDrone.setReadX(false);
                        }
                        if (myDrone.isReadY()) {
                            System.out.print("Y = ");
                            coord = sc.nextInt();
                            myDrone.setY(coord);
                            myDrone.setReadY(false);
                            System.out.println("Coordonatele de livrare sunt X = " + myDrone.getX() + " si Y = " + myDrone.getY());
                            myDrone.findDistance();
                            System.out.println("Drona trebuie sa parcurga pana la aceste coordonate " + (int) myDrone.getDistance() / 10 + " Km");
                            myDrone.checkRoute();
                            if (myDrone.isGoodRoute()) {
                                System.out.println("Drona poate sa parcurga drumul dus-intors");
                            } else {
                                System.out.println("Drona nu are suficienta baterie pentru a realiza acest drum. Trebuie introduse coordonate noi pentru al drum");
                                myDrone.setCoordinateDone(false);

                            }
                            myDrone.setCitireCoordonate(false);
                            myDrone.setDgz(false);
                            myDrone.setDcomp(true);
                        }
                        if (!myDrone.isFinalLanding()) {
                            if(myDrone.isDcomp()){
                                if (command.equals("dcomp")) {
                                    myDrone.setStorageOpen(true);
                                    command = "";
                                    System.out.println("Drona deschide compartimentul de depozitare al coletului");
                                    Thread.sleep(2000);
                                    myDrone.setCheckStorage(true);
                                    myDrone.setCitireCoordonate(true);
                                    myDrone.setDcomp(false);
                                    myDrone.setIcomp(true);
                                }
                            }
                            if (myDrone.isReadPackageKg()) {
                                System.out.print("Introduceti greutatea coletului(Kg) pe care vreti sa il introduceti in compartiment ");
                                coord = sc.nextInt();
                                if (coord <= 5) {
                                    myDrone.setPackageKg(coord);
                                    System.out.println("Pachetul este introdus in compartiment");
                                    myDrone.setReadPackageKg(false);
                                    myDrone.setCitireCoordonate(false);
                                } else {
                                    System.out.println("Pachetul pe care vreti sa il introduceti este prea greu!");
                                }
                                coord = 0;
                            }
                            if(myDrone.isIcomp()){
                                if (command.equals("icomp")) {
                                    myDrone.setStorageOpen(false);
                                    command = "";
                                    System.out.println("Drona inchide compartimentul de depozitare al coletului");
                                    Thread.sleep(2000);
                                    myDrone.setCheckStorage(true);
                                    myDrone.setIcomp(false);
                                    myDrone.setPm(true);
                                }
                            }
                            if(myDrone.isPm()){
                                if (command.equals("pm")) {
                                    myDrone.setMotors(true);
                                    command = "";
                                    System.out.println("Drona porneste motoarele");
                                    myDrone.setPm(false);
                                    myDrone.setRa(true);
                                }
                            }
                            if (myDrone.isRa()){
                                if (command.equals("ra")) {
                                    myDrone.setTakeOff(true);
                                    command = "";
                                    System.out.println("Drona decoleaza");
                                    myDrone.setDroneAltitude(myDrone.OPTIMAL_ALTITUDE);
                                    Thread.sleep(4000);
                                    System.out.println("Drona mareste viteza motoarelor");
                                    myDrone.setRa(false);
                                    myDrone.setAdef(true);
                                    myDrone.setIo(true);
                                    myDrone.setCa(true);
                                }
                            }
                            if (myDrone.isAdef()){
                                if (command.equals("adef")) {
                                    myDrone.setDefection(true);
                                    command = "";
                                }
                            }
                            if (myDrone.isIo()){
                                if (command.equals("io")) {
                                    myDrone.setFindObstacle(true);
                                    Thread.sleep(5000);
                                    System.out.println("Trebuie sa introduceti distantele pana la obiect");
                                    System.out.print("Dinstanta pana la punctul din stanga este = ");
                                    coord = sc.nextInt();
                                    myDrone.setObstacleLeftDistance(coord);
                                    System.out.print("Dinstanta pana la punctul din dreapta este = ");
                                    coord = sc.nextInt();
                                    myDrone.setObstacleRightDistance(coord);
                                    coord = 0;
                                    myDrone.setDistanceDone(true);
                                }
                            }
                            if (myDrone.isCa()){
                                if (command.equals("ca")) {
                                    myDrone.setWrongAltitude(true);
                                    System.out.println("Modificati altitudinea (in metri) de referinta!");
                                    System.out.print("Altituidinea = ");
                                    coord = sc.nextInt();
                                    myDrone.setDroneAltitude(coord);
                                    myDrone.setNewAltitude(true);
                                    coord = 0;
                                }
                            }
                            if (myDrone.isA()){
                                if (command.equals("a")) {
                                    System.out.println("Drona aterizeaza");
                                    Thread.sleep(2000);
                                    System.out.println("Drona a aterizat");
                                    myDrone.setFinalLanding(true);
                                    myDrone.setA(false);
                                    myDrone.setDcomp(true);
                                    if ( myDrone.getBackToBase() == 2){
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                        if (myDrone.isFinalLanding()) {
                            command = sc.nextLine();
                            if (myDrone.isDcomp()){
                                if (command.equals("dcomp")) {
                                    System.out.println("Drona deschide compartimenul de depozitare");
                                    myDrone.setStorageOpen(true);
                                    command = "";
                                    myDrone.setDcomp(false);
                                    myDrone.setSc(true);
                                }
                            }
                            if (myDrone.isSc()){
                                if (command.equals("sc")) {
                                    System.out.println("Drona elibereaza coletul din compartimentul de depozitare");
                                    myDrone.setPackageKg(0);
                                    command = "";
                                    myDrone.setSc(false);
                                    myDrone.setIcomp(true);
                                }
                            }
                            if (myDrone.isIcomp()){
                                if (command.equals("icomp")) {
                                    System.out.println("Drona inchide compartimentul de depozitare");
                                    myDrone.setStorageOpen(false);
                                    command = "";
                                    myDrone.setIcomp(false);
                                    myDrone.setRa(true);
                                }
                            }
                            if (myDrone.isRa()){
                                if (command.equals("ra")) {
                                    myDrone.setDistance(myDrone.getReturnDistance());
                                    myDrone.setTakeOff(true);
                                    command = "";
                                    System.out.println("Drona decoleaza. Pleaca inapoi spre sediu");
                                    myDrone.setDroneAltitude(myDrone.OPTIMAL_ALTITUDE);
                                    Thread.sleep(4000);
                                    System.out.println("Drona mareste viteza motoarelor");
                                    myDrone.setFinalLanding(false);
                                    myDrone.setRa(false);
                                    myDrone.setAdef(true);
                                    myDrone.setIo(true);
                                    myDrone.setCa(true);
                                }
                            }
                        }
                        Thread.sleep(4000);
                    }
                }
            }
            if (Thread.currentThread().getId() == 14) {
                while (true) {
                    if (myDrone.getFirstPower() <= 1) {
                        if (!myDrone.isOn()) {
                            System.out.println("Drona este oprita");
                        } else {
                            System.out.println("Drona este pornita");
                            myDrone.setFirstPower(myDrone.getFirstPower() + 1);
                        }
                    } else {
                        if (myDrone.isDiagnoza()) {
                            System.out.println("Drona isi face diagnoza");
                            Thread.sleep(2000);
                            myDrone.setDiagnoza(false);
                            if (myDrone.isRepairDrone()) {
                                System.out.println("Drona are nevoie de reparatii, si se opreste");
                            } else {
                                System.out.println("Drona a trecut testul de diagnoza");
                                Thread.sleep(2000);
                                myDrone.setBatteryCheck(false);
                            }
                        }
                        if (!myDrone.isBatteryCheck()) {
                            System.out.println("Drona are " + myDrone.getBattery() + "% baterie");
                            int initialBattery = myDrone.getBattery();
                            if (myDrone.checkBattery()) {
                                System.out.println("Drona are suficienta baterie pentru zbor");
                                myDrone.setBatteryCheck(true);
                            } else {
                                System.out.println("Drona nu are baterie si este pusa la incarcat");
                                while (myDrone.getBattery() < 60) {
                                    myDrone.setBattery(myDrone.getBattery() + 5);
                                    System.out.println("Drona se incarca");
                                    Thread.sleep(2000);
                                }
                                myDrone.setCoordinateDone(false);
                                myDrone.setBatteryCheck(true);
                                System.out.println("Drona are " + myDrone.getBattery() + "% baterie");
                            }
                            if (initialBattery >= 60) {
                                myDrone.setCoordinateDone(false);
                            }
                        }
                        if (!myDrone.isCoordinateDone()) {
                            myDrone.setCoordinateDone(true);
                            myDrone.setCitireCoordonate(true);
                            System.out.println("Introduceti coordonatele pentru livrare:");
                            myDrone.setReadX(true);
                            myDrone.setReadY(true);
                        }
                        if (myDrone.isCheckStorage()) {
                            myDrone.setCheckStorage(false);
                            if (myDrone.isStorageOpen()) {
                                System.out.println("Drona are compartimentul deschis");
                                myDrone.setReadPackageKg(true);
                            } else {
                                System.out.println("Drona are compartimentul inchis");
                            }
                        }
                        while (myDrone.isTakeOff()) {
                            if (!myDrone.isFindObstacle()) {
                                if (!myDrone.isWrongAltitude())
                                    System.out.println("Drona zboara");
                            }
                            if (myDrone.isDefection()) {
                                System.out.println("A aparut o defectiune in timpul zborului");
                                Thread.sleep(2000);
                                System.out.println("Drona aterizeaza de urgenta");
                                myDrone.setTakeOff(false);
                                Thread.sleep(2000);
                                System.out.println("Drona trimite semnale SOS pentru a putea fi ridicata");
                            }
                            if (myDrone.isFindObstacle()) {
                                System.out.println("Drona detecteaza un obstacol!");
                                Thread.sleep(1000);
                                System.out.println("Drona se opreste in zbor si calculeaza distantele pana la extremele obstacolului");
                                Thread.sleep(1000);
                                while (!myDrone.isDistanceDone()) {
                                    Thread.sleep(1000);
                                }
                                if (myDrone.isDistanceDone()) {
                                    if (myDrone.getObstacleLeftDistance() <= myDrone.getObstacleRightDistance()) {
                                        System.out.println("Drona ocoleste prin stanga obstacolul");
                                        Thread.sleep(2000);
                                        System.out.println("Drona revine la traseul initial");
                                        myDrone.setFindObstacle(false);
                                    } else {
                                        System.out.println("Drona ocoleste prin dreapta obstacolul");
                                        Thread.sleep(2000);
                                        System.out.println("Drona revine la traseul initial");
                                        myDrone.setFindObstacle(false);
                                    }
                                    myDrone.setDistanceDone(false);
                                }

                            }
                            if (myDrone.isWrongAltitude() && myDrone.isNewAltitude()) {
                                myDrone.checkAltituide();
                                Thread.sleep(2000);
                                System.out.println("Drona revine la traseu");
                                myDrone.setWrongAltitude(false);
                            }
                            if (!myDrone.isFindObstacle()) {
                                if (!myDrone.isWrongAltitude()) {
                                    myDrone.move();
                                    myDrone.checkLocation();
                                }
                            }
                            Thread.sleep(4000);
                        }
                    }
                    Thread.sleep(4000);
                }
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

