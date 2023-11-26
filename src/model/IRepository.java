package model;

import java.util.List;

public interface IRepository<T> {
    void salvar(List<T> dados);

    List<T> carregar();
}