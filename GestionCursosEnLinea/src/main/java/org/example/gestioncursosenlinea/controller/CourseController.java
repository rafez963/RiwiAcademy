package org.example.gestioncursosenlinea.controller;

import org.example.gestioncursosenlinea.entities.Course;
import org.example.gestioncursosenlinea.model.CourseModel;

import javax.swing.*;

public class CourseController  {
    CourseModel courseModel;

    public CourseController() {
        this.courseModel = courseModel;
    }

        public void create(){
            String name = JOptionPane.showInputDialog("Ingrese el nombre del curso, por favor: ");
            String description  = JOptionPane.showInputDialog("Ingrese un description del course: ");

            Course course;

            course = new Course(0,name, description);
            System.out.println("Creation on");
        };

        public void delete(){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del estudiante que desea eliminar. "));
            courseModel.delete(id);
        }

        public void edit(){
            String name =  JOptionPane.showInputDialog("INGRESE EL NUEVO NOMBRE DEL CURSO: ");
            String description = JOptionPane.showInputDialog("Ingrese la nueva descripcion del curso: ");

            Course course = new Course(0, name, description);

        }
}

