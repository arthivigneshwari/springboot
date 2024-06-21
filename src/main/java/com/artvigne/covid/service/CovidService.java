package com.artvigne.covid.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class CovidService {

    /*@Value("${covid.url}")
    private String someUrl;*/

    private static final String url = "https://corona-virus-world-and-india-data.p.rapidapi.com/api_india_timeline";
    private static final String xrapidapkey = "4b14eb5bf6mshe29acf50d926039p13645bjsnb8494f4204a5";
    private static final String xrapidapihost = "corona-virus-world-and-india-data.p.rapidapi.com";


    @Autowired
    private RestTemplate restTemplate;

    public Object getAllCountryCovidData(){
        try{

            //Header values is set
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key",xrapidapkey);
            headers.set("x-rapidapi-host",xrapidapihost);

            //Make a Get call to the RapidApi
            ResponseEntity<String> response = restTemplate.exchange(url,
                                                                   HttpMethod.GET,
                                                                   new HttpEntity<>(headers),
                                                                   String.class);

            log.info("Output form RapidApi: {} ",response.getBody());

            return response.getBody();

        }catch(Exception e){
            log.error("Error while getting data from RapidApi",e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint of RapidApi for corona",
                    e
            );
        }

    }
}
