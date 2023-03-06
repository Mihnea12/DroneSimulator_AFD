import java.io.IOException;
import java.util.Scanner;

public class Run {
    static void afisare(){
        System.out.println("************************************************************");
        System.out.println("Acesta este un simulator pentru o drona care livreaza colete");
    }

    public static void main(String[] args) {
        afisare();
        int n = 2; // Number of threads
        Drone myDrone = new Drone();
        for (int i=0; i<n; i++)
        {
            MultiThreading object = new MultiThreading(myDrone);
            object.start();

        }
    }
}
