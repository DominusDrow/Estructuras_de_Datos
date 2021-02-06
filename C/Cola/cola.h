
//creacion de la cola de pedidos

#ifndef cola_h
#define cola_h

#include <stdio.h>
#include <stdlib.h>
#include "pedido.h"

/*
 *estructura para almacenar clientes cada uno con
 * "n" numero de pedidos
 */
typedef struct NodoPedido{
    Pedido* pedido;
    struct NodoPedido* sig;
}NodoPedido;

/*
 *estructura que guarda el principio y fin de la cola
 */
typedef struct Cola{
    NodoPedido* primero;
    NodoPedido* ultimo;
}Cola;

//operaciones con la cola:

NodoPedido* CrearNodo(Pedido* pedido){

    NodoPedido* nodo = (NodoPedido*) malloc(sizeof(NodoPedido));
    nodo->pedido=pedido;
    nodo->sig=NULL;
    return nodo;
}

void DestruirNodo(NodoPedido* pedido){

    pedido->pedido=NULL;
    pedido->sig=NULL;
    free(pedido);
}


Cola* CrearCola(){
    
    Cola* cola = (Cola*) malloc(sizeof(Cola));
    cola->primero=cola->ultimo=NULL;            //forma elegante de asiganar un mismo valor a dos variables 7w7
    return cola;
}

void DestruirCola(Cola* cola){

    while(cola->primero)
        Eliminar(cola);

    free(cola);
}


void Encolar(Cola* cola, Pedido* pedido){

    NodoPedido* nodo= CrearNodo(pedido);

    if(!cola->primero)
        cola->primero=cola->ultimo=nodo;
    else{
        cola->ultimo->sig=nodo;
        cola->ultimo=nodo;
    }
}

Pedido* Consultar(Cola* cola){

    if(cola->primero)
        return cola->primero->pedido;
    else
        return NULL;
}

void Eliminar(Cola* cola){

    if(cola->primero){
        NodoPedido* Eliminado=cola->primero;
        cola->primero=cola->primero->sig;
        DestruirNodo(Eliminado);

        if(!cola->primero)
            cola->ultimo=NULL;
    }
}


#endif //cola_h