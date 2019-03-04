/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming_3_assigment;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah Shublaq
 */
public class Main_Exeption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1.x :");
        try {
            throw new SecondExeption("ExceptionB");
        } catch (FirstExeption ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new ThirdExeption("ThirdExeption");
        } catch (FirstExeption ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("--------\n1.y :");
        try {
            throw new FirstExeption("ExceptionA");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new SecondExeption("ExceptionB");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new NullPointerException("NullPointerException");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new InputMismatchException("InputMismatchException");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("--------\n2 :");
        try {
            someMethod();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void someMethod() throws Exception {
        someMethod2();
    }

    public static void someMethod2() throws Exception {
        throw new Exception("Error");
    }
}
