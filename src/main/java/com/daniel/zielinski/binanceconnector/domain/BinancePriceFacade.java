package com.daniel.zielinski.binanceconnector.domain;

import com.daniel.zielinski.binanceconnector.infrastructure.BinancePriceCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BinancePriceFacade {

    private final BinancePriceCache binancePriceCache;

    public Optional<BigDecimal> getActualPrice(String symbol){
        return Optional.ofNullable(binancePriceCache.getPrice(symbol));
    }
}
