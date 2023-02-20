package com.daniel.zielinski.binanceconnector.infrastructure;

import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.AggTradeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
class BinancePriceWebSocketInitializer {

    private final BinanceApiWebSocketClient webSocketClient;
    private final BinancePriceCache binancePriceCache;

    @PostConstruct
    public void initializeBinanceStream() {
        startAggTradesEventStreaming(List.of("BTCUSDT", "ETHUSDT"));
    }

    public void startAggTradesEventStreaming(List<String> tickers) {
        log.info("Websocket binance client starting");
        tickers.forEach(this::startClient);
        log.info("Websocket binance client is live");
    }

    private void startClient(String ticker) {
        log.info("Starting client for ticker {}", ticker);
        webSocketClient.onAggTradeEvent(ticker.toLowerCase(), this::updatePriceCache);
    }

    private void updatePriceCache(AggTradeEvent event) {
        binancePriceCache.getPriceCacheMap().put(event.getSymbol(), new BigDecimal(event.getPrice()));
        log.info("Ticker {} price {}", event.getSymbol(), event.getPrice());
    }
}
