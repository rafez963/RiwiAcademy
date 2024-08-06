package org.example.gestioncursosenlinea.persistence.IModel;

import org.example.gestioncursosenlinea.entities.Student;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.CreateModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.ReadAllByIdModel;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.ReadByEmail;
import org.example.gestioncursosenlinea.persistence.InterfacesCrud.UpdateModel;

public interface IStudentModel extends
        CreateModel<Student>,
        UpdateModel<Student>,
        ReadAllByIdModel<Student>,
        ReadByEmail<Student>
{
}
