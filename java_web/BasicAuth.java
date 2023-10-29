import java.net.http.HttpClient;
import java.net.http.HttpServer;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.io.IOException;
import java.net.URI;

class  SimpleServer {
	private static HttpServer httpServer;

	public static void start() throws IOException {
		server = HttpServer.create(new InetSocketAddress(8000), 0);
		HttpContext ctx = server.createContext("/users", new UserHandler());
		ctx.setAuthenticator(new ApiRestBasicAuthentication("users"));

		server.start();
	}
}

class SimpleClient {
	private HttpClient httpClient;

	SimpleClient() {
		this.httpClient = HttpClient.newHttpClient();
	}

	HttpResponse makeRequest(String uri) {
		HttpRequest request = HttpRequest.newBuilder()
											.GET().uri(URI.create(uri)).build();
		try {
			HttpResponse response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			return response;
		} catch(Exception e) {
			System.err.println("Cannot send request");
		}

		System.exit(1);

		return null; // unreached
	}
}

public class BasicAuth {
	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();

		HttpResponse response = client.makeRequest("https://postman-echo.com/get");

		System.out.println(response.uri());
		System.out.println(response.version());
		System.out.println(response.statusCode());
	}
}