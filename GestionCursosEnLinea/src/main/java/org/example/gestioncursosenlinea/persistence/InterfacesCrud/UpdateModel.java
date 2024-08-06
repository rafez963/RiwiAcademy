package org.example.gestioncursosenlinea.persistence.InterfacesCrud;

import java.sql.SQLException;

public interface UpdateModel <Entity>{
    public Entity update(Entity request, int id) throws SQLException;
}
