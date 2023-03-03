import java.util.Scanner;

public class Condo {
    public static void main(String[] args) {
        int room;
        int floor;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter room : ");
        room = input.nextInt();
        System.out.print("Enter floor : ");
        floor = input.nextInt();
        String[][] condo = new String[floor][room];
        while (true){
            int choose;
            System.out.println(" 1. Buy condo : ");
            System.out.println(" 2. Sell condo : ");
            System.out.println(" 3. Search Name Information : ");
            System.out.println(" 4. Displays Information : ");
            System.out.println(" 5. Exit : ");
            System.out.println(" -> Choose one Option form (1-5) : ");
            choose = input.nextInt();
            switch (choose){
                case 1:
                    System.out.println(" Buy Condo : ");
                    int buyfloor;
                    int buyroom;
                    System.out.print("Enter Your Desired floor : ");
                    buyfloor = input.nextInt();
                    System.out.print("Enter Your Desired room : ");
                    buyroom = input.nextInt();
                    if(condo[buyfloor - 1] [buyroom -1] == null){
                        String name;
                        System.out.print("Input Name : ");
                        input.nextLine();
                        name = input.nextLine();
                        condo[buyfloor -1] [buyroom -1] = name;

                    }
                    else {
                        System.out.println("This room is not aviable");
                    }
                    break;
                case 2:
                    System.out.println("Sell condo : ");
                    int sellfloor;
                    int sellroom;
                    System.out.println("Enter floor for sell : ");
                    sellfloor = input.nextInt();
                    System.out.println("Enter room for sell : ");
                    sellroom = input.nextInt();
                    if(condo[sellfloor -1] [sellroom -1] != null){
                        condo [sellfloor -1] [sellroom -1] = null;
                        System.out.println("Sell successful : ");
                    }
                    else {
                        System.out.println("This room no owner : ");
                    }
                    break;
                case 3:
                    System.out.println("Search Name Information : ");
                    String namesearch;
                    System.out.println("Enter Your Name for search");
                    input.nextLine();
                    namesearch = input.nextLine();
                    for (int i=0;i< condo.length;i++){
                        for (int j=0;j<condo[i].length;j++){
                            if(namesearch.equals(condo[i][j])){
                                System.out.print(" Search Found : " +condo[i][j]+" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Displays Information : ");
                    //condo.length yy pi row ;
                    for (int i=0;i< condo.length;i++){
                        System.out.print("floor : " + (i+1)+ " ");
                        for (int j=0;j<condo[i].length;j++){
                            System.out.print(condo[i][j]+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Exit : ");
                default:
                    System.out.println("You Choose not correct : ");
            }

        }
    }
}
