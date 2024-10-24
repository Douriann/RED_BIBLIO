/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author scocl
 */
public class Profesor extends Usuario{
   
    private String idTituloAcademico;
    private String idDepartamento;

    public String getIdTituloAcademico() {
        return idTituloAcademico;
    }

    public void setIdTituloAcademico(String idTituloAcademico) {
        this.idTituloAcademico = idTituloAcademico;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
}
