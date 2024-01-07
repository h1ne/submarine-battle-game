import java.awt.Point;

public class Algorithm {
    private Point currentLocation;
    private MapData mapData;

    Algorithm(){

        int enemyAlgorithmChecker = 0;
        int allyContinuousHitChecker = 0;
        
    }
    

    public static void allyAttackAlgorithm(){

        if (/*こちらの攻撃がハズレ */){

            //攻撃座標とその周辺のEFを0にする

            Forecast.setEF(/*攻撃したx座標 */,/*攻撃したy座標 */,0);
            Forecast.setCircleEF(/*攻撃したx座標 */,/*攻撃したy座標 */,0)

            //連続ヒット回数を0に設定
            allyContinuousHitChecker = 0;

            
        }

        if(/*こちらの攻撃が波高し */){

            //攻撃座標の周辺8マスのEFを+1する

            Forecast.plusCircleEF(/*攻撃したx座標 */,/*攻撃したy座標 */,1)

            //連続ヒット回数を0に設定
            allyContinuousHitChecker = 0;
        }

        if(/*こちらの攻撃がヒット */){

            allyContinuousHitChecker = allyContinuousHitChecker +1;

            //敵のアルゴリズムを解析開始、敵が被弾後すぐ逃げるアルゴリズムだと分かったらenemyAlgorithmCheckerを1にする
            //連続ヒット回数をenemyContiumousHitCheckerに記録し逃げるかどうか判断する

            if(allyContinuousHitChecker > 0){
                //敵のアルゴリズムが被弾後すぐ逃げるものだと判明したため連続攻撃解除
                enemyAlgorithmChecker = 1;
            }

            if(enemyAlgorithmChecker == 0){

                //ヒットした座標のEFを最大値に設定し、連続攻撃
                for( i = 0; i <= 4 ;i++){
                    for( j = 0; j <= 4;j++){
                        if(getEF(i,j) > getEF(/*攻撃したx座標 */,/*攻撃したy座標 */)){
                            setEF(/*攻撃したx座標 */,/*攻撃したy座標 */,getEF(i,j)+1);
                        }
                    }
                }
            }else{
                
                //攻撃座標の周辺8マスのEFを+1する

                Forecast.plusCircleEF(/*攻撃したx座標 */,/*攻撃したy座標 */,1)
                
      
            }
        }

    }
    
    public void enemyAttackAlgorithm(){
        if(/*敵の攻撃がハズレ */){
            //攻撃座標の周辺8マスのEFを+1する

            Forecast.plusCircleEF(/*攻撃されたx座標 */,/*攻撃されたy座標 */,1)

        }

        if(/*敵の攻撃が波高し */){
            //攻撃座標の周辺8マスのEFを+1する

            Forecast.plusCircleEF(/*攻撃されたx座標 */,/*攻撃されたy座標 */,1)
            
        }

        if(/*敵の攻撃がヒット */){
            //攻撃座標の周辺8マスのEFを+1する

            Forecast.plusCircleEF(/*攻撃されたx座標 */,/*攻撃されたy座標 */,1)
            
        }
        
    }

