package Main;

import java.io.PrintWriter;

import java.net.Socket;
import java.util.Scanner;


public class Client {
    
    private PrintWriter writer;
    //소켓을 통해 메세지 전송
    private Socket socket;
    
    public void start() {
      try {
        socket = new Socket("127.0.0.1", 12346);
        System.out.println("테스트용 서버에 접속했습니다.");
        //서버 접속
        writer = new PrintWriter(socket.getOutputStream(), true);
        //어떠한 메세지 전송
        Scanner scan = new Scanner(System.in);
        //실제로 사용자가 입력이 가능하도록 설정
        while (true) {
          writer.println(scan.next());
          //사용자가 입력하는 모든문자를 서버로 전송
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
}
