package PPotatos;

import java.util.Scanner;

public class GameController {

    Scanner sc = new Scanner(System.in);

    /* 시작 위치 */
    private int posX = 0;
    private int posY = 0;

    /* 체력 */
    private int hp = 100;

    /* 음식 이름 입력 받을 문자열 */
    private String food;
    private String foodNoBlank; // 공백 제거

    /* 미리 가서 이동 가능한 곳인지 파악하는 변수 */
    private int nx = 0;
    private int ny = 0;

    /* getter (posX, posY, hp는 User에서도 접근해야 한다.) */
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHp() {
        return hp;
    }

    /* 이동 */
    public void goUp () {
        nx = posX;
        ny = posY - 1;
        if (nx >= 0 && ny >= 0) {       // x와 y는 0 미만이 될 수 없음
            System.out.println("위로 한 칸 이동했습니다!");
            losingHp();
            posY = ny;
        } else System.out.println("이동할 수 없습니다!");
    }

    public void losingHp () {        // 남은 체력에 따라 체력을 잃을 때의 대응 방법이 달라진다.
        if (hp >= 5)  {              // 5 이상일 시 -5를 문제없이 실행
            hp -= 5;
        } else if (hp > 0){         // 남은 hp가 5보다 작다면 음수로 가지 않고 0으로
            hp = 0;
        } else {                    // 남은 hp가 5보다 작다면 (즉, 경고를 무시한 채 이동) 음수로
            hp -= 5;
        }
    }

    public void goRight () {
        nx = posX + 1;
        ny = posY;
        if (nx >= 0 && ny >= 0) {                            // x와 y는 0 미만 X
            System.out.println("오른쪽으로 한 칸 이동했습니다!");
            losingHp();
            posX = nx;
        } else System.out.println("이동할 수 없습니다!");
    }

    public void goDown () {
        nx = posX;
        ny = posY + 1;
        if (nx >= 0 && ny >= 0) {                           // x와 y는 0 미만 X
            System.out.println("아래로 한 칸 이동했습니다!");
            losingHp();
            posY = ny;
        } else System.out.println("이동할 수 없습니다!");
    }

    public void goLeft () {
        nx = posX - 1;
        ny = posY;
        if (nx >= 0 && ny >= 0) {                           // x와 y는 0 미만 X
            System.out.println("왼쪽으로 한 칸 이동했습니다!");
            losingHp();
            posX = nx;
        } else System.out.println("이동할 수 없습니다!");
    }


    /* 먹기 */
    public void eat() {
        System.out.print("드실 음식을 선택해주세요 : ");
        food = sc.nextLine();
        foodNoBlank = food.replace(" ", ""); // 입력된 문자열에서 공백 제거

        if (!foodNoBlank.isEmpty()) {                         // 음식 이름을 입력했다면

            /* 음식 이름 문자열 길이만큼 체력 회복 (공백은 제외) */
            System.out.println(food + "(을)를 드셨습니다. 체력이 " + foodNoBlank.length() + " 회복되었습니다!");
            hp += foodNoBlank.length();
        } else {

            /* 입력한 문자열이 없거나 공백만 입력 */
            System.out.println("입력된 음식이 없습니다!");
        }
    }
}
