package com.globalvia.genovias.api.models.base;

/**
 * Interfaz Copyable.
 * 
 * Esta interfaz define un contrato para crear una copia modificada de un objeto.
 * Implementar esta interfaz permite realizar copias de un objeto existente, 
 * conservando sus propiedades originales pero con la posibilidad de modificar
 * ciertos atributos según se especifique.
 * 
 * @param <T> el tipo de objeto que se va a copiar.
 */
public interface Copyable<T, ID> {

    /**
     * Crea una copia del objeto actual, aplicando los cambios especificados en el objeto
     * pasado como parámetro. Los campos que no se especifiquen en el objeto de entrada
     * mantendrán sus valores originales.
     * 
     * @param copy un objeto de tipo {@code T} que contiene los valores que se desean
     *             modificar en la copia.
     * @return una nueva instancia de {@code T} con los valores modificados según el 
     *         objeto pasado, y los demás valores iguales al objeto original.
     */
    T copyWith(T copy);

    T copyId(ID id);
}
