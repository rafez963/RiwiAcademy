package org.example.gestioncursosenlinea.persistence.InterfacesCrud;

import java.util.List;

public interface ReadByEmail <Entity>{
    public List<Entity> readByEmail(String email);
}
