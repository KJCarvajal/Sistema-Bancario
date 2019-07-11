package Menjivar;

import Menjivar.excepciones.ErrorValidacion;

public class Cliente{

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Cliente(String id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getter y Setter Id
    public String getId(){
        return id;
    }
    public void setId(String id) throws Exception{
        if(id.length() != 13){
            throw new ErrorValidacion("El numero de identidad debe contener 13 caracteres");
        }
        this.id = id;
    }

    //Getter y Setter Apellido
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    //Getter y Setter Email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) throws ErrorValidacion{
        if(!email.matches("^[A-Za-z0-9_]+@[a-z]+\\.[a-z]{2,}$")) {
            this.email = email;
        }
    }

    //Setter Telefono
    public void setTelefono(String telefono) throws ErrorValidacion{
        if(!telefono.matches("^(\\+504\\s?)?[0-9]{4}\\-?[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }
}