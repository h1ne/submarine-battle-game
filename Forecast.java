public class Forecast {

    static int[][] ef;


    Forecast(){
        makeEF();
    }
    
    public void makeEF(){
        int width = 5;
        int height = 5;

        ef = new int[width][height]; //EFを定義

        for(int y = 0;y < height; y++ ){
            for(int x = 0;x < width; x++){
                ef[x][y] = 0;
            }
        }
        /*for(int y = 0;y < 5; y++ ){
            System.out.print("\n");
            for(int x = 0;x < 5; x++){
                System.out.print( ef[x][y] );
            }
        }
        */
    }

    public static void setEF(int x,int y,int Type){
        ef[x][y] = Type;
    }

    public static void plusEF(int x,int y,int Type){
        ef[x][y] = ef[x][y] + Type;
    }
    public static void printEF(){
        for(int y = 0;y < 5; y++ ){
            System.out.print("\n");
            for(int x = 0;x < 5; x++){
                System.out.print( ef[x][y] );
            }
        }
    }

    public static void setCircleEF(int x,int y,int num){
         //座標の周辺8マスのEFをnumにする

         if(0 <= x-1 && x-1 <= 4 && 0 <= y+1 && y+1 <= 4){
            setEF(x-1,y+1,num);
        }

        if(0 <= x-1 && x-1<= 4){
            setEF(x-1,y,num);
        }
        
        if(0 <= x-1 && x-1 <= 4 && 0 <= y-1 && y-1 <= 4){
            setEF(x-1,y-1,num);
        }

        if(0 <= y-1 && y-1 <= 4){
            setEF(x,y-1,num);
        }

        if(0 <= x+1 && x+1 <= 4 && 0 <= y-1 && y-1 <= 4){
            setEF(x+1,y-1,num);
        }

        if(0 <= x+1 && x+1 <= 4){
            setEF(x+1,y,num);
        }

        if(0 <= x+1 && x+1<= 4 && 0 <= y+1 && y+1 <= 4){
            setEF(x+1,y+1,num);
        }

        if(0 <= y+1 && y+1 <= 4){
            setEF(x,y+1,num);
        }
    }

    public static void plusCircleEF(int x,int y,int num){
        //座標の周辺8マスのEFを+numする

        if(0 <= x-1 && x-1 <= 4 && 0 <= y+1 && y+1 <= 4){
           plusEF(x-1,y+1,num);
       }

       if(0 <= x-1 && x-1<= 4){
           plusEF(x-1,y,num);
       }
       
       if(0 <= x-1 && x-1 <= 4 && 0 <= y-1 && y-1 <= 4){
           plusEF(x-1,y-1,num);
       }

       if(0 <= y-1 && y-1 <= 4){
           plusEF(x,y-1,num);
       }

       if(0 <= x+1 && x+1 <= 4 && 0 <= y-1 && y-1 <= 4){
           plusEF(x+1,y-1,num);
       }

       if(0 <= x+1 && x+1 <= 4){
           plusEF(x+1,y,num);
       }

       if(0 <= x+1 && x+1<= 4 && 0 <= y+1 && y+1 <= 4){
           plusEF(x+1,y+1,num);
       }

       if(0 <= y+1 && y+1 <= 4){
           plusEF(x,y+1,num);
       }
   }

    public static int getEF(int x,int y){
        return ef[x][y];
    }
} 