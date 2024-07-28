/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesStaticas;

public class Validacion {

    // Validar correo electrónico
    public boolean validarCorreoElectronico(String email) {
        boolean bandera = false;
        String validar[] = {"@gmail.com", "@hotmail.com", "@itoaxaca.edu.mx", "@yahoo.com"};
        if (email.contains("@")) {
            String dominio = email.substring(email.indexOf("@"));
            for (String valido : validar) {
                if (dominio.equals(valido)) {
                    bandera = true;
                }
            }
        }
        return bandera;
    }

    public boolean ValidarNumero(int numero, int cantidad) {
        String validar = String.valueOf(numero);
        int valor = validar.length();
        return cantidad == valor;
    }

    public boolean validarLetras(String texto) {
        String regex = "^[\\p{L} .'-]+$";
        return texto.matches(regex);
    }

    


    public boolean validarContraseña(String contraseña) {
        if (contraseña.length() != 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
