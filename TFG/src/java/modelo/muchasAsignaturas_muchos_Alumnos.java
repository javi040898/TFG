/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Javier
 */
public class muchasAsignaturas_muchos_Alumnos {
    
    private Integer codigo;
    private String DNI;



    public muchasAsignaturas_muchos_Alumnos(Integer codigo, String DNI) {
        this.codigo = codigo;
        this.DNI = DNI;
    }
    
        public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}
