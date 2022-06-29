public class TriangleDrawer {
    public static void main(String[] args){
        int col = 0, row = 0, SIZE = 5;
        while (col < SIZE){
            row = 0;
            while (row <= col){
                System.out.print('*');
                row ++ ;
            }
            System.out.println();
            col ++ ;
        }
    }
}
