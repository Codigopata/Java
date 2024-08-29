package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Cliente;

public class ArregloClientes {
	private ArrayList<Cliente> cliente;
	
	public ArregloClientes() {
		cliente = new ArrayList<Cliente>();

		cargarClientes();
	}
	
	public void adicionar(Cliente x) {
		cliente.add(x);
		grabarClientes();
	}
	public void eliminar(Cliente x) {
		cliente.remove(x);
		ajustarCodigos();
		grabarClientes();
	}
		private void ajustarCodigos() {
		    for (int i = 0; i < cliente.size(); i++) {
		        cliente.get(i).setCodCliente(1001 + i);
		    }
		}
	public int tamanio() {
		return cliente.size();
	}
	public Cliente obtener(int i) {
		return cliente.get(i);
	}
	public Cliente buscar(int codigo) {
		for (int i = 0; i < cliente.size(); i++) {
			if (cliente.get(i).getCodCliente() == codigo)
				return cliente.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (cliente.size() == 0) return 1001;
		return cliente.get(cliente.size()-1).getCodCliente() + 1;
	}
	public void ActualizarArchivo() {
		grabarClientes();
	}
	
	private void grabarClientes() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("clientes.txt"))) {
	        for (Cliente x : cliente) {
	            String linea = String.format("%s;%s;%s;%s;%s;%s;%d",
	                    x.getCodCliente(),
	                    x.getNombres(),
	                    x.getApellidos(),
	                    x.getDireccion(),
	                    x.getTelefono(),
	                    x.getDni(),
	                    x.getEdad());
	            pw.println(linea);
	        }
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void cargarClientes() {
		try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {

			String linea;
			
			while ((linea = br.readLine()) != null) {
				String[] s = linea.split(";");
				
				if (s.length >= 7) { 
                    try {
                    	int codCliente = Integer.parseInt(s[0].trim());
        				String nombres = s[1].trim();
        				String apellidos = s[2].trim();
        				String direccion = s[3].trim();
        				int telefono = Integer.parseInt(s[4].trim());
        				String dni = s[5].trim();
        				int edad = Integer.parseInt(s[6].trim());
        				adicionar(new Cliente(codCliente, nombres, apellidos, direccion , telefono , dni, edad));

                    } catch (NumberFormatException e) {
                        System.err.println("Error: Formato incorrecto en los datos de los clientes: " + linea);
                    }
                } else {
                    System.err.println("Error: línea incorrecta o incompleta en el archivo: " + linea);
                }
			}
		}
		catch (Exception e) {
	        System.err.println("Error al procesar el archivo: " + e.getMessage());
	        e.printStackTrace();
		}
	}
}
