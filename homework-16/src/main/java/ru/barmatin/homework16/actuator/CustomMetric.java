package ru.barmatin.homework16.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.BaseUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomMetric {
    private final MeterRegistry meterRegistry;

    @Autowired
    public CustomMetric(MeterRegistry meterRegistry){
        this.meterRegistry  = meterRegistry;

        Counter.builder("counter.added.books")
                .baseUnit(BaseUnits.EVENTS)
                .description("The number of added books")
                .register(meterRegistry);
    }

    public void incrementAddBookCounter(){
        meterRegistry.counter("counter.added.books").increment();
    }

}
