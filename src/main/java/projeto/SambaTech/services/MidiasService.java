package projeto.SambaTech.services;

import projeto.SambaTech.entities.Midias;

import java.util.Optional;

public interface MidiasService {

    Midias persiste(Midias midias);

    /**
     * Buscar e retorna todas as Midias ou midias que nao foram Deletadas
     *
     * @param deletadoMidias
     * @return Optional<Midias>
     */
    Optional<Midias> buscarPorMidiasNaoDeletadas(String deletadoMidias);


    /**
     * Buscar e retorna uma Midia dado o id
     *
     * @param id
     * @return Optional<Midias>
     */
    Optional<Midias> buscarPorMidiasID(Long id);


    /**
     * Removo uma midia dado o id
     *
     * @param id
     * */
    void remover(Long id);
}


