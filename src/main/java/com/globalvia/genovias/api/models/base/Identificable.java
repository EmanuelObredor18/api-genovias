package com.globalvia.genovias.api.models.base;

/**
 * Interfaz Identificable.
 * 
 * Esta interfaz define un contrato para clases que deben proporcionar una forma 
 * de obtener un identificador único. Implementar esta interfaz garantiza que 
 * una entidad o modelo puede ser identificado de manera única por un campo de 
 * tipo genérico.
 * 
 * @param <ID> el tipo de identificador que la clase usará, que podría ser un 
 *             número, una cadena u otro tipo de objeto.
 */
public interface Identificable<ID> {

    /**
     * Obtiene el identificador único de la entidad.
     * 
     * @return el identificador único de tipo {@code ID}.
     */
    ID getId();
}
