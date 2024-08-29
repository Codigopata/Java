package clases;

public class Cliente{
	//atributos
	private int CodCliente, edad, telefono;
	private String nombres, apellidos,direccion, dni;
	
	// Constructor
	
	public Cliente(int CodCliente, String nombres, String apellidos, String direccion, int telefono , String dni, int edad) {
		this.CodCliente=CodCliente;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.telefono=telefono;
		this.dni=dni;
		this.edad=edad;
	}
	
	public int getCodCliente() {
		return CodCliente;
	}
		
	public void setCodCliente(int CodCliente) {
		this.CodCliente = CodCliente;
	}
	
		public String getNombres() {
			return nombres;
		}
	
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
	
		public String getApellidos() {
			return apellidos;
		}
	
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		
		public String getDireccion() {
			return direccion;
		}
		
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
			public int getTelefono() {
				return telefono;
			}
	
			public void setTelefono(int telefono) {
				this.telefono = telefono;
			}
			
			
			public String getDni() {
				return dni;
			}
			public void setDni(String dni) {
				this.dni = dni;
			}
			
			public int getEdad() {
				return edad;
			}
	
			public void setEdad(int edad) {
				this.edad = edad;
			}
}