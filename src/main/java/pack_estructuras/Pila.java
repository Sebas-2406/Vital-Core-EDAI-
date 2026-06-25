/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack_estructuras;

/**
 *
 * @author DELL
 */
public class Pila<T> {
    
    private Nodo<T> cima; // Puntero al elemento en la cima
    private int tamaño;   // Contador para obtener la cantidad de elementos

    // Constructor para inicializar la pila
    public Pila() {
        this.cima = null;
        this.tamaño = 0;
    }

    public void apilar(T dato) {
        //Creación del nuevo nodo con el dato
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        nuevoNodo.setSiguiente(cima);
        
        cima = nuevoNodo;
        
        tamaño++;
    }

    public T desapilar() {
        if (estaVacia()) {
            return null; // Protección contra desbordamientos (Underflow)
        }
        
        // 1. Rescatamos el dato que está en el tope
        T datoExtraido = cima.getDato();
        
        // 2. La nueva cima baja al siguiente nodo (descartando el tope actual)
        cima = cima.getSiguiente();
        
        // 3. Reducimos el contador
        tamaño--;
        
        return datoExtraido;
    }

    public T verCima() {
        if (estaVacia()) {
            return null;
        }
        return cima.getDato();
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void vaciar() {
        cima = null;
        tamaño = 0;
    }
}
