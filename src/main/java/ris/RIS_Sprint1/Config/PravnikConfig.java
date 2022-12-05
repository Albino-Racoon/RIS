package ris.RIS_Sprint1.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ris.RIS_Sprint1.dao.PravnikRepository;
import ris.RIS_Sprint1.models.Pravnik;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class PravnikConfig {
/*    @Bean
    CommandLineRunner commandLineRunner(PravnikRepository repository){
        return args -> {
            Pravnik nik = new Pravnik(1L,"nik","nik.jakopin@gmail.com", LocalDate.of(2001, Month.AUGUST, 5));
            repository.saveAll(List.of(nik));
        };
    }
*/
}
