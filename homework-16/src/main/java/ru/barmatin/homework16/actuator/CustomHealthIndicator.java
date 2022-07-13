package ru.barmatin.homework16.actuator;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (RandomUtils.nextBoolean()) {
            return Health.up()
                    .withDetail("message", "function is working")
                    .build();
        } else {
            return Health.down()
                    .status(Status.DOWN)
                    .withDetail("message", "function is not working")
                    .build();
        }
    }

}
