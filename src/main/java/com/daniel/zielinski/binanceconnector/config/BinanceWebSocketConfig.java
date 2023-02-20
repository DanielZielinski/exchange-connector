package com.daniel.zielinski.binanceconnector.config;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceWebSocketConfig {

    @Bean
    public BinanceApiWebSocketClient getBinanceWebsocketClient(){
        return BinanceApiClientFactory.newInstance().newWebSocketClient();
    }
}
