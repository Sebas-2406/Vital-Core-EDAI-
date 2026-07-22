/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack_estructuras;

/**
 *
 * @author Invitado 1
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    // Método para encolar (Agregar al final)
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        tamaño++;
    }

    // Método para desencolar (Atender al paciente del frente)
    public T desencolar() {
        if (estaVacia()) {
            return null; // O lanzar una excepción personalizada
        }
        T datoFrente = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamaño--;
        return datoFrente;
    }

    // Ver el próximo elemento sin sacarlo de la cola
    public T verFrente() {
        return estaVacia() ? null : frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamaño() {
        return tamaño;
    }
    
    // Método útil para volcar los datos a la tabla de Java Swing
    public java.util.List<T> obtenerElementos() {
        java.util.List<T> lista = new java.util.ArrayList<>();
        Nodo<T> actual = frente;
        while (actual != null) {
            lista.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        return lista;
    }
    
    
}
