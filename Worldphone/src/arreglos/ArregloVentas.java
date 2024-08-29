package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Ventas;

public class ArregloVentas {
	private ArrayList<Ventas> ventas;
	
	public ArregloVentas() {
		ventas = new ArrayList<Ventas>();

		cargarVentas();
	}
	
	public void adicionar(Ventas x) {
		ventas.add(x);
		grabarVentas();
	}
	public void eliminar(Ventas x) {
		ventas.remove(x);
	  	ajustarCodigos();
		grabarVentas();
	}
		private void ajustarCodigos() {
		    for (int i = 0; i < ventas.size(); i++) {
		        ventas.get(i).setCodVentas(3001 + i);
		    }
		}
	public int tamanio() {
		return ventas.size();
	}
	public Ventas obtener(int i) {
		return ventas.get(i);
	}
	public Ventas buscar(int codigo) {
		for (int i = 0; i < ventas.size(); i++) {
			if (ventas.get(i).getCodVentas() == codigo)
				return ventas.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (ventas.size() == 0) return 3001;
		return ventas.get(ventas.size()-1).getCodVentas() + 1;
	}
	public void ActualizarArchivo() {
		grabarVentas();
	}
	
	private void grabarVentas() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("ventas.txt"))) {
	        for (Ventas x : ventas) {
	            String linea = String.format("%s;%s;%s;%s;%s;%s;%d;%.2f;%.3f;%.3f;%.3f",
	                    x.getCodVentas(),
	                    x.getCodCliente(),
	                    x.getCodProducto(),		
	                    x.getNombreProducto(),
	                    x.getNombreCliente(),
	                    x.getFecha(),
	                    x.getCantidadUnidadesVendidas(),
	            		x.getPrecioUnitario(),
	            		x.getImporteSubtotal(),
	            		x.getImporteIGV(),
	            		x.getImporteTotalPagar());
	            pw.println(linea);
	        }
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	private void cargarVentas() {
		try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
			
			String linea;
				
			while ((linea = br.readLine()) != null) {
				String[] s = linea.split(";");
				 if (s.length >= 11) { 
	                    try {
	                        int codVentas = Integer.parseInt(s[0].trim());
	                        int codCliente = Integer.parseInt(s[1].trim());
	                        int codProducto = Integer.parseInt(s[2].trim());
	                        String nombreProducto = s[3].trim();
	                        String nombreCliente = s[4].trim();
	                        String fecha = s[5].trim();
	                        int cantidadUnidadesVendidas = Integer.parseInt(s[6].trim());
	                        double precioUnitario = Double.parseDouble(s[7].trim());
	                        double importeSubTotal = Double.parseDouble(s[8].trim());
	                        double importeIGV = Double.parseDouble(s[9].trim());
	                        double importeTotalPagar = Double.parseDouble(s[10].trim());

	                        adicionar(new Ventas(codVentas , codCliente, codProducto, nombreProducto, nombreCliente, fecha,
	        						cantidadUnidadesVendidas,precioUnitario, importeSubTotal, importeIGV, importeTotalPagar));
	                    } catch (NumberFormatException e) {
	                        System.err.println("Error: Formato incorrecto en los datos de la venta: " + linea);
	                        // Puedes manejar el error de conversión aquí, por ejemplo, omitir la línea o registrar el error
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
