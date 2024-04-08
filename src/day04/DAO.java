package day04;

import java.util.HashMap;
import java.util.Scanner;

public class DAO{
    HashMap<String,User> userDB;

    DAO(HashMap<String,User> userDB){
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
