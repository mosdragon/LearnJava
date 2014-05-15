public class Family {
    public static void main(String[] args) {

        // Create a simple 2D array with known dimensions
        String[][] myNeighborhood = new String[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                myNeighborhood[i][j] = "Member" + j + " from family " + i;
            }
        }
        System.out.println("Families in myNeighborhood");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(myNeighborhood[i][j]);
            }
        }

        // Create a 2D array using input dimensions
        int numFamily = 6;
        int members = 4;
        String[][] myNeighborhood1 = new String[numFamily][members];
        for (int i = 0; i < numFamily; i++) {
            for (int j = 0; j < members; j++) {
                myNeighborhood1[i][j] = "Member" + j + " from family " + i;
            }
        }
        System.out.println("Families in myNeighborhood1");
        for (int i = 0; i < numFamily; i++) {
            for (int j = 0; j < members; j++) {
                System.out.println(myNeighborhood1[i][j]);
            }
        }

        // Create a 2D array that specifies the role of that member at specific index 
        String[][] myNeighborhood2 = new String[numFamily][members];
        for (int i = 0; i < numFamily; i++) {
            for (int j = 0; j < members; j++) {
                if (j == 0) {
                    myNeighborhood2[i][j] = "Member" + j + " from family " + i + " is the mother";
                } else if (j == 1) {
                    myNeighborhood2[i][j] = "Member" + j + " from family " + i + " is the father";
                } else if (j == 2) {
                    myNeighborhood2[i][j] = "Member" + j + " from family " + i + " is the daughter";
                } else {
                    myNeighborhood2[i][j] = "Member" + j + " from family " + i + " is the son";
                }
            }
        }

        System.out.println("Families in myNeighborhood2");
        for (int i = 0; i < numFamily; i++) {
            for (int j = 0; j < members; j++) {
                System.out.println(myNeighborhood2[i][j]);
            }
        }

        // You CANNOT nest a string array inside another string array
        // Because a string array only looks for string, not a string array
        // The code below will not compile
        //String[] myNeighborhood3 = new String[5];
        // for (int i = 0; i < myNeighborhood3.length; i++) {
        //     if ((i % 2) == 0) {
        //         String[] members = new String[i + 3];
        //         for (int j = 0; j < members.length; j++) {
        //             members[j] = "Member" + j + " from family " + i;
        //         }
        //         myNeighborhood3[i] = members;
        //     } else {
        //         System.out.println("Odd index");
        //     }
        // }
    }
}