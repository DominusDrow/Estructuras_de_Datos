
#include <stdio.h>
#include "Pila.h"

int main(int argc, char const *argv[]){
    
    pila* Urls= CrearPila();

    Apilar(Urls,"www.google.com");
    Apilar(Urls, "www.youtube.com");

    printf("\nURL en la cima: %s ",Cima(Urls));
    Desapilar(Urls);
    printf("\nURL en la cima: %s ",Cima(Urls));
    Desapilar(Urls);
    printf("\nURL en la cima: %s ",Cima(Urls));

    return 0;
}
