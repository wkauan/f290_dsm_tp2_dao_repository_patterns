package services;

import java.util.List;
import java.util.Objects;

import domain.ContatoVO;
import repositories.IContatoRepository;

public class ContatoService implements IContadoService {

    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(ContatoVO contato) {
        // Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }

        if (Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório!");
        }

        repository.salvar(contato);
    }

    @Override
    public void alterar(ContatoVO contato) {
        // Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getId())) {
            throw new RuntimeException("ID é obrigatório para a alteração!");
        }

        if (Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }

        if (Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório!");
        }

        // Consultar e recuperar contato
        ContatoVO contatoExistente = repository.buscarPorId(contato.getId());

        if (contatoExistente == null) {
            throw new RuntimeException("Contato não encontrado!");
        }

        // Alterar contato
        repository.alterar(contato);
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        // Validar e-mail
        if (Objects.isNull(email) || email.isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório para a busca!");
        }

        // Localizar contato e retornar contato
        return repository.buscarPorEmail(email);
    }

    @Override
    public void excluir(Integer id) {
        // Validar id
        if (Objects.isNull(id)) {
            throw new RuntimeException("ID é obrigatório para a exclusão!");
        }

        // Localizar contato e excluir contato
        repository.excluir(id);
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // Consultar e retornar todos os contatos cadastrados
        return repository.buscarTodos();
    }
}
