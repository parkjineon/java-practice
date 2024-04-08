package day04;


//스캐너(콘솔 입력)로 사용자에게 회원가입 입력, 로그인 입력, 회원정보 수정, 회원 탈퇴, 로그아웃, 회원정보 조회)
// 1) 메뉴 1~6 / 2) 기능

// 스캐너 : 사용자 입력(id, pw, 이름) + 유효성
// 오후에 회원가입, 로그인 ,회원정보 수정, 회원 탈퇴를
// DAO / Repository : DB와 소통(를 대체 클래스)
// => class DAO {Map db /}

import java.util.HashMap;
import java.util.Scanner;

public class MemberService{

    public static void main(String[] args) {

        // userDB
        // 각 row {id : "", pw: "", name: ""}

        HashMap<String,User> userDB = new HashMap<>();
        User user = null;
        DAO dao = new DAO(userDB);
        int menu = 100;
        while(menu != 0){
            Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println("1번 회원가입");
            System.out.println("2번 로그인");
            System.out.println("3번 회원 정보 수정");
            System.out.println("4번 회원탈퇴");
            System.out.println("5번 로그아웃");
            System.out.println("6번 회원 정보 확인");
            System.out.println("0번 종료");
            System.out.println("------------------------------");
            System.out.print("메뉴를 입력해주세요. : ");

            try{
                menu =  sc.nextInt();
                System.out.println();
                switch (menu){
                    case 1:
                        if (user != null) {
                            System.out.println("이미 로그인 되었습니다.");
                        } else {
                            dao.signUp();
                        }

                        break;
                    case 2:
                        if (user != null) {
                            System.out.println("이미 로그인 되었습니다.");
                        } else {
                            user = dao.login();
                        }

                        break;
                    case 3:
                        if(user != null){
                            System.out.println("=== 회원 정보 수정 ===");
                            user = dao.updateInfo(user.getId());
                        }else{
                            System.out.println("로그인 상태가 아닙니다.");
                        }
                        break;
                    case 4:
                        if (user != null) {
                            dao.deleteUser(user.getId());
                            user = null;
                        } else {
                            System.out.println("로그인 상태가 아닙니다.");
                        }
                        break;
                    case 5:
                        if (user != null) {
                            user = null;
                            System.out.println("로그아웃이 완료되었습니다.");
                        } else {
                            System.out.println("이미 로그아웃 상태입니다.");
                        }

                        break;
                    case 6:
                        if (user != null) {
                            System.out.println("==== 현재 회원 정보 =====");
                            dao.getInfo(user.getId());
                        } else {
                            System.out.println("로그인 상태가 아닙니다.");
                        }

                        break;
                    case 0:
                        System.out.println("서비스가 종료됩니다. 안녕히 가세요.");
                        break;
                    default:
                        System.out.println("0~6까지 입력하라고 했습니다?");
                        break;
                }
            }catch(Exception e){
                System.out.println("다시 선택해주세요. (0~6" +
                        ") 정수로 입력");
            }


        }



    }
}



