import java.util.Scanner;

public abstract class Attack {
    protected MapData mapData;
    protected AllyShipManager allyShipManager;

    public Attack(MapData mapData, AllyShipManager allyShipManager) {
        this.mapData = mapData;
        this.allyShipManager = allyShipManager;
    }

    public abstract void executeAttack(int x, int y);
}

class AllyAttack extends Attack {
    private Scanner scanner;

    public AllyAttack(MapData mapData, AllyShipManager allyShipManager, Scanner scanner) {
        super(mapData, allyShipManager);
        this.scanner = scanner;
    }

    @Override
    public void executeAttack(int x, int y) {
        if (!isAttackRangeValid(x, y, mapData)) {
            System.out.println("攻撃範囲外です。攻撃できません。");
            return;
        }

        int targetType = mapData.getMap((char) ('A' + y), x);

        if (targetType >= MapData.TYPE_EnemyShip_A && targetType <= MapData.TYPE_EnemyShip_D) {
            System.out.println("命中！");
        } else {
            System.out.println("攻撃結果を入力してください(1: 命中, 2: 波高し, 3: ハズレ）:");
            int feedbackOption = scanner.nextInt();
            scanner.nextLine();

            switch (feedbackOption) {
                case 1:
                    System.out.println("敵船に命中しました！");
                    mapData.placeEnemyShip((char) ('A' + y), x);
                    break;
                case 2:
                    System.out.println("波高しです。");
                    break;
                case 3:
                    System.out.println("ハズレです。");
                    break;
                default:
                    System.out.println("無効な入力です。");
                    break;
            }
        }
    }

    private static boolean isAttackRangeValid(int x, int y, MapData mapData) {
        int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < mapData.getWidth() && ny >= 0 && ny < mapData.getHeight()) {
                int cellType = mapData.getMap((char) ('A' + ny), nx);
                if (cellType >= MapData.TYPE_AllyShip_SSN001 && cellType <= MapData.TYPE_AllyShip_SSN004) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 敵からの攻撃を管理するクラス
class EnemyAttack extends Attack {
    public EnemyAttack(MapData mapData, AllyShipManager allyShipManager) {
        super(mapData, allyShipManager);
    }

    @Override
    public void executeAttack(int x, int y) {
        int targetType = mapData.getMap((char) ('A' + y), x);

        if (targetType >= MapData.TYPE_AllyShip_SSN001 && targetType <= MapData.TYPE_AllyShip_SSN004) {
            System.out.println("命中！");
            allyShipManager.updateShipHp(targetType, allyShipManager.getShipHp(targetType) - 1);
        } else {
            System.out.println("波高しまたはハズレ");
        }
    }
}
