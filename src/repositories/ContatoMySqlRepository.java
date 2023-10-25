package repositories;

import java.util.List;

import dao.factories.IContatoDAO;
import domain.ContatoVO;

public class ContatoMySqlRepository implements IContatoRepository {

    private IContatoDAO dao;

    public ContatoMySqlRepository(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO contato) {
        // Chama o método salvar do DAO para persistir o contato.
        dao.salvar(contato);
    }

    @Override
    public void atualizar(ContatoVO contato) {
        // Chama o método de atualização do DAO para modificar o contato existente.
        dao.atualizar(contato);
    }

    @Override
    public void excluir(Integer id) {
        // Chama o método de exclusão do DAO para remover o contato pelo ID.
        dao.excluir(id);
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // Chama o método de busca de todos os contatos do DAO.
        return dao.buscarTodos();
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        // Chama o método de busca por e-mail do DAO para encontrar um contato específico.
        return dao.buscarPorEmail(email);
    }
}
