package biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public boolean isDisponivel() { return disponivel; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() { return titulo + " - " + autor; }
}