public class UsuarioPlataforma{
  private Usuario usuario;
  private boolean esPremium;

  public UsuarioPlataforma(Usuario usuario, boolean esPremium){
    this.usuario = usuario;
    this.esPremium = esPremium;
  }

  public Usuario getUsuario(){
    return this.usuario;
  }

  public boolean getEsPremium(){
    return this.esPremium;
  }

  public void setEsPremium(boolean esPremium){
    this.esPremium = esPremium;
  }
}
