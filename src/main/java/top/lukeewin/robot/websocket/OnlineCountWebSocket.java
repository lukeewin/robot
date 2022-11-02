package top.lukeewin.robot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Luke Ewin
 * @create 2022-10-31 16:22
 * 显示实时在线人数
 */
@Component
@ServerEndpoint("/onlineCount")
@Slf4j
public class OnlineCountWebSocket {

    // 存放所有的websocket连接
    private static CopyOnWriteArraySet<OnlineCountWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 建立连接时调用
    @OnOpen
    public void incrementOnlineCount(Session session) {
        this.session = session;
        webSocketSet.add(this);
        sendMessage(String.valueOf(webSocketSet.size()));
    }

    // 关闭连接时调用
    @OnClose
    public void decrementOnlineCount() {
        webSocketSet.remove(this);
        sendMessage(String.valueOf(webSocketSet.size()));
    }

    // 服务器主动向客户端发送消息
    private void sendMessage(String message) {
        for (OnlineCountWebSocket webSocketServer : webSocketSet) {
            webSocketServer.session.getAsyncRemote().sendText(message);
        }
    }
}
