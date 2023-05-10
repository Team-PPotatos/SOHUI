package PPotatos;

import java.util.Scanner;

public class User {

    GameController gc = new GameController();
    Scanner sc = new Scanner(System.in);

    private String act;                       // 유저 입력

    public void gameStart() {               // main에서 게임 실행을 위한 시작 함수
        do {
            System.out.println("==========================");
            System.out.println("|       UP               |");
            System.out.println("| LEFT  +  RIGHT    EAT  |");
            System.out.println("|      DOWN              |");
            System.out.println("==========================");

            System.out.println("현재 위치 : [" + gc.getPosX() + ", " + gc.getPosY() + "]");

            if (gc.getHp() == 0) {
                System.out.println("경고! 체력이 바닥났습니다. 회복해주세요!");
            }

            System.out.println("체력 : " + gc.getHp());

            System.out.print("행동을 정해주세요 : ");
            act = sc.nextLine();

            switch (act) {
                case "UP":
                    goUp();
                    break;

                case "RIGHT":
                    goRight();
                    break;

                case "DOWN":
                    goDown();
                    break;

                case "LEFT":
                    goLeft();
                    break;

                case "EAT":
                    eat();
                    break;

                case "BYE":
                    System.out.println("게임을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 입력입니다!");
            }

            if (gc.getHp() < 0) {                                       // 경고문 이후 이동을 했을 경우
                System.out.println("체력이 없어 더 이상 진행할 수 없습니다!");
                System.out.println("게임을 종료합니다.");
                return;
            }
        } while (!"BYE".equals(act));
    }

    /* 이동 */
    public void goUp () {
        gc.goUp();
    }

    public void goRight () {
        gc.goRight();
    }

    public void goDown () {
        gc.goDown();
    }

    public void goLeft () {
        gc.goLeft();
    }

    /* 먹기 */
    public void eat () {
        gc.eat();
    }

}
