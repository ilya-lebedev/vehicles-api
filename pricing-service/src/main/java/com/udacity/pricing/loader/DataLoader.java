package com.udacity.pricing.loader;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

/**
 * Data Loader
 */
@Component
public class DataLoader implements ApplicationRunner {

    private PriceRepository priceRepository;

    public DataLoader(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        LongStream.range(0, 100).forEach(i -> {
            priceRepository.save(new Price("USD", randomPrice(), i));
        });
    }

    /**
     * Gets a random price to fill in for a given vehicle ID.
     * @return random price for a vehicle
     */
    private static BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
    }

}