    //攻撃や移動などこちらの動作を行うメソッド
    public void allyAction(MapData mapData){
        this.currentLocation = new Point(x, y);
        this.mapData = mapData;

        int move = 0;
        int attack = 0;
        //陣形を作れていなければ移動、作れていれば攻撃
        if(mapData.getMap(B,2) == 1 ||mapData.getMap(B,2) == 2 ||mapData.getMap(B,2) == 3 mapData.getMap(B,2) == 4 ){
            if(mapData.getMap(B,4) == 1 ||mapData.getMap(B,4) == 2 ||mapData.getMap(B,4) == 3 mapData.getMap(B,4) == 4 ){
                if(mapData.getMap(D,2) == 1 ||mapData.getMap(D,2) == 2 ||mapData.getMap(D,2) == 3 mapData.getMap(D,2) == 4 ){
                    if(mapData.getMap(D,4) == 1 ||mapData.getMap(D,4) == 2 ||mapData.getMap(D,4) == 3 mapData.getMap(D,4) == 4 ){
                        attack = 1;
                    }else{
                        move = 1;
                    }
                }else{
                    move = 2;
                }
            }else{
                move = 3;
            }   

        }else{
            move = 4;
        }
        
        if(move == 1){
            //B2に最寄りの潜水艦を移動させる
        }
        if(move == 2){
            //B4に最寄りの潜水艦を移動させる
        }
        if(move == 3){
            //D2に最寄りの潜水艦を移動させる
        }
        if(move == 4){
            //D4に最寄りの潜水艦を移動させる
        }
        if(attack ==1){
            //攻撃実行
        }

        //敵が移動したときのアルゴリズム
        public int[] enemyMoveAlgorithm(char direction,int distance){
            int[25] maybeEnemyX;
            int[25] maybeEnemyY;
            int[25] forecastEnemyX;
            int[25] forecastEnemyY;
            int i = 0;
            //EFが3以上の座標を記録
            for(int x = 0; x <= 4;x++){
                for(int y = 0; y <= 4;y++){
                    if(Forecast.getEF(x,y) >= 3){
                        maybeEnemyX[i] =x;
                        maybeEnemyY[i] =y;
                        i++
                    }
                }
            }

            //記録した座標を敵の動作をもとにずらす
            if(direction == e){
                for( j = 0; j <= i;j++){
                    if(0 <= maybeEnemyX[j] + distance && maybeEnemyX[j] + distance <= 4){
                        forecastEnemyX[j] = maybeEnemyX[j] + distance;
                        forecastEnemyY[j] = maybeEnemyY[j];
                    }
                    
                }

            }

            if(direction == w){
                for( j = 0; j <= i;j++){
                    if(0 <= maybeEnemyX[j] - distance && maybeEnemyX[j] - distance <= 4){
                        forecastEnemyX[j] = maybeEnemyX[j] - distance;
                        forecastEnemyY[j] = maybeEnemyY[j];
                    }
                    
                }
                
            }

            if(direction == s){
                for( j = 0; j <= i;j++){
                    if(0 <= maybeEnemyY[j] + distance && maybeEnemyY[j] + distance <= 4){
                        forecastEnemyX[j] = maybeEnemyX[j];
                        forecastEnemyY[j] = maybeEnemyY[j] + distance;
                    }
                    
                }
                
            }

            if(direction == n){
                for( j = 0; j <= i;j++){
                    if(0 <= maybeEnemyY[j] - distance && maybeEnemyY[j] - distance <= 4){
                        forecastEnemyX[j] = maybeEnemyX[j];
                        forecastEnemyY[j] = maybeEnemyY[j] - distance;
                    }
                    
                }
                
            }

    }
}
    

    // public void test(){
    //     // if(0 <= 4-1 && 4-1<= 4 && 0 <= 4+1 && 4+1<= 4){
    //     //     Forecast.setEF(4-1,4+1,1);
    //     // }

    //     // if(0 <= 4-1 && 4-1 <= 4){
    //     //     Forecast.setEF(4-1,4,1);
    //     // }
        
    //     // if(0 <= 4-1 && 4-1<= 4 && 0 <= 4-1 && 4-1<= 4){
    //     //     Forecast.setEF(4-1,4-1,1);
    //     // }

    //     // if(0 <= 4-1 && 4-1<= 4){
    //     //     Forecast.setEF(4,4-1,1);
    //     // }

    //     // if(0 <= 4+1 && 4+1<= 4 && 0 <= 4-1 && 4-1<= 4){
    //     //     Forecast.setEF(4+1,4-1,1);
    //     // }

    //     // if(0 <= 4+1 && 4+1 <= 4){
    //     //     Forecast.setEF(4+1,4,1);
    //     // }

    //     // if(0 <= 4+1 &&4+1 <= 4 && 0 <= 4+1 && 4+1 <= 4){
    //     //     Forecast.setEF(4+1,4+1,1);
    //     // }

    //     // if(0 <= 4+1 && 4+1 <= 4){
    //     //     Forecast.setEF(4,4+1,1);
    //     // }
    //     Forecast.setCircleEF(3,3,1);
    //     Forecast.setCircleEF(4,4,2);
    //     Forecast.plusCircleEF(3,3,1);

    // }