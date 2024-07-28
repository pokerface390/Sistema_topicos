/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesStaticas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Usuario {

    private String rfcEmpleado;
    private String nombre;
    private String apellido;
    private String puesto;
    private String correo;
    private String contrasena; // Almacena el hash de la contraseña
    private int idEstacionT;

    public Usuario(String rfcEmpleado, String nombre, String apellido, String puesto, String correo, String contrasena, int idEstacionT) {
        this.rfcEmpleado = rfcEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.correo = correo;
        this.contrasena = hashPassword(contrasena); // Encriptar contraseña al inicializar
        this.idEstacionT = idEstacionT;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = hashPassword(contrasena); // Encriptar nueva contraseña al cambiar
    }

    public int getIdEstacionT() {
        return idEstacionT;
    }

    public void setIdEstacionT(int idEstacionT) {
        this.idEstacionT = idEstacionT;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "rfcEmpleado='" + rfcEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", idEstacionT=" + idEstacionT +
                '}';
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16]; 
        sr.nextBytes(salt);
        return salt;
    }

    private static String hashPassword(String password) {
        try {
            byte[] salt = getSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashedPasswordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

            return saltBase64 + ":" + hashedPasswordBase64;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkPassword(String password, String stored) {
        try {
            String[] parts = stored.split(":");
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] storedHash = Base64.getDecoder().decode(parts[1]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            return MessageDigest.isEqual(storedHash, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
