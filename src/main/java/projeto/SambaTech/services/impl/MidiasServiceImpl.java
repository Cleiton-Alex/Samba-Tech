package projeto.SambaTech.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.SambaTech.entities.Midias;
import projeto.SambaTech.repositories.MidiasRepository;
import projeto.SambaTech.services.MidiasService;


import java.util.Optional;

@Service
public class MidiasServiceImpl implements MidiasService {
    private  static final Logger log = LoggerFactory.getLogger(MidiasServiceImpl.class);

    @Autowired
    private MidiasRepository midiasRepository;

    @Override
    public Midias persiste(Midias midias) {
        log.info("Persistindo Lancamento por ID {}", midias);
        return this.midiasRepository.save(midias);
    }

    @Override
    public Optional<Midias> buscarPorMidiasNaoDeletadas( String deletadoMidias) {
        log.info("Buscar Todas as midias ou midias que nao foram deletadas", deletadoMidias);
        return Optional.empty();
    }

    @Override
    public Optional<Midias> buscarPorMidiasID(Long id) {
        log.info("Buscar midia por ID {}", id);

        return this.midiasRepository.findById(id);
    }

    @Override
    public void remover(Long id) {
        log.info("Removendo midias por ID {}", id);
        this.midiasRepository.deleteById(id);
    }


}
