# JavaServer
- 자바 언어로 소켓서버를 여는 코드입니다
- 개인 공부를 하며 따라만든 코드입

### ClientCode
- Client
```
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
```
- Main
```
package Main;

public class Main {

  public static void main(String[] args) {
    
    Client client = new Client();
    client.start();
  }
}
```

### ServerCode
- Server
```
package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  // 클라이언트가 보낸 정보
  private BufferedReader reader;
  // 실제로 서버역할을 해주는 단자
  private ServerSocket server = null;

  private Socket socket;

  public void start() {
    try {
    server = new ServerSocket(12346);
    System.out.println("서버가 활성화되었습니다.");
    System.out.println("클라이언트로 접속을 해주세요.");
    while(true) {
    //클라이언트 접속 대기
      socket = server.accept();
    //해당 사용자가 보내는 메세지 수신
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage();
    }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
          if(reader != null) reader.close();
          if(socket != null) socket.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
   
  }
	public void getMessage() {
	
		try {
				while(true) {
						System.out.println("클라이언트: "+ reader.readLine());
			}
		} catch (Exception e){
		e.printStackTrace();
		}
		
	}
	
}

```
- Main
```
package main;

public class main {
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
```
