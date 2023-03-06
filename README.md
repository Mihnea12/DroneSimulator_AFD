# DroneSimulator_AFD

Pentru a rula programul trebuie sa fie instalat Java-ul
Programul se ruleaza din CMD(Command Prompt) cu ajutorul comenzii: java -jar SimulatorSDED.jar



Simulatorul dronei:
-pd ->pornirea dronei
-dgz -> diagnoza(este o sansa de 33% ca drona sa aiba o defectiune) ->programul se inchide
     -> daca drona nu are suficienta baterie(60%), drona se incarca -> 60% reprezinta bateria pentru un drum minim de aproximativ 7km
->distanta este data in coordonate X,Y. Distanta se caluleaza cu formula distantei Euclidiene. Pentru aproximare distanta este impartita la 10 cu reprezentare in km.
->daca drona nu are suficienta baterie pentru a parcurge o anumita distanta, trebuie introduse alte coordonate.
-dcomp -> deschidere compartiment -> se introduce coletul in compartimentul de depozitare(daca este mai greu de 5kg, trebuie introdus alt colet cu o greutate mai mica)
-icomp -> inchidere compartiment
-pm -> pornire motoare
-ra -> drona decoleaza -> se pot introduce evenimente pentru introducere obstacol(io) si modificarea altitudinii (ca), dar si un eveniment prin care drona are o defectiune si trebuie sa aterizeze de urgenta(adef)
-a -> drona aterizeaza
-sc -> scoaterea coletului din compartiment