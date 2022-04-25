package br.com.zup.handora.zupedustore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.handora.zupedustore.aplicativo.Aplicativo;
import br.com.zup.handora.zupedustore.aplicativo.AplicativoRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final AplicativoRepository aplicativoRepository;

    public DataLoader(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (aplicativoRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        Aplicativo aplicativo = new Aplicativo(
            "Zup Edu Cursos", "Cursos produzidos pela Zup Edu.", "https://www.example.com"
        );

        aplicativoRepository.save(aplicativo);
    }

}
