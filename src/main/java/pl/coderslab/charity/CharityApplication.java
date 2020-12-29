package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import pl.coderslab.charity.converter.DonationConverter;

@SpringBootApplication
public class CharityApplication {


    public static void main(String[] args) {

        SpringApplication.run(CharityApplication.class, args);
    }
//
//    @Bean
//    public Converter donationConverter(){
//        return new DonationConverter ();
//    }
//
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(donationConverter());
//
//    }


}
