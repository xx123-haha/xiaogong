package com.xiaogong.demo03;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-29
 */
@Component
public class HttpUtils {

    private final WebClient webClient;

    public HttpUtils(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getSign(String interfaceName, String queryParam, String postParam) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(UrlConstants.HOST_URL_SIGN)
                .queryParam("interfaceName",interfaceName)
                .queryParam("appid", UrlConstants.APP_ID)
                .queryParam("appSecret", UrlConstants.APP_SECRET)
                .queryParam("random", UrlConstants.RANDOM)
                .queryParam("version", UrlConstants.VERSION)
                .queryParam("timestamp", nowTimeStampSecondStr())
                .queryParam("queryParams", String.format("access_token=%s", UrlConstants.ACCESS_TOKEN))
                .queryParam("postParams", postParam);

        // 打印请求的 URL
        System.out.println("Request URL: " + builder.toUriString());

        WebClient.ResponseSpec retrieve = webClient.get().uri(builder.build().toUri()).retrieve();
        Mono<String> stringMono = retrieve.bodyToMono(String.class);

        String string = stringMono.toString();

        return webClient.get()
                .uri(builder.build().toUri())
                .retrieve()
                .bodyToMono(String.class).toString();
    }

    public String nowTimeStampSecondStr() {
        Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        return String.valueOf(instant.getEpochSecond());
    }

}

