import com.linecorp.armeria.common.*;
import com.linecorp.armeria.server.AbstractHttpService;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.Produces;
import com.linecorp.armeria.server.logging.LoggingService;
import user.UserService;

import java.util.concurrent.CompletableFuture;

public class ServerMain {
    public static void main(String[] args) {
        ServerBuilder sb = Server.builder();
        sb.http(8080);

        sb.service("/", (ctx, req) -> HttpResponse.of("Hello world"));
        sb.annotatedService(new UserService());

        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
        future.join();
    }
}
