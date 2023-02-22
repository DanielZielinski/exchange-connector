package com.daniel.zielinski.binanceconnector.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "app.binance")
public class BinanceProperties {

    private List<String> tickers;
}
