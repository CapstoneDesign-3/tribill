package com.example.jwtsecurityfin.service.currency;

import com.example.jwtsecurityfin.dto.response.ExchangeRateResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {

    private final RestTemplate restTemplate = new RestTemplate();

    // 매일 자정마다 실행되도록 설정
//    @Scheduled(cron = "0 0 0 * * *")
    public ExchangeRateResponse fetchExchangeRateData() {
        String apiUrl = "https://v6.exchangerate-api.com/v6/69caa501e7b43ee60009f2e3/latest/KRW?apiKey=69caa501e7b43ee60009f2e3";
        // API 호출 및 데이터 가져오기
        ExchangeRateResponse response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

        // 가져온 환율 정보를 처리하는 로직 작성
        // 예시: 로그에 출력
        System.out.println("Exchange rates: " + response.getTerms_of_use());
        return restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

    }
}
