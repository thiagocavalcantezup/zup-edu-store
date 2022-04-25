package br.com.zup.handora.zupedustore.aplicativo;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(AplicativoController.BASE_URI)
public class AplicativoController {

    public final static String BASE_URI = "/aplicativos";

    private final AplicativoRepository aplicativoRepository;

    public AplicativoController(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @Transactional
    @PatchMapping("/{aplicativoId}/downloads")
    public ResponseEntity<Void> incrementarDownloads(@PathVariable Long aplicativoId) {
        Aplicativo aplicativo = aplicativoRepository.findById(aplicativoId)
                                                    .orElseThrow(
                                                        () -> new ResponseStatusException(
                                                            HttpStatus.NOT_FOUND,
                                                            "Não existe um aplicativo com o id informado."
                                                        )
                                                    );

        aplicativo.incrementarDownloads();

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{aplicativoId}/likes")
    public ResponseEntity<Void> incrementarLikes(@PathVariable Long aplicativoId) {
        Aplicativo aplicativo = aplicativoRepository.findById(aplicativoId)
                                                    .orElseThrow(
                                                        () -> new ResponseStatusException(
                                                            HttpStatus.NOT_FOUND,
                                                            "Não existe um aplicativo com o id informado."
                                                        )
                                                    );

        aplicativo.incrementarLikes();

        return ResponseEntity.noContent().build();
    }

}
