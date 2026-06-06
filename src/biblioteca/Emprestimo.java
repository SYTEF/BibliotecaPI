package biblioteca;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private Livro livro;
    private String dataEmprestimo;
    private String status;

    public Emprestimo(int id, Usuario usuario, Livro livro) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        java.time.LocalDate hoje = java.time.LocalDate.now();
        this.dataEmprestimo = hoje.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.status = "ATIVO";
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public String getDataEmprestimo() { return dataEmprestimo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void devolver() {
        this.status = "DEVOLVIDO";
        this.livro.setDisponivel(true);
    }
}