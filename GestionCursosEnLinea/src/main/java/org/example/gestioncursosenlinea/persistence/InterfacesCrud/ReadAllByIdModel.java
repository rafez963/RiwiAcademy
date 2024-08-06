package org.example.gestioncursosenlinea.persistence.InterfacesCrud;

import java.util.List;

public interface ReadAllByIdModel<Entity>{
    public List<Entity> readAll(int id);
}
