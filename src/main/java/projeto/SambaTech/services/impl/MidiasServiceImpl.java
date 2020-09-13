package projeto.SambaTech.services.impl;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import projeto.SambaTech.entities.Midias;
import projeto.SambaTech.repositories.MidiasRepository;
import projeto.SambaTech.services.MidiasService;
import sun.rmi.runtime.Log;

import java.util.Optional;

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
    public Optional<Midias> buscarPorMidiasNaoDeletadas( Boolean deleted) {
        log.info("Buscar Todas as midias ou midias que nao foram deletadas", deleted);
        return Optional.ofNullable(this.midiasRepository.findByDeleted(deleted));
    }

    @Override
    public Optional<Midias> buscarPorMidiasID(Long id) {
        log.info("Buscar midia por ID {}", id);
        Optional byId = Optional.ofNullable(this.midiasRepository.findById(id));
        return byId;
    }

    @Override
    public void remover(Long id) {

    }


}
