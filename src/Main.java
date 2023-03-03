import java.util.Scanner;
public class Main {
        public static void pressAnyKey() {
            Scanner input = new Scanner(System.in);
            System.out.println("Press Enter to continue...!");
            input.nextLine();
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int floor = 0;
            int room = 0;
            int desireFloor;
            int desireRoom;
            String[][] condo = new String[0][];
            boolean isFloor = false;
            boolean isRroom = false;
            int option = 0;
            System.out.println("================== SET A CONDO =================");
            do {
                System.out.print("Enter number of floor : ");
                floor = input.nextInt();
                if (floor > 0) {
                    isFloor = true;
                    do {
                        System.out.print("Enter number of room : ");
                        room = input.nextInt();
                        if (room > 0) {
                            isRroom = true;
                            condo = new String[floor][room];
                            System.out.println("-----------------------------------------------------");
                            System.out.println("Congratulation...! You succeed of setting a condo...!");
                            System.out.println("Number of floor : " + floor + " floor" + ((floor > 1) ? "s" : ""));
                            System.out.println("Number of room : " + room + " room" + ((room > 1) ? "s" : ""));
                            System.out.println("Total of room : " + (floor * room) + " room" + ((room > 1) ? "s" : ""));
                        } else {
                            System.out.println("Room cannot be 0 or negative...!");
                        }
                    } while (!isRroom);
                } else {
                    System.out.println("Floor cannot be 0 or negative...!");
                }
                pressAnyKey();
            } while (!isFloor);
            do {
                System.out.println("================== Welcome to Condo Mana=================");
                System.out.println("1. Buy condo ");
                System.out.println("2. Sell condo ");
                System.out.println("3. Search condo information ");
                System.out.println("4. Display information ");
                System.out.println("5. Exit from the program ");
                System.out.println("==========================================================");
                System.out.print("Choose any option : ");
                option = input.nextInt();
                switch (option) {
                    case 1 -> {
                        String ownerName;
                        boolean isCondoValidInput = false;
                        do {
                            System.out.println("========================= Buying Condo ======================");
                            System.out.print("Enter your desire floor (1 - " + floor + ") : ");
                            desireFloor = input.nextInt();
                            if (desireFloor <= floor && desireFloor > 0) {
                                isFloor = true;
                                do {
                                    System.out.print("Enter your desire room (1 - " + room + ") : ");
                                    desireRoom = input.nextInt();
                                    if (desireRoom > 0 && desireRoom <= room) {
                                        if (condo[desireFloor - 1][desireRoom - 1] == null) {
                                            isRroom = true;
                                            isCondoValidInput = true;
                                            System.out.println("Enter owner name : ");
                                            input.nextLine();
                                            ownerName = input.nextLine();
                                            condo[desireFloor - 1][desireRoom - 1] = ownerName;
                                            System.out.println("Congratulation...! You have successfully bought a condo.");
                                        } else {
                                            System.out.println("This condo is already own by someone...!");
                                        }

                                    } else {
                                        System.out.println("Invalid room...!");
                                        isRroom = false;
                                    }
                                } while (!isRroom);

                            } else {
                                System.out.println("Invalid floor...!");
                                isFloor = false;
                            }
                        } while (!isCondoValidInput);
                    }
                    case 2 -> {
                        String ownerCondoName = null;
                        boolean isCondoValid = false;
                        int key;
                        do {
                            System.out.println("======================== Sell Condo ==========================");
                            System.out.print("Enter the desire floor for sell : ");
                            desireFloor = input.nextInt();
                            System.out.print("Enter the desire room for sell : ");
                            desireRoom = input.nextInt();
                            if (desireFloor > 0 && desireFloor <= floor && desireRoom > 0 && desireRoom <= room) {
                                first:
                                for (int i = (condo.length - 1); i >= 0; i--) {
                                    for (int j = 0; j < condo[i].length; j++) {
                                        if (condo[desireFloor - 1][desireRoom - 1] == condo[i][j]) {
                                            ownerCondoName = condo[i][j];
                                        }
                                    }
                                }
                                System.out.println("Floor " + desireFloor + " : Room " + desireRoom + " belong to " + ownerCondoName);
                                System.out.println("======================================================");
                                System.out.println("Press 1 to confirm or 0 to cancel...");
                                key = input.nextInt();
                                if (key == 1) {
                                    condo[desireFloor - 1][desireRoom - 1] = null;
                                } else {
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Error! Floor and room are required...!");
                                isRroom = false;
                            }
                        } while (!isRroom);
                    }
                    case 3 -> {

                        System.out.println("======================Search Condo Information======================");
                        int option1;
                        do {
                            System.out.println("1. Search by Owner Name : ");
                            System.out.println("2. Search by Floor : ");
                            System.out.println("3. Exit : ");
                            System.out.println("Choose an option : ");
                            option1=input.nextInt();
                            option1 = 0;
                            switch (option1) {
                                case 1 -> {
                                    System.out.println("==============Search by owner name===============");
                                    String ownername ;
                                    System.out.println("Enter Your Name");
                                    input.nextLine();
                                    ownername=input.nextLine();
                                }
                                case 2->{
                                    System.out.println("================== search by floor=================");
                                }
                                default -> System.out.println("Exit");
                            }
                        } while (true);


                    }
                    case 4 -> {
                        System.out.println("======================= Display Information ======================");
                        for (int i = (condo.length - 1); i >= 0; i--) {
                            System.out.print("Floor [" + (i + 1) + "]");
                            for (int j = 0; j < condo[i].length; j++) {
                                System.out.print("\t" + condo[i][j] + " ");

                            }
                            System.out.println();
                        }
                    }
                    case 5 -> {
                        System.out.println("======================= Search Condo Information ======================");
                        System.out.println();
                    }
                    default -> {
                        System.out.println("Wrong option...! Please choose from 1 to 5...!");
                    }
                }
            } while (option != 5);
        }
    }

