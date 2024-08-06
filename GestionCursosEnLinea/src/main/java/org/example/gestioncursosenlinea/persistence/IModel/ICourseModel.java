package org.example.gestioncursosenlinea.persistence.IModel;

import org.example.gestioncursosenlinea.entities.Course;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.CreateModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.DeleteModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.ReadAllByIdModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.UpdateModel;

public interface ICourseModel extends
        CreateModel<Course>,
        UpdateModel<Course>,
        ReadAllByIdModel<Course>,
        DeleteModel<Integer>
{
}
