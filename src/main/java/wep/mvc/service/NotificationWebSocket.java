package wep.mvc.service;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket", configurator = HttpSessionConfigurator.class)
public class NotificationWebSocket {
    private static Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        // HTTP 세션 정보 가져오기
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String userId = (String) httpSession.getAttribute("loginUserId"); // 로그인한 사용자 ID 가져오기

        System.out.println("New connection opened: " + session.getId() + " UserID: " + userId);
        clients.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // 모든 클라이언트에게 메시지 전송
        for (Session client : clients) {
            if (client.isOpen()) {
                client.getBasicRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Connection closed: " + session.getId());
    }
    
    public static void broadcast(String message) throws IOException {
    	
        for (Session client : clients) {
            if (client.isOpen()) {
                client.getBasicRemote().sendText(message);
            }
        }
    }
    
}
