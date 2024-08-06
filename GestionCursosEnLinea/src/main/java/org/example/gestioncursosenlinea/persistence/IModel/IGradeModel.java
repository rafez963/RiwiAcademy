package org.example.gestioncursosenlinea.persistence.IModel;

import org.example.gestioncursosenlinea.entities.Grade;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.CreateModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.DeleteModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.UpdateModel;

public interface IGradeModel extends
        CreateModel<Grade>,
        DeleteModel<Integer>,
        UpdateModel<Grade> {


}
