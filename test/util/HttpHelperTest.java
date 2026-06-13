package test.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HttpHelperTest {
    private static HttpServer server;
    private static String baseUrl;

    @BeforeAll
    public static void startServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/echo", new EchoHandler());
        server.start();
        int port = server.getAddress().getPort();
        baseUrl = "http://127.0.0.1:" + port;
    }

    @AfterAll
    public static void stopServer() {
        server.stop(0);
    }

    static class EchoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            byte[] body = exchange.getRequestBody().readAllBytes();
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        }
    }

    @Test
    public void testPostJson() throws Exception {
        String payload = "{\"hello\":\"world\"}";
        String url = baseUrl + "/echo";
        String resp = util.HttpHelper.postJson(url, payload);
        assertEquals(payload, resp);
    }

    @Test
    public void testPostJsonAsync() throws Exception {
        String payload = "{\"async\":true}";
        String url = baseUrl + "/echo";
        CompletableFuture<String> fut = util.HttpHelper.postJsonAsync(url, payload);
        String resp = fut.get();
        assertEquals(payload, resp);
    }
}
