package clases;

public class Producto {
	//Declaracion de variables globales
	private int codProducto, stockActual, stockMinimo, stockMaximo, cantidadVendida;
	private double precio, importeAcumulado;
	private String modelo;
	
	//Declaracion de atributos del constructor Producto
	public Producto(int codProducto, String modelo, double precio, int stockActual, int stockMinimo, int stockMaximo, int cantidadVendida, double importeAcumulado) {
		this.codProducto = codProducto;
		this.modelo = modelo;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.cantidadVendida = cantidadVendida;
		this.importeAcumulado = importeAcumulado;
	}
	
	//Getters de atributos del constructor Producto
	public int getCodProducto() {
		return codProducto;
	}
	public String getModelo() {
		return modelo;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStockActual() {
		return stockActual;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public int getStockMaximo() {
		return stockMaximo;
	}
	public int getCantidadVendida() {
		return cantidadVendida;
	}
	public double getImporteAcumulado() {
		return importeAcumulado;
	}
	
	//Setters de atributos del constructor Producto
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public void setStockMinimo(int nStockMin) {
		this.stockMinimo = nStockMin;
	}
	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}
	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	public void setImporteAcumulado(double importeAcumulado) {
		this.importeAcumulado = importeAcumulado;
	}
	
	//Resta del Stock Actual la cantidad vendida
	public void restarStock(int cantidad) {
        this.stockActual -= cantidad;
    }
}
