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

