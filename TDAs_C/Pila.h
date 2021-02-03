
#ifndef Pila.h
#define Pila.h

#include <stdlib.h>
#include <stdio.h>

typedef char* URL;

typedef struct nodo{
    URL url;
    struct nodo* sig;
}Nodo;

typedef struct pila
{
    Nodo* cima;
    int longitud;
}pila;

Nodo* CrearNodo(URL url){
    
    Nodo* nodo = (Nodo*) malloc(sizeof(Nodo));
    nodo->url=url;
    nodo->sig=NULL;
    return nodo;
}

void DestruirNodo(Nodo* nodo){
    nodo->sig=NULL;
    free(nodo);
}

pila* CrearPila(){

    pila* PILA= (pila*) malloc(sizeof(pila));
    PILA->cima=NULL;
    PILA->longitud=0;
    return PILA;
}

void DestruirPila(pila* pila){

    while (pila->cima!=NULL) 
        Desapilar(pila);

    free(pila);
}


void Apilar(pila* pila, URL url){

    Nodo* nodo = CrearNodo(url);
    nodo->sig=pila->cima;
    pila->cima=nodo;
    pila->longitud++;
}

void Desapilar(pila* pila){

    if(pila->cima!=NULL){

        Nodo* eliminar= pila->cima;
        pila->cima=pila->cima->sig;
        DestruirNodo(eliminar);
        pila->longitud--;
    }
}

URL Cima(pila* pila){
    
    if(pila->cima==NULL)
        return NULL;
    else
        return pila->cima->url;
}


int LongitudPila(pila* pila){
    return pila->longitud;
}

int EstaVacia(pila* pila){
    
    if(pila->longitud!=0)
        return 1;
    else
        return 0;
}

#endif //Pila.h