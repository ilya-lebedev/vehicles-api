package com.udacity.vehicles.client.prices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *  Price Client for fetching price data.
 */
@FeignClient(name = "pricing-service")
public interface PriceClient {

    /**
     * Gets a vehicle price from the pricing client, given vehicle ID.
     * @param vehicleId ID number of the vehicle for which to get the price
     * @return Price of the requested vehicle.
     */
    @GetMapping("/prices/{id}")
    Price getPrice(@PathVariable("id") Long vehicleId);

}
