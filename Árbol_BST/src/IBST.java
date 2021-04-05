public interface IBST {
    
    void insertar(Object obj);

    boolean existe(int id);

    Object obtener(int id);

    boolean esHoja();

    boolean esVacio();

    void preOrden();

    void enOrden();

    void postOrden();

    void eliminar(int id);

}
