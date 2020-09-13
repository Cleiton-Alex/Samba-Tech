package projeto.SambaTech.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projeto.SambaTech.dtos.MidiasDto;
import projeto.SambaTech.entities.Midias;
import projeto.SambaTech.response.Response;
import projeto.SambaTech.services.MidiasService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/midias")
@CrossOrigin(origins = "*")
public class MidiasController {
    private static final Logger log = LoggerFactory.getLogger(MidiasController.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private MidiasService midiasService;

    public MidiasController() {

    }


    @PostMapping
    public ResponseEntity<Response<MidiasDto>> adicionar(@Validated @RequestBody MidiasDto midiasDto,
                                                         BindingResult result) throws ParseException {

        log.info("Adicionando mídias: {} ", midiasDto.toString());
        Response<MidiasDto> response = new Response<>();
        validarMidias(midiasDto, result);
        Midias midias = this.converterDtoParaMidia(midiasDto);

        if (result.hasErrors()) {
            log.error("Erro validando Midias: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        midias = this.midiasService.persiste(midias);
        response.setData(this.converterMidiasParaDTo(midias));
        return  ResponseEntity.ok(response);

    }

    private void validarMidias(MidiasDto midiasDto, BindingResult result) {
        if (midiasDto.getNome().equals(null) || midiasDto.getNome() =="") {
            result.addError(new ObjectError("mídias", "Nome da mídia não informado"));
            return;
        }


        if (midiasDto.getDataUpload() == null || midiasDto.getDataUpload() == "") {
            result.addError(new ObjectError("mídias", "Data da mídia não informado"));
            return;
        }


        if (midiasDto.getDeletadoMidias() == null || midiasDto.getDeletadoMidias() == "") {
            result.addError(new ObjectError("mídias", "Deleted da mídia não informado"));
            return;
        }

    }


    private MidiasDto converterMidiasParaDTo(Midias midias){

        MidiasDto midiasDto = new MidiasDto();
        midiasDto.setId(midias.getId());
        midiasDto.setNome(midias.getNome());
        midiasDto.setDeletadoMidias(midias.getDeletadoMidias());
        midiasDto.setDuracao(midias.getDuracao());
        midiasDto.setUrl(midias.getUrl());
        midiasDto.setDataUpload(midias.getDataUpload() == null || midiasDto.getDataUpload() ==""
                ? null : this.dateFormat.format(midias.getDataUpload()));
        return midiasDto;
    }

    private Midias converterDtoParaMidia(MidiasDto midiasDto) throws ParseException {
        Midias midias = new Midias();
        midias.setNome(midiasDto.getNome());
        midias.setDuracao(midiasDto.getDuracao());
        midias.setDeletadoMidias(midiasDto.getDeletadoMidias());
        midias.setDataUpload(midiasDto.getDataUpload() =="" || midiasDto.getDataUpload() == null
                ? null: this.dateFormat.parse(midiasDto.getDataUpload()) );
        midias.setUrl(midiasDto.getUrl());
        return midias;
    }


}
