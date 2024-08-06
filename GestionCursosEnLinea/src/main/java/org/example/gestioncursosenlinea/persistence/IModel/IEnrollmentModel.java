package org.example.gestioncursosenlinea.persistence.IModel;

import org.example.gestioncursosenlinea.entities.Enrollment;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.CreateModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.DeleteModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.ReadAllByIdModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.UpdateModel;

public interface IEnrollmentModel extends
        CreateModel<Enrollment>,
        DeleteModel<Integer>,
        UpdateModel<Enrollment>,
        ReadAllByIdModel<Integer>
{
}
