package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Producto;

public class ArregloProductos {
	private ArrayList<Producto> producto;
	
	public ArregloProductos() {
		producto = new ArrayList<Producto>();
		cargarProductos();
	}
	public void adicionar(Producto x) {
		producto.add(x);
		grabarProductos();
	}
	public void eliminar(Producto x) {
		producto.remove(x);
	  	ajustarCodigos();
		grabarProductos();
	}
	public int tamanio() {
		return producto.size();
	}
	public Producto obtener(int i) {
		return producto.get(i);
	}
	public Producto buscar(int codigo) {
		for (int i = 0; i < producto.size(); i++) {
			if (producto.get(i).getCodProducto() == codigo)
				return producto.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (producto.size() == 0)
			return 2001;
		return producto.get(producto.size()-1).getCodProducto() + 1;
	}
	public void ActualizarArchivo() {
		grabarProductos();
	}
	public void actualizarStock(int codProducto, int cantidad) {
        Producto producto = buscar(codProducto);
        if (producto != null) {
            producto.restarStock(cantidad);
            grabarProductos(); 
        } else {
            System.err.println("Producto no encontrado con codigo: " + codProducto);
        }
    }
	private void ajustarCodigos() {
	    for (int i = 0; i < producto.size(); i++) {
	        producto.get(i).setCodProducto(2001 + i);
	    }
	}
	private void grabarProductos() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("productos.txt"))) {
	        for (Producto x : producto) {
	            String linea = String.format("%s;%s;%.2f;%d;%d;%d;%d;%.3f",
	                    x.getCodProducto(),
	                    x.getModelo(),
	                    x.getPrecio(),		
	                    x.getStockActual(),
	                    x.getStockMinimo(),
	                    x.getStockMaximo(),
	            		x.getCantidadVendida(),
	            		x.getImporteAcumulado());
	            pw.println(linea);
	        }
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void cargarProductos() {
		try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
			String linea;
			
			while ((linea = br.readLine()) != null) {
				String[] s = linea.split(";");
				if (s.length >= 8) { 
                    try {
                    	int codProducto = Integer.parseInt(s[0].trim());
        				String nombre = s[1].trim();
        				double precio = Double.parseDouble(s[2].trim());
        				int stockActual = Integer.parseInt(s[3].trim());
        				int stockMinimo = Integer.parseInt(s[4].trim());
        				int stockMaximo = Integer.parseInt(s[5].trim());
        				int cantVendida = Integer.parseInt(s[6].trim());
        				double importeAcumulado = Double.parseDouble(s[7].trim());
        				adicionar(new Producto(codProducto, nombre, precio, stockActual , stockMinimo , stockMaximo,cantVendida,importeAcumulado));

                    } catch (NumberFormatException e) {
                        System.err.println("Error: Formato incorrecto en los datos de los productos: " + linea);
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
