package user;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;

public class UserService {
    @Get("/users")
    public HttpResponse getUsers() {
        return HttpResponse.of("hello users");
    }

    @Get("/users/:id")
    public HttpResponse getUserById(@Param("id") String id) {
        return HttpResponse.of("hello user id : %s", id);
    }
}
