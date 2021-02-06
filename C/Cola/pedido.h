
//estructuras que se utilizaran para construir la cola

#ifndef pedido_h
#define pedido_h

#include <stdio.h>

/*
 *estructura con los campos para un producto
 */
typedef struct LineaPedido{    
    int id_producto;
    int cantidad;
    float precio_unidad;
}LineaPedido;

/*
 *estructura para tener varios productos
 */
typedef struct NodoLineaPedido{
    LineaPedido linea;
    struct NodoLineaPedido* sig;
}NodoLineaPedido;

/*
 *estructura para que cada cliente tenga "n" productos encargados
 */
typedef struct Pedido{
    int id_cleinte;
    NodoLineaPedido* lista_produtos;
}Pedido;


#endif //pedido
