package generators;

import dto.CreateUserRequest;
import org.apache.commons.lang3.RandomStringUtils;

public class User {
    public static CreateUserRequest generateNewRandomUser() {
        return CreateUserRequest.builder()
                .email(RandomStringUtils.randomAlphanumeric(9) + "@test.test")
                .password(RandomStringUtils.randomAlphanumeric(9))
                .name(RandomStringUtils.randomAlphanumeric(9))
                .build();
    }
}
