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
        DB db = new DB(userDB);
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
                            db.signUp();
                        }

                        break;
                    case 2:
                        if (user != null) {
                            System.out.println("이미 로그인 되었습니다.");
                        } else {
                            user = db.login();
                        }

                        break;
                    case 3:
                        if(user != null){
                            System.out.println("=== 회원 정보 수정 ===");
                            user = db.updateInfo(user.getId());
                        }else{
                            System.out.println("로그인 상태가 아닙니다.");
                        }
                        break;
                    case 4:
                        if (user != null) {
                            db.deleteUser(user.getId());
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
                            db.getInfo(user.getId());
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

class User{
    private String id;
    private String pw;
    private String name;

    User(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public void setUser(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }
}

class DB{
    HashMap<String,User> userDB;

    DB(HashMap<String,User> userDB){
        this.userDB = userDB;
    }

    public void signUp(){

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력해주세요. : ");
        String name = sc.nextLine();

        String id;
        System.out.print("ID를 입력해주세요. : ");
        id = sc.nextLine();
        while(this.userDB.containsKey(id)){
            System.out.print("사용 중인 ID입니다. 다른 ");
            System.out.print("ID를 입력해주세요. : ");
            id = sc.nextLine();
        }


        System.out.print("비밀번호를 입력해주세요. : ");
        String password = sc.nextLine();

        User user = new User(id,password, name);

        this.userDB.put(id,user);

        System.out.print("회원가입이 완료되었습니다. \n");
        System.out.printf("아이디: %s\n",this.userDB.get(id).getId());
        System.out.printf("이름: %s\n",this.userDB.get(id).getName());
    }

    public User login(){
        Scanner sc = new Scanner(System.in);

        System.out.print("ID를 입력해주세요. : ");
        String id = sc.nextLine();;

        System.out.print("비밀번호를 입력해주세요. : ");
        String password = sc.nextLine();

        if(this.userDB.containsKey(id)){
            if(this.userDB.get(id).getPw().equals(password)){
                System.out.println("로그인을 성공하셨습니다.");
                return this.userDB.get(id);
            }else{
                System.out.println("비밀번호가 틀렸습니다.");
                return null;
            }
        }else{
            System.out.println("존재하지 않은 ID입니다.");
                return null;
        }
    }


    public User updateInfo(String id) {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 이름을 입력해주세요. : ");
        String name = sc.nextLine();

        System.out.print("변경할 비밀번호를 입력해주세요. : ");
        String pw = sc.nextLine();

        userDB.get(id).setUser(name, pw);
        System.out.println("회원 정보 수정 완료!>.<");
        return userDB.get(id);
    }

    public User deleteUser(String id) {
        System.out.println("회원 탈퇴 완료! ㅜㅜ");
        return userDB.remove(id);
    }


    public void getInfo(String id){
        User user = this.userDB.get(id);
        System.out.printf("ID : %s\n", user.getId());
        System.out.printf("이름 : %s\n", user.getName());
    }
}